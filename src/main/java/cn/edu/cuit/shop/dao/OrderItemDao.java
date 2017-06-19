package cn.edu.cuit.shop.dao;


import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.OrderItem;

public interface OrderItemDao {

	/**
	 * 插入订单项
	 * @param orderItem 要插入的实体
	 * @return 收影响的行数
	 */
	int insertOrderItem(@Param("orderItem") OrderItem orderItem);
	
	/**
	 * 更新订单项
	 * @param orderItem
	 * @return
	 */
	int updateOrderItem(@Param("orderItem") OrderItem orderItem);
	
	/**
	 * 根据条件查找
	 * @param orderItem 查询条件
	 * @return 查询结果
	 */
//	List<OrderItem> selectWithClean(@Param("orderItem") OrderItem orderItem);
	
	/**
	 * 根据ID查找(不关联)
	 * @param orderItemId 订单项id
	 * @return 查询结果
	 */
	OrderItem selectWithCleanById(@Param("orderItemId") long orderItemId);
	
	/**
	 * 根据ID查找(关联其他)
	 * @param orderItemId 订单项id
	 * @return 查询结果
	 */
	OrderItem selectWithOneById(@Param("orderItemId") long orderItemId);
	
	/**
	 * 根据ID删除
	 * @param orderItemId 订单项id
	 * @return 影响的行数
	 */
	int deleteById(@Param("orderItemId") long orderItemId);
	
}
