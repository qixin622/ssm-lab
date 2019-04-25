package com.ssm.lab.service.impl;

import com.ssm.lab.bean.Course;
import com.ssm.lab.bean.CourseExample;
import com.ssm.lab.dao.CourseMapper;
import com.ssm.lab.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course getByid(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = courseMapper.selectByExampleWithBLOBs(null);
        return courses;
    }

    @Override
    public int remove(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(Course course) {
        return courseMapper.insertSelective(course);
    }

    @Override
    public int edit(Course course) {
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public long count() {
        return courseMapper.countByExample(null);
    }

    @Override
    public List<Course> getByType(String type, String keywords) {
        return courseMapper.selectByType(type, keywords);
    }
}
