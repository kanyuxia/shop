package cn.edu.cuit.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.cuit.shop.dao.OrderItemDao;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	public static int count = 0;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Override
	@Transactional
	public void update() {
		System.out.println("-------------------------------------");
		OrderItem orderItem = orderItemDao.selectWithCleanById(10);
		orderItem.setGoodsNumber(orderItem.getGoodsNumber() - 1);
		orderItemDao.updateOrderItem(orderItem);
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		count++;
		System.out.println("-------------------------------:"+count);
	}

}
