package com.ssm.lab.dao;

import com.ssm.lab.bean.CourseItem;
import com.ssm.lab.bean.CourseItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseItemMapper {
    long countByExample(CourseItemExample example);

    int deleteByExample(CourseItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseItem record);

    int insertSelective(CourseItem record);

    List<CourseItem> selectByExampleWithBLOBs(CourseItemExample example);

    List<CourseItem> selectByExample(CourseItemExample example);

    CourseItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseItem record, @Param("example") CourseItemExample example);

    int updateByExampleWithBLOBs(@Param("record") CourseItem record, @Param("example") CourseItemExample example);

    int updateByExample(@Param("record") CourseItem record, @Param("example") CourseItemExample example);

    int updateByPrimaryKeySelective(CourseItem record);

    int updateByPrimaryKeyWithBLOBs(CourseItem record);

    int updateByPrimaryKey(CourseItem record);

    List<CourseItem> selectCourseItemsByCid(Integer cid);
}