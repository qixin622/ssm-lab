package com.ssm.lab.service;

import com.ssm.lab.bean.PracticeCourse;

import java.util.List;

public interface PracticeCourseService {

    PracticeCourse getByid(Integer id);

    List<PracticeCourse> getAll();

    int remove(Integer id);

    int add(PracticeCourse course);

    int edit(PracticeCourse course);

    long count();

    List<PracticeCourse> getByType(String type, String keywords);
}
