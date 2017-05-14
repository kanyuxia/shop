package cn.edu.cuit.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.shop.dao.UserDao;
import cn.edu.cuit.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	/**
	 * 注册用户
	 * @param number 用户账号
	 * @param password 用户密码
	 * @param nickname 用户昵称
	 * @param sex 性别
	 * @return 是否注册成功
	 */
	public boolean register(String number, String password, String nickname, String sex){
		int countNum = userDao.insertUser(number, password, nickname, sex);
		return countNum == 1 ? true : false;
	}
	
}
