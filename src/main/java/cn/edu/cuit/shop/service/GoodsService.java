package cn.edu.cuit.shop.service;

import java.util.List;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Product;

public interface GoodsService {
	
	/**
	 * 获得销量最高的商品信息
	 * @param number 商品数目
	 * @return 商品信息
	 */
	List<Product> listHightestBySellNum(long number);
	
	/**
	 * 通过分类ID获取5件销量最高的商品信息
	 * @param categoryID
	 * @return
	 */
	List<Product> listHightestSellByCatID(long categoryID);
	
	/**
	 * 通过分类ID获取5件库存最多商品信息
	 * @param categoryID
	 * @return
	 */
	List<Product> listInventByCatID(long categoryID);
	
	
	/**
	 * 根据分类ID依据销量分页查询产品信息
	 * @Param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	List<Product> listPageBySellNum(long categoryID, long offsetStart, long number); 
	
	/**
	 * 根据分类ID依据库存量分页查询产品信息
	 * @Param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	List<Product> listPageByInvNum(long categoryID, long offsetStart, long number);
	
	/**
	 * 根据分类ID依据上架时间分页查询产品信息
	 * @Param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	List<Product> listPageByTime(long categoryID, long offsetStart, long number);
	
	/**
	 * 根据分类ID依据价格高低分页查询产品信息
	 * @param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param rowCount 行数
	 * @return 产品信息
	 */
	List<Product> listPageByPrice(long categoryID, long offsetStart, long number);
	
	/**
	 * 通过商品ID返回该商品的所有信息:包含其关联的产品的全部信息
	 * @param goodsID 商品ID
	 * @return 商品信息及其产品信息
	 */
	Goods getGoodsByGoodsIDofAll(long goodsID);
	
	
}
