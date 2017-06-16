package cn.edu.cuit.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.Property;

public interface PropertyDao {
	
	/**
	 * 添加属性信息
	 * @param name 属性名称
	 * @return 数据库影响行数
	 */
	int insertProperty(String name);
	
	/**
	 * 更新属性信息
	 * @param oldName 旧的属性名称
	 * @param newName 新的属性名称
	 * @return 数据库影响行数
	 */
	int updateProperty(@Param("oldName")String oldName, @Param("newName") String newName);
	
	/**
	 * 删除属性信息
	 * @param name 属性名称
	 * @return 数据库影响行数
	 */
	int deleteProperty(String name);
	
	
	/**
	 * 列出所有属性信息
	 * @param productID 产品ID
	 * @return 该产品的所有属性
	 */
	List<Property> selectAll();
}
