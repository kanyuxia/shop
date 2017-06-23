package cn.edu.cuit.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.shop.dao.GoodsDao;
import cn.edu.cuit.shop.dao.InventoryDao;
import cn.edu.cuit.shop.dao.ProductDao;
import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Inventory;
import cn.edu.cuit.shop.entity.Product;
import cn.edu.cuit.shop.service.GoodsService;
import cn.edu.cuit.shop.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<Product> queryByPageSize(int offset, int size) {
		List<Product> list = productDao.selectHightest(offset, size);
		return list;
	}

	@Override
	public List<Product> queryAll() {
		List<Product> list = productDao.selectAll();
		return list;
	}

	@Override
	public boolean addProduct(String name, String attributes, int categoryID) {
		Product product = new Product();
		product.setCreateTime(new Date());
		product.setAttributes(attributes);
		product.setCategoryID(categoryID);
		product.setName(name);
		int countNum = productDao.insertProduct(product);
		return countNum == 1 ? true : false;
	}

	
	public void save(List<Goods> goods, List<Inventory> inventorys) {
		for(int i = 0; i < goods.size(); i++) {
			goods.get(i).setCreateTime(new Date());
			goodsDao.insertGoods(goods.get(i));
			inventorys.get(i).setGoodsID(goodsDao.selectId(goods.get(i)));
			inventorys.get(i).setCreateTime(new Date());
			inventoryDao.insertInventory(inventorys.get(i));
		}
	}

}
