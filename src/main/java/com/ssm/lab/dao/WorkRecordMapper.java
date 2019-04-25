package com.ssm.lab.dao;

import com.ssm.lab.bean.WorkRecord;
import com.ssm.lab.bean.WorkRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkRecordMapper {
    long countByExample(WorkRecordExample example);

    int deleteByExample(WorkRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkRecord record);

    int insertSelective(WorkRecord record);

    List<WorkRecord> selectByExample(WorkRecordExample example);

    WorkRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkRecord record, @Param("example") WorkRecordExample example);

    int updateByExample(@Param("record") WorkRecord record, @Param("example") WorkRecordExample example);

    int updateByPrimaryKeySelective(WorkRecord record);

    int updateByPrimaryKey(WorkRecord record);

    List<WorkRecord> selectByType(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("type")String type, @Param("keywords")String keywords);
}