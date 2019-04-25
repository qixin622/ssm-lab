package com.ssm.lab.test;


import com.ssm.lab.bean.User;
import com.ssm.lab.bean.UserExample;
import com.ssm.lab.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


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
public class MapperTest {
	
	@Autowired
	UserMapper userMapper;

	/**
	 * 获取全部用户
	 */
	@Test
	public void getAllUser(){
		List<User> userList = userMapper.selectByExample(null);
		for (User user : userList) {
			System.out.println(user.getUserName());
		}
	}

	@Test
	public void getByType(){
		String type="sn";
		String text="19";
		List<User> userList = userMapper.selectByType(type,text);
		for (User user : userList) {
			System.out.println(user.getUserName());
		}
	}

	@Test
	public void getByExample(){
		String type="sn";
		String text="19";
		List<User> userList = userMapper.selectByType(type,text);
		for (User user : userList) {
			System.out.println(user.getUserName());
		}
	}

	@Test
	public void getByExample2(){
		UserExample example = new UserExample();
		List<String> snList = new ArrayList<>();
		snList.add("19970010");
		snList.add("19970016");
		snList.add("19970019");
//		example.or().andSnIn(snList);
//		List<User> userList = userMapper.selectByExample(example);
//		for (User user : userList) {
//			System.out.println(user.getName());
//		}

		example.or().andSnIn(snList);
		int result = userMapper.deleteByExample(example);
		System.out.println("删除了"+result+"条记录!");
	}


}
