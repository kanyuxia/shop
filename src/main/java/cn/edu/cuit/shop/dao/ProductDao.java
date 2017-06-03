package cn.edu.cuit.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Product;

public interface ProductDao {

	/**
	 * 插入订单项
	 * @param product 要插入的实体
	 * @return 收影响的行数
	 */
	int insertProduct(@Param("product") Product product);
	
	/**
	 * 更新订单项
	 * @param product
	 * @return
	 */
	int updateProduct(@Param("product") Product product);
	
	/**
	 * 根据条件查找
	 * @param product 查询条件
	 * @return 查询结果
	 */
//	List<OrderItem> selectWithClean(@Param("orderItem") OrderItem orderItem);
	
	/**
	 * 根据ID查找(不关联)
	 * @param productId 订单项id
	 * @return 查询结果
	 */
	Product selectWithCleanById(@Param("productId") long productId);
	
	/**
	 * 根据ID查找(关联其他)
	 * @param productId 产品id
	 * @return 查询结果
	 */
	Product selectWithOneById(@Param("productId") long productId);
	
	/**
	 * 根据ID查找(关联商品)
	 * @param productId 产品id
	 * @return 查询
	 */
	Product selectWithGoodsById(@Param("productId") long productId);
	
	/**
	 * 根据ID删除
	 * @param productId 产品id
	 * @return 影响的行数
	 */
	int deleteById(@Param("productId") long productId);
	
}
