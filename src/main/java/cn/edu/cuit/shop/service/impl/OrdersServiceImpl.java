package cn.edu.cuit.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.cuit.shop.dao.GoodsDao;
import cn.edu.cuit.shop.dao.OrdersDao;
import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Orders;
import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.service.OrdersService;
@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Orders> queryUserOrders(User user) {
		List<Orders> ordersList = ordersDao.selectWithOrderItemByUserId(user.getUserID());
		return ordersList;
	}

	@Override
	public boolean cancelOrdersById(long ordersId) {
		int flag = ordersDao.deleteById(ordersId);
		return flag > 0 ? true : false;
	}

	@Override
	@Transactional
	public boolean commitOrders(Orders orders) {
		for (OrderItem orderItem : orders.getItems()) {
			Goods goods = goodsDao.selectWithCleanById(orderItem.getGoodsID());
		}
		int flag = ordersDao.insertOrders(orders);
		return flag > 0 ? true : false;
	}

	@Override
	public boolean updateOrdersStatus(Orders orders) {
		Orders orders2 = ordersDao.selectWithCleanById(orders.getOrdersID());
		orders2.setStatus(orders.getStatus());
		int flag = ordersDao.updateOrders(orders2);
		return flag > 0 ? true : false;
	}

	@Override
	public boolean updateOrders(Orders orders) {
		int flag = ordersDao.updateOrders(orders);
		return flag > 0 ? true : false;
	}

	@Override
	public Orders getOrdersById(long ordersId) {
		return ordersDao.selectWithCleanById(ordersId);
	}
}
