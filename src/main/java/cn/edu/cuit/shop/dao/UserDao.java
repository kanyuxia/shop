package cn.edu.cuit.shop.dao;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.User;

public interface UserDao {
	/**
	 * 插入用户
	 * @param number 用户账号
	 * @param password 用户密码
	 * @param nickname 用户昵称
	 * @param sex 性别
	 * @return 数据库影响行数
	 */
	int insertUser(@Param("number")String number, @Param("password")String password, 
			@Param("nickname")String nickname, @Param("sex")String sex);
	
	/**
	 * 通过用户名与密码查询用户
	 * @param number 用户名
	 * @param password 密码
	 * @return 用户 or null
	 */
	User selectUser(@Param("number")String number, @Param("password")String password);
}
