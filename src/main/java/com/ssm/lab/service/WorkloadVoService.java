package com.ssm.lab.service;

import com.ssm.lab.dto.WorkloadVo;

import java.util.List;

public interface WorkloadVoService {

    List<String> getAllTerm();

    List<WorkloadVo> getByExperimentCondition(String term, String workloadType, String type, String keywords);

    List<WorkloadVo> getByPracticeCondition(String term, String workloadType, String type, String keywords);
}
