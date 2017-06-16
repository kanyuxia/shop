package cn.edu.cuit.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.Property;

public interface PropertyDao {
	
	/**
	 * 添加属性信息
	 * @param categoryID 分类ID
	 * @param name 属性名称
	 * @return 数据库影响行数
	 */
	int insertProperty(@Param("categoryID")long categoryID, @Param("name")String name);
	
	/**
	 * 更新属性信息
	 * @param categoryID 分类ID
	 * @param oldName 旧的属性名称
	 * @param newName 新的属性名称
	 * @return 数据库影响行数
	 */
	int updateProperty(@Param("categoryID")long categoryID, @Param("oldName")String oldName,
			@Param("newName") String newName);
	
	/**
	 * 删除属性信息
	 * @param categoryID 分类ID
	 * @param name 属性名称
	 * @return 数据库影响行数
	 */
	int deleteProperty(@Param("categoryID")long categoryID, @Param("name")String name);
	
	
	/**
	 * 列出分类下所有属性信息
	 * @param categoryID 分类ID
	 * @return 该分类下的所有属性信息
	 */
	List<Property> selectAll(long categoryID);
}
