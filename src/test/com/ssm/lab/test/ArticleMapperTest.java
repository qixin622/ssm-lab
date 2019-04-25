package com.ssm.lab.test;


import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.ArticleExample;
import com.ssm.lab.bean.User;
import com.ssm.lab.bean.UserExample;
import com.ssm.lab.dao.ArticleMapper;
import com.ssm.lab.dao.UserMapper;
import com.ssm.lab.service.ArticleService;
import com.ssm.lab.utils.DateTimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;


/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ArticleMapperTest {
	
	@Autowired
	ArticleMapper articleMapper;

	@Autowired
	ArticleService articleService;

	/**
	 * 随机生成分类id为1到5的文章
	 */
	@Test
	public void insertArticle(){
		UUID.randomUUID();
		for (int i = 1; i < 50; i++) {
			Article article = new Article();
			String str = UUID.randomUUID().toString();
			Random random = new Random();
			int cid = random.nextInt(5) + 1;
			article.setCategoryId(cid);
			article.setTitle("文章"+i);
			article.setContent("文章"+i + str);
			article.setUserSn("19970016");
			article.setCreateTime(new Date());
			articleMapper.insertSelective(article);
		}
	}

	@Test
	public void getAll() {
		List<Article> articleList = articleMapper.selectByExample(null);
		for (Article article : articleList) {
			System.out.println(article.getTitle()+"-"+article.getCategory().getCategoryName()+"-"+article.getUser().getUserName());
		}
	}
	@Test
	public void getByExample(){
		ArticleExample example = new ArticleExample();
		example.or().andCategoryIdEqualTo(1);
		List<Article> articleList = articleMapper.selectByExampleWithBLOBs(example);
		for (Article article : articleList) {
			System.out.println(article.getTitle()+"-"+article.getCategory().getCategoryName()+"-"+article.getUser().getUserName());
		}
	}

	@Test
	public void testRemove() {
		String str = "1,2,3,4,5";
		System.out.println(articleService.remove(str));
	}

	@Test
	public void testSelectByTypeAndCid() {
		int cid = 1;
		String type = "title";
		String keywords = "1";
		List<Article> articleList = articleMapper.selectByTypeAndCid(cid, type, keywords);
		for (Article article : articleList) {
			System.out.println(article.getTitle());
		}
	}

	@Test
	public void getPrevArticleById() {
		int cid = 1;
		Long id = 48L;
		Article prevArticle = articleService.getPrevArticleById(id, cid);
		Article nextArticle = articleService.getNextArticleById(id, cid);
		System.out.println(prevArticle);
		System.out.println(nextArticle);

	}

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			int a = r.nextInt(5) + 1;
			System.out.println("a:" + a);
		}
	}


}
