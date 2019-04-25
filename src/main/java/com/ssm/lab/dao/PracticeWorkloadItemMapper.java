package com.ssm.lab.dao;

import com.ssm.lab.bean.PracticeWorkloadItem;
import com.ssm.lab.bean.PracticeWorkloadItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PracticeWorkloadItemMapper {
    long countByExample(PracticeWorkloadItemExample example);

    int deleteByExample(PracticeWorkloadItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PracticeWorkloadItem record);

    int insertSelective(PracticeWorkloadItem record);

    List<PracticeWorkloadItem> selectByExample(PracticeWorkloadItemExample example);

    PracticeWorkloadItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PracticeWorkloadItem record, @Param("example") PracticeWorkloadItemExample example);

    int updateByExample(@Param("record") PracticeWorkloadItem record, @Param("example") PracticeWorkloadItemExample example);

    int updateByPrimaryKeySelective(PracticeWorkloadItem record);

    int updateByPrimaryKey(PracticeWorkloadItem record);

    List<PracticeWorkloadItem> selectByPracticeWorkloadId(Integer id);
}