package com.ssm.lab.service;

import com.ssm.lab.bean.CourseItem;

public interface CourseItemService {
    CourseItem getByid(Integer id);
    int remove(Integer id);
    int add(CourseItem courseItem);
    int edit(CourseItem courseItem);
}
