package com.ssm.lab.service.impl;

import com.ssm.lab.bean.LabInfo;
import com.ssm.lab.dao.LabInfoMapper;
import com.ssm.lab.service.LabInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("labInfoService")
public class LabInfoServiceImpl implements LabInfoService {
    @Autowired
    private LabInfoMapper labInfoMapper;

    @Override
    public LabInfo getByid(Integer id) {
        return labInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<LabInfo> getAll() {
        return labInfoMapper.selectByExample(null);
    }

    @Override
    public int remove(Integer id) {
        return labInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(LabInfo labInfo) {
        return labInfoMapper.insertSelective(labInfo);
    }

    @Override
    public int edit(LabInfo labInfo) {
        return labInfoMapper.updateByPrimaryKeySelective(labInfo);
    }
}
