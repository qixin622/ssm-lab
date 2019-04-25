package com.ssm.lab.dao;

import com.ssm.lab.bean.LabInfo;
import com.ssm.lab.bean.LabInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabInfoMapper {
    long countByExample(LabInfoExample example);

    int deleteByExample(LabInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LabInfo record);

    int insertSelective(LabInfo record);


    List<LabInfo> selectByExample(LabInfoExample example);

    LabInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LabInfo record, @Param("example") LabInfoExample example);

    int updateByExample(@Param("record") LabInfo record, @Param("example") LabInfoExample example);

    int updateByPrimaryKeySelective(LabInfo record);

    int updateByPrimaryKey(LabInfo record);
}