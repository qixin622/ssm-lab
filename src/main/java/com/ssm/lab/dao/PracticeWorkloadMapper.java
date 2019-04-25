package com.ssm.lab.dao;

import com.ssm.lab.bean.PracticeWorkload;
import com.ssm.lab.bean.PracticeWorkloadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PracticeWorkloadMapper {
    long countByExample(PracticeWorkloadExample example);

    int deleteByExample(PracticeWorkloadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PracticeWorkload record);

    int insertSelective(PracticeWorkload record);

    List<PracticeWorkload> selectByExample(PracticeWorkloadExample example);

    PracticeWorkload selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PracticeWorkload record, @Param("example") PracticeWorkloadExample example);

    int updateByExample(@Param("record") PracticeWorkload record, @Param("example") PracticeWorkloadExample example);

    int updateByPrimaryKeySelective(PracticeWorkload record);

    int updateByPrimaryKey(PracticeWorkload record);

    List<String> selectAllTerm();

    List<PracticeWorkload> selectByType(@Param("term") String term, @Param("workloadType") String workloadType, @Param("type") String type, @Param("keywords") String keywords);
}