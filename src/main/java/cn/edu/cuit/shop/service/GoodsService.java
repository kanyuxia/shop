package cn.edu.cuit.shop.service;

import java.util.List;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Product;

public interface GoodsService {
	
	/**
	 * 通过销量分页查询产品
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	List<Product> listPageBySellNum(long offsetStart, long number); 
	
	/**
	 * 通过库存分页查询产品
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	List<Product> listPageByInvNum(long offsetStart, long number);
	
	/**
	 * 通过上架时间分页查询产品
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	List<Product> listPageByTime(long offsetStart, long number);
	
	/**
	 * 通过商品ID返回该商品的所有信息:包含其关联的产品的全部信息
	 * @param goodsID
	 * @return 商品信息及其产品信息
	 */
	Goods getGoodsByGoodsID(long goodsID);
}
