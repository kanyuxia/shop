package cn.edu.cuit.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.shop.dao.InventoryDao;
import cn.edu.cuit.shop.entity.Inventory;
import cn.edu.cuit.shop.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryDao inventoryDao;
	
	/**
	 * 通过商品ID返回该商品的库存信息
	 * @param goodsID 商品ID
	 * @return 库存信息
	 */
	public Inventory getInventByGoodsID(long goodsID) {
		Inventory inventory = inventoryDao.selectWithCleanByGoodsId(goodsID);
		return inventory;
	}
}
