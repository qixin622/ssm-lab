package com.ssm.lab.dao;

import com.ssm.lab.bean.PracticeCourse;
import com.ssm.lab.bean.PracticeCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PracticeCourseMapper {
    long countByExample(PracticeCourseExample example);

    int deleteByExample(PracticeCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PracticeCourse record);

    int insertSelective(PracticeCourse record);

    List<PracticeCourse> selectByExampleWithBLOBs(PracticeCourseExample example);

    List<PracticeCourse> selectByExample(PracticeCourseExample example);

    PracticeCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PracticeCourse record, @Param("example") PracticeCourseExample example);

    int updateByExampleWithBLOBs(@Param("record") PracticeCourse record, @Param("example") PracticeCourseExample example);

    int updateByExample(@Param("record") PracticeCourse record, @Param("example") PracticeCourseExample example);

    int updateByPrimaryKeySelective(PracticeCourse record);

    int updateByPrimaryKeyWithBLOBs(PracticeCourse record);

    int updateByPrimaryKey(PracticeCourse record);

    /**
     * 按类型和关键字查找数据
     * @param type
     * @param keywords
     * @return
     */
    List<PracticeCourse> selectByType(@Param("type")String type, @Param("keywords")String keywords);
}