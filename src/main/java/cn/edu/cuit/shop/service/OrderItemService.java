package cn.edu.cuit.shop.service;

import java.util.List;

import cn.edu.cuit.shop.entity.OrderItem;

public interface OrderItemService {
	
	void update();

	List<OrderItem> queryByOrderId(long ordersID);

}
