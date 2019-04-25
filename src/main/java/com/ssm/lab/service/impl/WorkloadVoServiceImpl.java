package com.ssm.lab.service.impl;

import com.ssm.lab.dao.WorkloadVoMapper;
import com.ssm.lab.dto.WorkloadVo;
import com.ssm.lab.service.WorkloadVoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workloadVoService")
public class WorkloadVoServiceImpl implements WorkloadVoService {

    @Autowired
    private WorkloadVoMapper workloadVoMapper;



    @Override
    public List<String> getAllTerm() {
        return workloadVoMapper.selectAllTerm();
    }

    @Override
    public List<WorkloadVo> getByExperimentCondition(String term, String workloadType, String type, String keywords) {
        return workloadVoMapper.selectByExperimentCondition(term, workloadType, type, keywords);
    }

    @Override
    public List<WorkloadVo> getByPracticeCondition(String term, String workloadType, String type, String keywords) {
        return workloadVoMapper.selectByPracticeCondition(term, workloadType, type, keywords);
    }
}
