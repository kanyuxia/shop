package cn.edu.cuit.shop.dao;

import org.apache.ibatis.annotations.Param;

import cn.edu.cuit.shop.entity.Inventory;

public interface InventoryDao {
	/**
	 * 插入库存
	 * @param inventory 要插入的实体
	 * @return 受影响的行数
	 */
	int insertInventory(@Param("inventory") Inventory inventory);
	
	/**
	 * 更新库存
	 * @param inventory
	 * @return
	 */
	int updateInventoryByGoodsId(@Param("inventory") Inventory inventory);
	
	/**
	 * 根据商品ID查询库存量以及销量
	 * @param goodsId 商品id
	 * @return 查询结果
	 */
	Inventory selectWithCleanByGoodsId(@Param("goodsId") long goodsId);
	
	/**
	 * 根据ID查找(不关联)
	 * @param inventoryId id
	 * @return 查询结果
	 */
	Inventory selectWithCleanById(@Param("inventoryId") long inventoryId);
	
	/**
	 * 根据ID删除
	 * @param inventoryId 库存id
	 * @return 影响的行数
	 */
	int deleteById(@Param("inventoryId") long inventoryId);
	
	/**
	 * 根据商品ID删除
	 * @param goodsId 商品id
	 * @return 影响的行数
	 */
	int deleteByGoodsId(@Param("goodsId") long goodsId);
}
