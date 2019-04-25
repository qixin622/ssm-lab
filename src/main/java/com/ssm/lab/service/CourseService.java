package com.ssm.lab.service;

import com.ssm.lab.bean.Course;

import java.util.List;

public interface CourseService {

    Course getByid(Integer id);

    List<Course> getAll();

    int remove(Integer id);

    int add(Course course);

    int edit(Course course);

    long count();

    List<Course> getByType(String type, String keywords);
}
