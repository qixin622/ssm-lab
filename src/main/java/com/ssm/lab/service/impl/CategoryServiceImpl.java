package com.ssm.lab.service.impl;

import com.ssm.lab.bean.Category;
import com.ssm.lab.dao.CategoryMapper;
import com.ssm.lab.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public Category getByid(Integer cid) {
        return categoryMapper.selectByPrimaryKey(cid);
    }

    @Override
    public List<Category> getAll() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public int remove(Integer cid) {
        return categoryMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int add(Category category) {
        return categoryMapper.insertSelective(category);
    }

    @Override
    public int edit(Category category) {
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    @Override
    public long count() {
        return categoryMapper.countByExample(null);
    }

}
