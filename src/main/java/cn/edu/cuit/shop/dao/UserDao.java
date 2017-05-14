package cn.edu.cuit.shop.dao;

import org.apache.ibatis.annotations.Param;

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
}
