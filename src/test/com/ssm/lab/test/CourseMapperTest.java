package com.ssm.lab.test;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.ArticleExample;
import com.ssm.lab.bean.Course;
import com.ssm.lab.bean.CourseItem;
import com.ssm.lab.dao.ArticleMapper;
import com.ssm.lab.dao.CourseMapper;
import com.ssm.lab.service.ArticleService;
import com.ssm.lab.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;


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
public class CourseMapperTest {
	
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	CourseService courseService;

	@Test
	public void getAll() {
//		List<Course> courseList = courseService.getAll();
//		for (Course course : courseList) {
//			System.out.println(course.getCname());
//			List<CourseItem> courseItems = course.getCourseItems();
//			for (CourseItem courseItem : courseItems) {
//				System.out.println("====>" + courseItem.getItemname());
//			}
//		}
	}

	@Test
	public void getByPrimaryKey() {
		Course course = courseService.getByid(1-1);
		System.out.println(course.getCname());
		List<CourseItem> courseItems = course.getCourseItems();
		for (CourseItem courseItem : courseItems) {
			System.out.println(courseItem.getItemname() + " "+ courseItem.getExptype());
		}
	}

	@Test
	public void getByPagination() {
		PageHelper.startPage(1, 10);
		List<Course> courses = courseService.getAll();
		PageInfo page = new PageInfo(courses, 5);
		List<Course> pageList = page.getList();
		for (Course course : pageList) {
			System.out.println(course.getCname());
			List<CourseItem> courseItems = course.getCourseItems();
			for (CourseItem courseItem : courseItems) {
				System.out.println("====>" + courseItem.getItemname());
			}
		}
	}



}
