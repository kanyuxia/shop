package cn.edu.cuit.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.ShopCart;


public interface ShopCartDao {
	
	/**
	 * 向购物车插入商品
	 * @param goodsID 商品ID
	 * @param goodsNumber 商品数量
	 * @param userID 用户ID
	 * @return 数据库影响行数
	 */
	int insertGoods(@Param("goodsID")long goodsID, @Param("goodsNumber")long goodsNumber,
			@Param("userID")long userID);
	
	/**
	 * 查询购物车信息(不级联)
	 * @param goodsID 商品ID
	 * @param userID 用户ID
	 * @return 购物车信息
	 */
	ShopCart selectOneShopCart(@Param("goodsID")long goodsID, @Param("userID")long userID);
	
	/**
	 * 更新购物车中商品数量
	 * @param goodsID 商品ID
	 * @param goodsNumber 商品数量
	 * @param userID 用户ID
	 * @return 数据库影响行数
	 */
	int updateGoodsNumber(@Param("shopCartID") long shopCartID, @Param("goodsNumber")long goodsNumber);

	/**
	 * 查找用户的购物车数据(不级联)
	 * @param userID 用户ID
	 * @return 用户购物车数据
	 */
	List<ShopCart> selectShopCart(@Param("userID") long userID);
	
	/**
	 * 查找用户的购物车数据(级联)
	 * @param userID 用户ID
	 * @return 用户购物车数据
	 */
	List<ShopCart> selectShopCartAll(@Param("userID") long userID);
	
	/**
	 * 删除购物车
	 * @param shopCartID 购物车ID
	 * @return 数据库影响行数
	 */
	int deleteShopCart(@Param("shopCartID")long shopCartID);
}
