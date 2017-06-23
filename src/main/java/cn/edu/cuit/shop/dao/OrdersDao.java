package cn.edu.cuit.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.Orders;

public interface OrdersDao {

	/**
	 * 插入订单
	 * @param orders 要插入的实体
	 * @return 收影响的行数
	 */
	long selectID(@Param("orders") Orders orders);
	
	
	/**
	 * 插入订单
	 * @param orders 要插入的实体
	 * @return 收影响的行数
	 */
	int insertOrders(@Param("orders") Orders orders);
	
	/**
	 * 更新订单
	 * @param orders
	 * @return
	 */
	int updateOrders(@Param("orders") Orders orders);
	
	/**
	 * 根据条件查找
	 * @param orders 查询条件
	 * @return 查询结果
	 */
//	List<OrderItem> selectWithClean(@Param("orderItem") OrderItem orderItem);
	
	/**
	 * 根据ID查找(不关联)
	 * @param ordersId 订单id
	 * @return 查询结果
	 */
	Orders selectWithCleanById(@Param("ordersId") long ordersId);
	
	/**
	 * 根据ID查找(关联其他)
	 * @param ordersId 订单id
	 * @return 查询结果
	 */
	Orders selectWithOneById(@Param("ordersId") long ordersId);
	
	/**
	 * 根据ID查找(关联订单项)
	 * @param ordersId 订单id
	 * @return 查询
	 */
	Orders selectWithOrderItemById(@Param("ordersId") long ordersId);
	
	/**
	 * 根据userId查找(关联订单项)
	 * @param ordersId 订单id
	 * @return 查询
	 */
	List<Orders> selectWithOrderItemByUserId(@Param("userId") long userId);
	
	/**
	 * 分页查询所有
	 * @param offset
	 * @param size
	 * @return
	 */
	List<Orders> selectWithOrderItem(@Param("offset") int offset, @Param("size")int size);
	
	/**
	 * 根据ID删除
	 * @param ordersId 订单id
	 * @return 影响的行数
	 */
	int deleteById(@Param("ordersId") long ordersId);
	
}
