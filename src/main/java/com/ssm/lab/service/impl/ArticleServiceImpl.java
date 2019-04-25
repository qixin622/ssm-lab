package com.ssm.lab.service.impl;

import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.ArticleExample;
import com.ssm.lab.bean.Category;
import com.ssm.lab.dao.ArticleMapper;
import com.ssm.lab.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article getByid(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> getAll() {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("id desc");
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Article> getByCategoryId(Integer id) {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("id desc");
        example.or().andCategoryIdEqualTo(id);
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<Article> getTopN(Integer num) {
        return articleMapper.selectTopN(num);
    }

    @Override
    public List<Article> getTopNWithImage(Integer num) {
        return articleMapper.selectTopNWithImage(num);
    }

    @Override
    public List<Article> getByTypeAndCid(Integer cid, String type, String keywords) {
        return articleMapper.selectByTypeAndCid(cid, type, keywords);
    }

    @Override
    public Article getPrevArticleById(Long id, Integer cid) {
        ArticleExample example = new ArticleExample();
        example.or().andCategoryIdEqualTo(cid).andIdGreaterThan(id);
        List<Article> articleList = articleMapper.selectByExampleWithBLOBs(example);
        if (articleList.size() > 0) {
            return articleList.get(0);
        }
        return null;
    }

    @Override
    public Article getNextArticleById(Long id, Integer cid) {
        ArticleExample example = new ArticleExample();
        example.or().andCategoryIdEqualTo(cid).andIdLessThan(id);
        List<Article> articleList = articleMapper.selectByExampleWithBLOBs(example);
        if (articleList.size() > 0) {
            return articleList.get(0);
        }
        return null;
    }

    @Override
    public int remove(String id) {
        List<String> stringList = Arrays.asList(id.split(","));
        List<Long> longList = new ArrayList<>();
        for (String str : stringList) {
            longList.add(Long.parseLong(str));
        }

        ArticleExample example = new ArticleExample();
        example.or().andIdIn(longList);
        return articleMapper.deleteByExample(example);
    }

    @Override
    public int removeByCategoryId(Integer cid) {
        ArticleExample example = new ArticleExample();
        example.or().andCategoryIdEqualTo(cid);
        return articleMapper.deleteByExample(example);
    }

    @Override
    public int add(Article article) {
        article.setCreateTime(new Date());
        return articleMapper.insertSelective(article);
    }

    @Override
    public int edit(Article article) {
        article.setUpdateTime(new Date());
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public int editHints(Long id) {
        return articleMapper.updateHints(id);
    }

    @Override
    public long count() {
        return articleMapper.countByExample(null);
    }

    @Override
    public long count(Integer cid) {
        ArticleExample example = new ArticleExample();
        example.or().andCategoryIdEqualTo(cid);
        return articleMapper.countByExample(example);
    }

    @Override
    public List<Article> getByType(String type, String keywords) {
        return articleMapper.selectByType(type, keywords);
    }

    public List<Article> getAllDeleted(String id) {
        List<String> stringList = Arrays.asList(id.split(","));
        List<Long> longList = new ArrayList<>();
        for (String str : stringList) {
            longList.add(Long.parseLong(str));
        }

        ArticleExample example = new ArticleExample();
        example.or().andIdIn(longList);
        return articleMapper.selectByExample(example);
    }
}
