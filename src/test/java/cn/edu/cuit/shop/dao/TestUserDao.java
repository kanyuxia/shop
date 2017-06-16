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
		
		String number1 = "18483620000";
		String password1 = "123456";
		String nickname1 = "听风来";
		String sex1 = "男";
		
		int countNum1 = userDao.insertUser(number1, password1, nickname1, sex1);
		System.out.println(countNum1);
	}
	
	@Test
	public void testSelectUser() {
		String number = "kanyuxia@outlook.com";
		String password = "123456";
		
		User user = userDao.selectUser(number, password);
		System.out.println(user);
	}
	
	@Test
	public void testUpdatePassword() {
		String number = "kanyuxia@outlook.com";
		String oldPassword = "123456";
		String newPassword = "12345678";
		int countNum = userDao.updatePassword(number, oldPassword, newPassword);
		System.out.println(countNum);
	}
}
