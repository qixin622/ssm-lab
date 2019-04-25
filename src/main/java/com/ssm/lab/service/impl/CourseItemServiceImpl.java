package com.ssm.lab.service.impl;

import com.ssm.lab.bean.CourseItem;
import com.ssm.lab.dao.CourseItemMapper;
import com.ssm.lab.service.CourseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("courseItemService")
public class CourseItemServiceImpl implements CourseItemService {

    @Autowired
    private CourseItemMapper courseItemMapper;

    @Override
    public CourseItem getByid(Integer id) {
        return courseItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int remove(Integer id) {
        return courseItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(CourseItem courseItem) {
        return courseItemMapper.insertSelective(courseItem);
    }

    @Override
    public int edit(CourseItem courseItem) {
        return courseItemMapper.updateByPrimaryKeySelective(courseItem);
    }
}
