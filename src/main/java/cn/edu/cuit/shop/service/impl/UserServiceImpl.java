package cn.edu.cuit.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.shop.dao.UserDao;
import cn.edu.cuit.shop.entity.User;
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
	
	/**
	 * 用户登录
	 * @param number 用户名
	 * @param password 密码
	 * @return 用户信息 or null
	 */
	public User login(String number, String password) {
		User user = userDao.selectUser(number, password);
		return user;
	}
}
