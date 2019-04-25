package com.ssm.lab.dao;

import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    long countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    /**
     * 按类型和关键字查找数据
     * @param type
     * @param keywords
     * @return
     */
    List<Article> selectByType(@Param("type")String type,@Param("keywords")String keywords);

    /**
     * 按文章编号更新点击量
     * @param id
     * @return
     */
    int updateHints(Long id);

    /**
     * 查询最新发表的N篇文章
     * @param num
     * @return
     */
    List<Article> selectTopN(Integer num);

    /**
     * 查询最新发表的N篇带配图的文章
     * @param num
     * @return
     */
    List<Article> selectTopNWithImage(Integer num);

    /**
     * 按类型和关键字查找数据
     * @param type
     * @param keywords
     * @return
     */
    List<Article> selectByTypeAndCid(@Param("cid")Integer cid,@Param("type")String type,@Param("keywords")String keywords);
}