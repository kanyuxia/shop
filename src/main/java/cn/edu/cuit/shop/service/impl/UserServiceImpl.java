package cn.edu.cuit.shop.service.impl;

import java.util.List;

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
	
	/**
	 * 修改密码
	 * @param number 用户名
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return 是否修改成功
	 */
	public boolean modifyPassword(String number, String oldPassword, String newPassword){
		int countNum = userDao.updatePassword(number, oldPassword, newPassword);
		return countNum == 1 ? true : false;
	}
	
	/**
	 * 修改用户信息
	 * @param user 新的用户信息
	 * @return 是否修改成功
	 */
	public boolean mofifyUser(User user){
		int countNum = userDao.updateUser(user.getNumber(), user.getNickname(), user.getSex());
		return countNum == 1 ? true : false;
	}

	@Override
	public boolean modifyUser(User user) {
		return false;
	}

	@Override
	public List<User> queryUsersByPageSize(int i, int rows) {
		List<User> list =  userDao.selectPage(i,rows);
		return list;
	}
}
