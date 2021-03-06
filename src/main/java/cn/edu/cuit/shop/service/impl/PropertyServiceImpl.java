package cn.edu.cuit.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.shop.dao.GoodsDao;
import cn.edu.cuit.shop.dao.PropertyDao;
import cn.edu.cuit.shop.dao.PropertyValueDao;
import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Property;
import cn.edu.cuit.shop.entity.PropertyValue;
import cn.edu.cuit.shop.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private PropertyValueDao propertyValueDao;
	@Autowired
	private GoodsDao goodsDao;
	

	/**
	 * 用户：通过分类ID查询其所对应的属性信息及其属性值信息(唯一性)
	 * @param categoryID 分类ID
	 * @return 该分类ID对应的所有属性信息(唯一性)
	 */
	public List<Property> listProperties(long categoryID) {
		List<Property> listProperties = propertyDao.selectAll(categoryID);
		for (Property property : listProperties) {
			List<PropertyValue> listValue = propertyValueDao.selectDitByPropertyID(property.getPropertyID());
			property.setPropertyValues(listValue);
		}
		return listProperties;
	}
	
	/**
	 * 通过商品ID返回其对于的产品所对应于的属性值(级联属性)
	 * @param goodsID 商品ID
	 * @return 其对于的属性值(级联属性)
	 */
	public List<PropertyValue> listValuesByProID(long goodsID) {
		Goods goods = goodsDao.selectWithCleanById(goodsID);
	 	List<PropertyValue> listValues = propertyValueDao.selectByProductID(goods.getProductID());
		return listValues;
	}

}
