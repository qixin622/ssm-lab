package com.ssm.lab.service.impl;

import com.ssm.lab.bean.WorkRecord;
import com.ssm.lab.bean.WorkRecordExample;
import com.ssm.lab.dao.WorkRecordMapper;
import com.ssm.lab.service.WorkRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workRecordService")
public class WorkRecordServiceImpl implements WorkRecordService {

    @Autowired
    private WorkRecordMapper workRecordMapper;

    @Override
    public WorkRecord getByid(Integer id) {
        return workRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<WorkRecord> getAll() {
        WorkRecordExample example = new WorkRecordExample();
        example.setOrderByClause("id desc");

        return workRecordMapper.selectByExample(example);
    }

    @Override
    public int remove(Integer id) {
        return workRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(WorkRecord record) {
        return workRecordMapper.insertSelective(record);
    }

    @Override
    public int edit(WorkRecord record) {
        return workRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<WorkRecord> getByType(String startTime, String endTime, String type, String keywords) {
        return workRecordMapper.selectByType(startTime, endTime, type, keywords);
    }
}
