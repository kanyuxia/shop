package cn.edu.cuit.shop.service;

import cn.edu.cuit.shop.entity.Inventory;

public interface InventoryService {
	/**
	 * 通过商品ID返回该商品的库存信息
	 * @param goodsID 商品ID
	 * @return 库存信息
	 */
	Inventory getInventByGoodsID(long goodsID);
}
