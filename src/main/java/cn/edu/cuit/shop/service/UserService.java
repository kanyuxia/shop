package cn.edu.cuit.shop.service;


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
}
