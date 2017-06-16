package cn.edu.cuit.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.cuit.shop.dao.OrderItemDao;
import cn.edu.cuit.shop.entity.OrderItem;

@Service
public class TestService {
	@Autowired
	OrderItemDao orderItemDao;
	
	@Transactional
	public void test() {
		OrderItem orderItem = orderItemDao.selectWithCleanById(10000);
		System.out.println(orderItem.getGoodsNumber() + "hello -wor----------------------------------------");
		orderItem.setGoodsNumber(orderItem.getGoodsNumber() - 1);
		orderItemDao.updateOrderItem(orderItem);
	}
}
