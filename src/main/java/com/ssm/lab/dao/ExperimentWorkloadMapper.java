package com.ssm.lab.dao;

import com.ssm.lab.bean.ExperimentWorkload;
import com.ssm.lab.bean.ExperimentWorkloadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExperimentWorkloadMapper {
    long countByExample(ExperimentWorkloadExample example);

    int deleteByExample(ExperimentWorkloadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExperimentWorkload record);

    int insertSelective(ExperimentWorkload record);

    List<ExperimentWorkload> selectByExample(ExperimentWorkloadExample example);

    ExperimentWorkload selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExperimentWorkload record, @Param("example") ExperimentWorkloadExample example);

    int updateByExample(@Param("record") ExperimentWorkload record, @Param("example") ExperimentWorkloadExample example);

    int updateByPrimaryKeySelective(ExperimentWorkload record);

    int updateByPrimaryKey(ExperimentWorkload record);

    List<String> selectAllTerm();

    List<ExperimentWorkload> selectByType(@Param("term")String term, @Param("workloadType")String workloadType,@Param("type")String type, @Param("keywords")String keywords);
}