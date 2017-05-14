package cn.edu.cuit.shop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class TestUserService {
	@Autowired
	private UserService userService;
	
	@Test
	@Rollback(false)
	public void testRegister(){
		String number = "kanyuxia@outlook.com";
		String password = "123456";
		String nickname = "默默的看雨下";
		String sex = "男";
		
		boolean successed = userService.register(number, password, nickname, sex);
		System.out.println(successed);
	}
}
