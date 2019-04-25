package com.ssm.lab.service.impl;

import com.ssm.lab.bean.*;
import com.ssm.lab.dao.ExperimentWorkloadItemMapper;
import com.ssm.lab.dao.ExperimentWorkloadMapper;
import com.ssm.lab.dao.PracticeWorkloadItemMapper;
import com.ssm.lab.dao.PracticeWorkloadMapper;
import com.ssm.lab.service.ExperimentWorkloadService;
import com.ssm.lab.service.PracticeWorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("practiceWorkloadService")
public class PracticeWorkloadServiceImpl implements PracticeWorkloadService {

    @Autowired
    private PracticeWorkloadMapper practiceWorkloadMapper;
    @Autowired
    private PracticeWorkloadItemMapper practiceWorkloadItemMapper;

    @Override
    public PracticeWorkload getByid(Integer id) {
        return practiceWorkloadMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PracticeWorkload> getAll() {
        return practiceWorkloadMapper.selectByExample(null);
    }

    @Override
    public int remove(String id) {
        List<String> stringList = Arrays.asList(id.split(","));
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringList) {
            integerList.add(Integer.parseInt(str));
        }

        PracticeWorkloadExample example = new PracticeWorkloadExample();
        example.or().andIdIn(integerList);
        return practiceWorkloadMapper.deleteByExample(example);
    }

    @Override
    public int add(PracticeWorkload workload) {
        return practiceWorkloadMapper.insertSelective(workload);
    }

    @Override
    public void save(PracticeWorkload workload, List<PracticeWorkloadItem> items) {
        practiceWorkloadMapper.insert(workload);
        for (PracticeWorkloadItem item : items) {
            item.setPracticeWorkloadId(workload.getId());
            //教师编号处理19820002 马春江，只提取教工号
            String[] split = item.getTeacherSn().trim().split(" ");
            item.setTeacherSn(split[0]);
            practiceWorkloadItemMapper.insertSelective(item);
        }
    }

    @Override
    public void edit(PracticeWorkload workload, List<PracticeWorkloadItem> items) {
        practiceWorkloadMapper.updateByPrimaryKeySelective(workload);
        List<PracticeWorkloadItem> olds = getItems(workload.getId());
        for (PracticeWorkloadItem old : olds) {
            boolean isHave = false;
            for (PracticeWorkloadItem item : items) {
                if (item.getId() == old.getId()) {
                    isHave = true;
                    break;
                }
            }
            if (!isHave) {
                practiceWorkloadItemMapper.deleteByPrimaryKey(old.getId());
            }
        }
        for (PracticeWorkloadItem item : items) {
            item.setPracticeWorkloadId(workload.getId());
            //教师编号处理19820002 马春江，只提取教工号
            String[] split = item.getTeacherSn().trim().split(" ");
            item.setTeacherSn(split[0]);
            if (item.getId() != null && item.getId() > 0) {
                practiceWorkloadItemMapper.updateByPrimaryKeySelective(item);
            } else {
                practiceWorkloadItemMapper.insertSelective(item);
            }
        }
    }

    @Override
    public List<String> getAllTerm() {
        return practiceWorkloadMapper.selectAllTerm();
    }

    @Override
    public List<PracticeWorkloadItem> getItems(Integer id) {
        PracticeWorkloadItemExample example = new PracticeWorkloadItemExample();
        example.or().andPracticeWorkloadIdEqualTo(id);
        return practiceWorkloadItemMapper.selectByExample(example);
    }

    @Override
    public List<PracticeWorkload> getByType(String term, String workloadType, String type, String keywords) {
        return practiceWorkloadMapper.selectByType(term, workloadType, type, keywords);
    }

}
