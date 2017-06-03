package cn.edu.cuit.shop.dao;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Orders;
import cn.edu.cuit.shop.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestOrdersDao {
	@Autowired
	private OrdersDao ordersDao;
	
	@Test
	public void testInsert() {
		Orders orders = new Orders(12, new Date(), "四川成都", 2, 1199, 1);
		
		int countNum = ordersDao.insertOrders(orders);
		System.out.println(countNum);
	}
	
	@Test
	public void testUpdate() {
		Orders orders = ordersDao.selectWithCleanById(2);
		orders.setHarvestAddress("广州-深圳");
		orders.setStatus(20);
		
		int countNum = ordersDao.updateOrders(orders);
		System.out.println(countNum);
	}
	
	@Test
	public void testSelectCleanById() {
		Orders orders = ordersDao.selectWithCleanById(2);
		System.out.println(orders);
	}
	
	@Test
	public void testSelectWithOneById() {
		Orders orders = ordersDao.selectWithOneById(2);
		System.out.println(orders);
	}
	
	@Test
	public void testSelectWithOrderItemById() {
		Orders orders = ordersDao.selectWithOrderItemById(1);
		System.out.println(orders);
	}
	
	@Test
	public void testDeleteById() {
		int countNum = ordersDao.deleteById(2);
		System.out.println(countNum);
	}
}