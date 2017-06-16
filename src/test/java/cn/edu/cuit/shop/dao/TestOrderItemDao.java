package cn.edu.cuit.shop.dao;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.OrderItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestOrderItemDao {
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Test
	public void testInsertOrderItem() {
		OrderItem orderItem = new OrderItem(new Date(), 1, 10004, 10000);
		
		int countNum = orderItemDao.insertOrderItem(orderItem);
		System.out.println(countNum);
	}
	
	@Test
	public void testUpdateOrderItem() {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemID(10);
		orderItem.setCreateTime(new Date());
		orderItem.setGoodsNumber(100);
		System.out.println(orderItem);
		
		int countNum = orderItemDao.updateOrderItem(orderItem);
		System.out.println(countNum);
	}
	@Test
	public void testSelectCleanById() {
		OrderItem orderItem = orderItemDao.selectWithCleanById(10);
		System.out.println(orderItem);
	}
	
	@Test
	public void testSelectWithOneById() {
		OrderItem orderItem = orderItemDao.selectWithOneById(10);
		System.out.println(orderItem);
	}
	
	@Test
	public void testDeleteById() {
		int countNum = orderItemDao.deleteById(10);
		System.out.println(countNum);
	}
}
