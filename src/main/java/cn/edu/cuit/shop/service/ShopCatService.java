package cn.edu.cuit.shop.service;

import java.util.List;

import cn.edu.cuit.shop.entity.ShopCart;

public interface ShopCatService {
	/**
	 * 通过用户ID返回其对应的购物车信息
	 * @param userID 用户ID
	 * @return 其对应的购物车信息
	 */
	List<ShopCart> listShopsByUserID(long userID);
	
	/**
	 * 用户删除购物车商品信息
	 * @param shopCartID 购物车ID
	 * @return 是否删除成功
	 */
	boolean deleteShopCart(long shopCartID);
	
	
	/**
	 * 将商品加入购物车
	 * @param userID
	 * @param goodsID
	 * @return 是否成功
	 */
	boolean addShopCart(long userID, long goodsID);
	
	/**
	 * 更新购物车中商品数量
	 * @param shopCartID 购物车ID
	 * @param goodsNumber 商品数量
	 * @return 是否成功
	 */
	boolean updateGoodsNumber(long shopCartID, long goodsNumber);
}
