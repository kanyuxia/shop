package cn.edu.cuit.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.Category;

public interface CategoryDao {
	/**
	 * 查询所有的分类信息(不级联)
	 * @return 分类信息
	 */
	List<Category> selectAll();
	
	/**
	 * 查询所有的分类信息(不级联)
	 * @return 分类信息
	 */
	List<Category> selectAllofProduct();
	
	/**
	 * 修改分类名称
	 * @param oldName 原分类名
	 * @param newName 新分类名
	 * @return 数据库影响行数
	 */
	int updateCategory(@Param("oldName")String oldName, @Param("newName")String newName);
	
	/**
	 * 删除分类
	 * @param name 分类名称
	 * @return 数据库影响行数
	 */
	int deleteCategory(String name);
	
	/**
	 * 插入分类
	 * @param name 分类名称
	 * @return 数据库影响行数
	 */
	int insertCategory(String name);
}
