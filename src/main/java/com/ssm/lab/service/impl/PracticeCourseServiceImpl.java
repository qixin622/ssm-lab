package com.ssm.lab.service.impl;

import com.ssm.lab.bean.PracticeCourse;
import com.ssm.lab.bean.PracticeCourseExample;
import com.ssm.lab.dao.PracticeCourseMapper;
import com.ssm.lab.service.PracticeCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("practiceCourseService")
public class PracticeCourseServiceImpl implements PracticeCourseService {

    @Autowired
    private PracticeCourseMapper practiceCourseMapper;

    @Override
    public PracticeCourse getByid(Integer id) {
        return practiceCourseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PracticeCourse> getAll() {
        List<PracticeCourse> courses = practiceCourseMapper.selectByExample(null);
        return courses;
    }

    @Override
    public int remove(Integer id) {
        return practiceCourseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(PracticeCourse course) {
        return practiceCourseMapper.insertSelective(course);
    }

    @Override
    public int edit(PracticeCourse course) {
        return practiceCourseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public long count() {
        return practiceCourseMapper.countByExample(null);
    }

    @Override
    public List<PracticeCourse> getByType(String type, String keywords) {
        return practiceCourseMapper.selectByType(type, keywords);
    }
}
