package cn.edu.cuit.shop.service;

import java.util.List;

import cn.edu.cuit.shop.entity.Property;
import cn.edu.cuit.shop.entity.PropertyValue;

public interface PropertyService {

	/**
	 * 用户：通过分类ID查询其所对应的属性信息及其属性值信息(唯一性)
	 * @param categoryID 分类ID
	 * @return 该分类ID对应的所有属性信息(唯一性)
	 */
	List<Property> listProperties(long categoryID);
	
	/**
	 * 通过产品Id返回其对于的属性值(级联属性)
	 * @param productID 产品ID
	 * @return 其对于的属性值(级联属性)
	 */
	List<PropertyValue> getValuesByProID(long productID);
	
	
}
