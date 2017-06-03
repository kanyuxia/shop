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
	
	
	/**
	 * 修改密码
	 * @param number 用户名
	 * @param oldPassword 老密码
	 * @param newPassword 新密码
	 * @return 影响行数
	 */
	int updatePassword(@Param("number")String number, @Param("oldPassword")String oldPassword,
			@Param("newPassword")String newPassword);
	
	/**
	 * 修改用户信息
	 * @param number 用户名
	 * @param newNickname 新的昵称
	 * @param newSex 新的性别
	 * @return 影响行数
	 */
	int updateUser(@Param("number")String number, @Param("newNickname")String newNickname,
			@Param("newSex")String newSex);
}
