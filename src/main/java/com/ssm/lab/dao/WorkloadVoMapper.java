package com.ssm.lab.dao;

import com.ssm.lab.dto.WorkloadVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkloadVoMapper {


    List<String> selectAllTerm();

    List<WorkloadVo> selectByExperimentCondition(@Param("term") String term, @Param("workloadType") String workloadType, @Param("type") String type, @Param("keywords") String keywords);
    List<WorkloadVo> selectByPracticeCondition(@Param("term") String term, @Param("workloadType") String workloadType, @Param("type") String type, @Param("keywords") String keywords);
}