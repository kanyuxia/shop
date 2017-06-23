package cn.edu.cuit.shop.service;

import java.util.List;

import cn.edu.cuit.shop.entity.Orders;
import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.exception.SysException;

public interface OrdersService {
	
	/**
	 * 根据用户ID查询该用户所有订单
	 * @param user
	 * @return
	 */
	List<Orders> queryUserOrders(User user);
	
	/**
	 * 通过id查询订单
	 * @param ordersId
	 * @return
	 */
	Orders getOrdersById(long ordersId);
	
	/**
	 * 通过id取消订单
	 * @param OrdersId
	 * @return
	 */
	boolean cancelOrdersById(long ordersId);
	
	/**
	 * 提交订单
	 * @param orders
	 * @return
	 */
	boolean commitOrders(Orders orders) throws SysException;
	
	/**
	 * 修改订单状态
	 * @param orders
	 * @return
	 */
	boolean updateOrdersStatus(Orders orders);
	
	/**
	 * 修改订单
	 * @return
	 */
	boolean updateOrders(Orders orders);
	
	List<Orders> queryAllOrders(int offset, int size);

	List<Orders> queryOrdersByNickName(long id);

}
