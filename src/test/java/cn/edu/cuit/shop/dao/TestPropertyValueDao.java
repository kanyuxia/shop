package cn.edu.cuit.shop.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.PropertyValue;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestPropertyValueDao {
	
	@Autowired
	private PropertyValueDao propertyValueDao;
	
	@Test
	public void testInsertPropertyValue() {
		int countNum1 = propertyValueDao.insertPropertyValue(10001, 10003, "苹果(IOS)");
		int countNum2 = propertyValueDao.insertPropertyValue(10001, 10004, "苹果(IOS)");
		int countNum3 = propertyValueDao.insertPropertyValue(10001, 10000, "安卓(Android)");
		int countNum4 = propertyValueDao.insertPropertyValue(10002, 10003, "4.7英寸");
		int countNum5 = propertyValueDao.insertPropertyValue(10002, 10004, "4.7英寸");
		int countNum6 = propertyValueDao.insertPropertyValue(10002, 10000, "5.15英寸");
		int countNum7 = propertyValueDao.insertPropertyValue(10003, 10003, "以官网信息为准");
		int countNum8 = propertyValueDao.insertPropertyValue(10003, 10004, "以官网信息为准");
		int countNum9 = propertyValueDao.insertPropertyValue(10004, 10000, "2910mAh/3000mAh(typ)");
		int countNum10 = propertyValueDao.insertPropertyValue(10000, 10003, "苹果");
		int countNum11 = propertyValueDao.insertPropertyValue(10000, 10004, "苹果");
		int countNum12 = propertyValueDao.insertPropertyValue(10000, 10000, "小米");
		
		System.out.println(countNum1);
		System.out.println(countNum2);
		System.out.println(countNum3);
		System.out.println(countNum4);
		System.out.println(countNum5);
		System.out.println(countNum6);
		System.out.println(countNum7);
		System.out.println(countNum8);
		System.out.println(countNum9);
		System.out.println(countNum10);
		System.out.println(countNum11);
		System.out.println(countNum12);
	}
	
	@Test
	public void testUpdatePropertyValue() {
		int countNum = propertyValueDao.updatePropertyValue(10002, 10001, "以官网信息为准");
		System.out.println(countNum);
	}
	
	@Test
	public void testDeletePropertyValue() {
		int countNum = propertyValueDao.deletePropertyValue(1002,1001);
		System.out.println(countNum);
	}
	
	@Test
	public void testSelectByProductID() {
		List<PropertyValue> propertyValues = propertyValueDao.selectByProductID(10001);
		System.out.println(propertyValues);
	}
}
