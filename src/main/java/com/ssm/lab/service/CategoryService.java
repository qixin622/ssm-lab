package com.ssm.lab.service;

import com.ssm.lab.bean.Category;

import java.util.List;

public interface CategoryService {

    Category getByid(Integer cid);

    List<Category> getAll();

    int remove(Integer cid);

    int add(Category category);

    int edit(Category category);

    long count();
}
