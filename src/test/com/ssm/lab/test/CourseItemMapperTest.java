package com.ssm.lab.test;


import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.CourseItem;
import com.ssm.lab.bean.CourseItemExample;
import com.ssm.lab.dao.ArticleMapper;
import com.ssm.lab.dao.CourseItemMapper;
import com.ssm.lab.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;


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
public class CourseItemMapperTest {

	@Autowired
	CourseItemMapper courseItemMapper;

	@Test
	public void getByCid() {
		CourseItemExample example = new CourseItemExample();
		example.or().andCidEqualTo(1);
		List<CourseItem> courseItemList = courseItemMapper.selectByExampleWithBLOBs(example);
		for (CourseItem courseItem : courseItemList) {
			System.out.println(courseItem.getItemname() + " " + courseItem.getContent());
		}
	}



}
