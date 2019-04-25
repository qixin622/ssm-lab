package com.ssm.lab.service.impl;

import com.ssm.lab.bean.ExperimentWorkload;
import com.ssm.lab.bean.ExperimentWorkloadExample;
import com.ssm.lab.bean.ExperimentWorkloadItem;
import com.ssm.lab.bean.ExperimentWorkloadItemExample;
import com.ssm.lab.dao.ExperimentWorkloadItemMapper;
import com.ssm.lab.dao.ExperimentWorkloadMapper;
import com.ssm.lab.dto.ExperimentWorkloadInfo;
import com.ssm.lab.service.ExperimentWorkloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("experimentWorkloadService")
public class ExperimentWorkloadServiceImpl implements ExperimentWorkloadService {

    @Autowired
    private ExperimentWorkloadMapper experimentWorkloadMapper;
    @Autowired
    private ExperimentWorkloadItemMapper experimentWorkloadItemMapper;

    @Override
    public ExperimentWorkload getByid(Integer id) {
        return experimentWorkloadMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExperimentWorkload> getAll() {
        return experimentWorkloadMapper.selectByExample(null);
    }

    @Override
    public int remove(String id) {
        List<String> stringList = Arrays.asList(id.split(","));
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringList) {
            integerList.add(Integer.parseInt(str));
        }

        ExperimentWorkloadExample example = new ExperimentWorkloadExample();
        example.or().andIdIn(integerList);
        return experimentWorkloadMapper.deleteByExample(example);
    }

    @Override
    public int add(ExperimentWorkload workload) {
        return experimentWorkloadMapper.insertSelective(workload);
    }

    @Override
    public void save(ExperimentWorkload workload, List<ExperimentWorkloadItem> items) {
        experimentWorkloadMapper.insert(workload);
        for (ExperimentWorkloadItem item : items) {
            item.setExperimentWorkloadId(workload.getId());
            //教师编号处理19820002 马春江，只提取教工号
            String[] split = item.getTeacherSn().trim().split(" ");
            item.setTeacherSn(split[0]);
            experimentWorkloadItemMapper.insertSelective(item);
        }
    }

    @Override
    public void edit(ExperimentWorkload workload, List<ExperimentWorkloadItem> items) {
        experimentWorkloadMapper.updateByPrimaryKeySelective(workload);
        List<ExperimentWorkloadItem> olds = getItems(workload.getId());
        for (ExperimentWorkloadItem old : olds) {
            boolean isHave = false;
            for (ExperimentWorkloadItem item : items) {
                if (item.getId() == old.getId()) {
                    isHave = true;
                    break;
                }
            }
            if (!isHave) {
                experimentWorkloadItemMapper.deleteByPrimaryKey(old.getId());
            }
        }
        for (ExperimentWorkloadItem item : items) {
            item.setExperimentWorkloadId(workload.getId());
            //教师编号处理19820002 马春江，只提取教工号
            String[] split = item.getTeacherSn().trim().split(" ");
            item.setTeacherSn(split[0]);
            if (item.getId() != null && item.getId() > 0) {
                experimentWorkloadItemMapper.updateByPrimaryKeySelective(item);
            } else {
                experimentWorkloadItemMapper.insertSelective(item);
            }
        }
    }

    @Override
    public List<String> getAllTerm() {
        return experimentWorkloadMapper.selectAllTerm();
    }

    @Override
    public List<ExperimentWorkloadItem> getItems(Integer id) {
        ExperimentWorkloadItemExample example = new ExperimentWorkloadItemExample();
        example.or().andExperimentWorkloadIdEqualTo(id);
        return experimentWorkloadItemMapper.selectByExample(example);
    }

    @Override
    public List<ExperimentWorkload> getByType(String term, String workloadType, String type, String keywords) {
        return experimentWorkloadMapper.selectByType(term, workloadType, type, keywords);
    }

    public static void main(String[] args) {
        String teacherSn = "19820002 马春江";
        String[] split = teacherSn.split(" ");
    }
}
