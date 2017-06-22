package cn.edu.cuit.shop.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	
	/**
	 * 获得销量最高的商品信息
	 * @param number 商品数目
	 * @return 商品信息
	 */
	List<Product> selectHightestBySellNum(long number);
	
	/**
	 * 根据分类ID依据销量分页查询产品信息
	 * @param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param rowCount 行数
	 * @return 产品信息
	 */
	List<Product> selectPageBySellNum(@Param("categoryID")long categoryID, @Param("offsetStart")long offsetStart, 
			@Param("rowCount")long rowCount);
	
	/**
	 * 根据分类ID依据库存量分页查询产品信息
	 * @param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param rowCount 行数
	 * @return 产品信息
	 */
	List<Product> selectPageByInvNum(@Param("categoryID")long categoryID, @Param("offsetStart")long offsetStart, 
			@Param("rowCount")long rowCount);
	
	/**
	 * 根据分类ID依据上架时间分页查询产品信息
	 * @param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param rowCount 行数
	 * @return 产品信息
	 */
	List<Product> selectPageByTime(@Param("categoryID")long categoryID, @Param("offsetStart")long offsetStart, 
			@Param("rowCount")long rowCount);
	
	
	/**
	 * 根据分类ID依据价格高低分页查询产品信息
	 * @param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param rowCount 行数
	 * @param order 排序方式
	 * @return 产品信息
	 */
	List<Product> selectPageByPrice(@Param("categoryID")long categoryID, @Param("offsetStart")long offsetStart, 
			@Param("rowCount")long rowCount);
}
