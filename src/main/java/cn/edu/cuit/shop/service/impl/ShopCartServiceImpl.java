package cn.edu.cuit.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.shop.dao.ShopCartDao;
import cn.edu.cuit.shop.entity.ShopCart;
import cn.edu.cuit.shop.service.ShopCatService;

@Service
public class ShopCartServiceImpl implements ShopCatService {
	
	@Autowired
	private ShopCartDao shopCartDao;

	/**
	 * 通过用户ID返回其对应的购物车信息
	 * @param userID 用户ID
	 * @return 其对应的购物车信息
	 */
	public List<ShopCart> listShopsByUserID(long userID) {
		List<ShopCart> listShopCarts = shopCartDao.selectShopCartAll(userID);
		return listShopCarts;
	}

	/**
	 * 用户删除购物车商品信息
	 * @param userID 用户ID
	 * @param shopCartID 购物车ID
	 * @return 是否删除成功
	 */
	public boolean deleteShopCart(long shopCartID) {
		int countNum = shopCartDao.deleteShopCart(shopCartID);
		return countNum == 1 ? true : false;
	}

	/**
	 * 将商品加入购物车
	 * @param userID
	 * @param goodsID
	 * @return 是否成功
	 */
	public boolean addShopCart(long userID, long goodsID, long goodsNumber) {
		ShopCart shopCart = shopCartDao.selectOneShopCart(goodsID, userID);
		if (shopCart == null) {
			int countNum = shopCartDao.insertGoods(goodsID, goodsNumber, userID);
			return countNum == 1 ? true : false;
		}
		return updateGoodsNumber(shopCart.getShopCartID(), shopCart.getGoodsNumber() + goodsNumber);
	}

	/**
	 * 更新购物车中商品数量
	 * @param shopCartID 购物车ID
	 * @param goodsNumber 商品数量
	 * @return 是否成功
	 */
	public boolean updateGoodsNumber(long shopCartID, long goodsNumber) {
		int countNum = shopCartDao.updateGoodsNumber(shopCartID, goodsNumber);
		return countNum == 1 ? true : false;
	}

}
