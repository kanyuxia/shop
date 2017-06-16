package cn.edu.cuit.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.PropertyValue;

public interface PropertyValueDao {
	
	/**
	 * 插入属性值
	 * @param propertyID 属性ID
	 * @param productID 产品ID
	 * @param value 属性值
	 * @return 数据库影响行数
	 */
	int insertPropertyValue(@Param("propertyID") long propertyID, @Param("productID") long productID, 
			@Param("value")String value);
	
	/**
	 * 修改属性值
	 * @param propertyID 属性ID
	 * @param productID 产品ID
	 * @param newValue 新的属性值
	 * @return 数据库影响行数
	 */
	int updatePropertyValue(@Param("propertyID") long propertyID, @Param("productID") long productID,
			@Param("newValue")String newValue);
	
	/**
	 * 删除属性值
	 * @param propertyID 属性ID
	 * @param productID 产品ID
	 * @return 数据库影响行数
	 */
	int deletePropertyValue(@Param("propertyID") long propertyID, @Param("productID") long productID);
	
	/**
	 * 列出产品的所有的属性
	 * @param propertyID 产品ID
	 * @return 该产品对应的所有属性
	 */
	List<PropertyValue> selectByProductID(@Param("propertyID") long propertyID);

}
