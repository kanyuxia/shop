package cn.edu.cuit.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.cuit.shop.dao.GoodsDao;
import cn.edu.cuit.shop.dao.InventoryDao;
import cn.edu.cuit.shop.dao.OrderItemDao;
import cn.edu.cuit.shop.dao.OrdersDao;
import cn.edu.cuit.shop.dao.UserDao;
import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Inventory;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Orders;
import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.exception.SysException;
import cn.edu.cuit.shop.service.OrdersService;
@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<Orders> queryUserOrders(User user) {
		List<Orders> ordersList = ordersDao.selectWithOrderItemByUserId(user.getUserID());
		for (Orders orders : ordersList) {
			for (OrderItem orderItem : orders.getItems()) {
				orderItem.setGoods(goodsDao.selectWithOneById(orderItem.getGoodsID()));
			}
		}
		return ordersList;
	}

	@Override
	public boolean cancelOrdersById(long ordersId) {
		int flag = ordersDao.deleteById(ordersId);
		return flag > 0 ? true : false;
	}

	@Override
	@Transactional
	public synchronized boolean commitOrders(Orders orders) throws SysException{
		boolean inventoryFlag = true;
		ordersDao.insertOrders(orders);
		long orderID = ordersDao.selectID(orders);
		for (OrderItem orderItem : orders.getItems()) {
			orderItem.setOrdersID(orderID);
			orderItemDao.insertOrderItem(orderItem);
			Goods goods = goodsDao.selectWithOneById(orderItem.getGoodsID());
			Inventory inventory = inventoryDao.selectWithCleanByGoodsId(goods.getGoodsID());
			if (inventory.getInventoryNumber() <=0 ) {
				throw new SysException("商品：" + goods.getProduct().getName() + "库存不足！请重新提交订单！"); 
			}
			inventory.setInventoryNumber(inventory.getInventoryNumber() - orderItem.getGoodsNumber());
			inventory.setSellNumber(inventory.getSellNumber() - orderItem.getGoodsNumber());
			inventoryFlag = inventoryDao.updateInventoryByGoodsId(inventory) > 0 ? true : false; 
			if (!inventoryFlag) {
				throw new SysException("操作失败！");
			}
		}
		orders.setStatus(3);
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

	@Override
	public List<Orders> queryAllOrders(int offset, int size) {
		return ordersDao.selectWithOrderItem(offset, size);
	}

	@Override
	public List<Orders> queryOrdersByNickName(long id) {
		return ordersDao.selectWithOrderItemByUserId(id);
	}
}
