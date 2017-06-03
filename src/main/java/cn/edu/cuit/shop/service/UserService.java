package cn.edu.cuit.shop.service;

import cn.edu.cuit.shop.entity.User;

public interface UserService {
	/**
	 * 注册用户
	 * @param number 用户账号
	 * @param password 用户密码
	 * @param nickname 用户昵称
	 * @param sex 性别
	 * @return 是否注册成功
	 */
	boolean register(String number, String password, String nickname, String sex);
	
	/**
	 * 登录
	 * @param number 用户名
	 * @param password 密码
	 * @return 用户 or null
	 */
	User login(String number, String password);
	
	/**
	 * 修改密码
	 * @param number 用户名
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return 是否修改成功
	 */
	boolean modifyPassword(String number, String oldPassword, String newPassword);
	
	/**
	 * 修改用户信息
	 * @param user 新的用户信息
	 * @return 是否修改成功
	 */
	boolean mofifyUser(User user);
}
