package cn.edu.cuit.shop.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.Property;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestPropertyDao {
	
	@Autowired
	private PropertyDao propertyDao;
	
	@Test
	public void testInsertProperty() {
		int countNum1 = propertyDao.insertProperty("系统");
		int countNum2 = propertyDao.insertProperty("屏幕尺寸");
		int countNum3 = propertyDao.insertProperty("电池容量");
		int countNum4 = propertyDao.insertProperty("前置摄像头像素");
		int countNum5 = propertyDao.insertProperty("后置摄像头像素");
		
		System.out.println(countNum1);
		System.out.println(countNum2);
		System.out.println(countNum3);
		System.out.println(countNum4);
		System.out.println(countNum5);
	}
	
	@Test
	public void testUpdateProperty() {
		int countNum2 = propertyDao.updateProperty("系统", "操作系统");
		System.out.println(countNum2);
	}
	
	@Test
	public void testDeleteProperty() {
		int countNum3 = propertyDao.deleteProperty("操作系统");
		System.out.println(countNum3);
	}
	
	@Test
	public void testSelectAll() {
		List<Property> properties = propertyDao.selectAll();
		System.out.println(properties);
	}
	
}
