package cn.edu.cuit.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.cuit.shop.dao.GoodsDao;
import cn.edu.cuit.shop.dao.OrderItemDao;
import cn.edu.cuit.shop.dao.OrdersDao;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	public static int count = 0;
	
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private OrdersDao orderDao;
	@Autowired
	private GoodsDao goodsDao;
	
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

	@Override
	public List<OrderItem> queryByOrderId(long ordersID) {
		List<OrderItem> list = orderDao.selectWithOrderItemById(ordersID).getItems();
		for (OrderItem orderItem : list) {
			orderItem.setGoods(goodsDao.selectWithCleanById(orderItem.getGoodsID()));
		}
		System.out.println(list);
		return list;
	}

}
