package cn.edu.cuit.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.shop.dao.GoodsDao;
import cn.edu.cuit.shop.dao.ProductDao;
import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Product;
import cn.edu.cuit.shop.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private GoodsDao goodsDao;

	/**
	 * 通过销量分页查询产品
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	public List<Product> listPageBySellNum(long offsetStart, long number) {
		List<Product> listProducts = productDao.selectPageBySellNum(offsetStart, number);
		return listProducts;
	}

	/**
	 * 通过库存分页查询产品
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	public List<Product> listPageByInvNum(long offsetStart, long number) {
		List<Product> listProducts = productDao.selectPageByInvNum(offsetStart, number);
		return listProducts;
	}

	/**
	 * 通过上架时间分页查询产品
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	public List<Product> listPageByTime(long offsetStart, long number) {
		List<Product> listProducts = productDao.selectPageByTime(offsetStart, number);
		return listProducts;
	}

	/**
	 * 通过商品ID返回该商品的所有信息:包含其关联的产品的全部信息
	 * @param goodsID
	 * @return 商品信息及其产品信息
	 */
	public Goods getGoodsByGoodsID(long goodsID) {
		Goods goods = goodsDao.selectWithOneById(goodsID);
		Product product = productDao.selectWithOneById(goods.getProductID());
		goods.setProduct(product);
		return goods;
	}
}
