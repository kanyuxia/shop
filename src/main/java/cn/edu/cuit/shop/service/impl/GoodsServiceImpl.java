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
	 * 获得销量最高的商品信息
	 * @param number 商品数目
	 * @return 商品信息
	 */
	public List<Product> listHightestBySellNum(long number){
		List<Product> list = productDao.selectHightestBySellNum(number);
		return list;
	}
	
	/**
	 * 通过分类ID获取5件销量最高的商品信息
	 * @param categoryID
	 * @return
	 */
	public List<Product> listHightestSellByCatID(long categoryID) {
		List<Product> list = productDao.selectPageBySellNum(categoryID, 0, 5);
		return list;
	}
	
	/**
	 * 通过分类ID获取5件库存最多的商品信息
	 * @param categoryID
	 * @return
	 */
	public List<Product> listInventByCatID(long categoryID) {
		List<Product> list = productDao.selectPageByInvNum(categoryID, 0, 6);
		return list;
	}

	/**
	 * 根据分类ID依据销量分页查询产品信息
	 * @Param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	public List<Product> listPageBySellNum(long categoryID, long offsetStart, long number) {
		List<Product> listProducts = productDao.selectPageBySellNum(categoryID, offsetStart, number);
		return listProducts;
	}

	/**
	 * 根据分类ID依据库存量分页查询产品信息
	 * @Param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	public List<Product> listPageByInvNum(long categoryID, long offsetStart, long number) {
		List<Product> listProducts = productDao.selectPageByInvNum(categoryID, offsetStart, number);
		return listProducts;
	}

	/**
	 * 根据分类ID依据上架时间分页查询产品信息
	 * @Param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param number 分页数目
	 * @return 产品信息
	 */
	public List<Product> listPageByTime(long categoryID, long offsetStart, long number) {
		List<Product> listProducts = productDao.selectPageByTime(categoryID, offsetStart, number);
		return listProducts;
	}
	
	/**
	 * 根据分类ID依据价格高低分页查询产品信息
	 * @param categoryID 分类ID
	 * @param offsetStart 起始偏移量
	 * @param rowCount 行数
	 * @return 产品信息
	 */
	public List<Product> listPageByPrice(long categoryID, long offsetStart, long number) {
		List<Product> listProducts = productDao.selectPageByPrice(categoryID, offsetStart, number);
		return listProducts;
	}

	/**
	 * 通过商品ID返回该商品的所有信息:包含其关联的产品的全部信息
	 * @param goodsID
	 * @return 商品信息及其产品信息
	 */
	public Goods getGoodsByGoodsIDofAll(long goodsID) {
		Goods goods = goodsDao.selectWithOneById(goodsID);
		Product product = productDao.selectWithGoodsById(goods.getProductID());
		goods.setProduct(product);
		return goods;
	}

	@Override
	public List<Goods> getGoodsByProductId(Long productID) {
		Product product = productDao.selectWithGoodsById(productID);
		return product.getGoods();
	}
}
