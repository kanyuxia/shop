package cn.edu.cuit.shop.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestUserDao {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testInsertUser() {
		String number = "kanyuxia@outlook.com";
		String password = "123456";
		String nickname = "默默的看雨下";
		String sex = "男";
		
		int countNum = userDao.insertUser(number, password, nickname, sex);
		System.out.println(countNum);
	}
	
	@Test
	public void testSelectUser() {
		String number = "kanyuxia@outlook.com";
		String password = "123456";
		
		User user = userDao.selectUser(number, password);
		System.out.println(user);
	}
}
