package com.ssm.lab.dao;

import com.ssm.lab.bean.ExperimentWorkloadItem;
import com.ssm.lab.bean.ExperimentWorkloadItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExperimentWorkloadItemMapper {
    long countByExample(ExperimentWorkloadItemExample example);

    int deleteByExample(ExperimentWorkloadItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentWorkloadItem record);

    int insertSelective(ExperimentWorkloadItem record);

    List<ExperimentWorkloadItem> selectByExample(ExperimentWorkloadItemExample example);

    List<ExperimentWorkloadItem> selectByExperimentWorkloadId(Integer id);

    ExperimentWorkloadItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExperimentWorkloadItem record, @Param("example") ExperimentWorkloadItemExample example);

    int updateByExample(@Param("record") ExperimentWorkloadItem record, @Param("example") ExperimentWorkloadItemExample example);

    int updateByPrimaryKeySelective(ExperimentWorkloadItem record);

    int updateByPrimaryKey(ExperimentWorkloadItem record);
}