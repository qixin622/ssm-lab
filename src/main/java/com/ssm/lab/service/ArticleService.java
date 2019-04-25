package com.ssm.lab.service;

import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.Category;

import java.util.List;

public interface ArticleService {

    Article getByid(Long id);

    List<Article> getAll();

    List<Article> getByCategoryId(Integer cid);

    int remove(String id);

    int removeByCategoryId(Integer cid);

    int add(Article article);

    int edit(Article article);

    long count();

    long count(Integer cid);

    List<Article> getByType(String type,String keywords);

    int editHints(Long id);

    List<Article> getTopN(Integer num);

    List<Article> getTopNWithImage(Integer num);

    List<Article> getByTypeAndCid(Integer cid, String type, String keywords);

    Article getPrevArticleById(Long id, Integer cid);

    Article getNextArticleById(Long id, Integer cid);

    List<Article> getAllDeleted(String id);
}
