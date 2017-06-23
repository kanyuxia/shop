package cn.edu.cuit.shop.service;

import java.util.List;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Inventory;
import cn.edu.cuit.shop.entity.Product;

public interface ProductsService {
	
	/**
	 * 分页查询产品数据
	 * @param offset
	 * @param size
	 * @return
	 */
	public List<Product> queryByPageSize(int offset, int size);
	
	/**
	 * 查询所有产品数据
	 * @return
	 */
	public List<Product> queryAll();
	
	
	boolean addProduct(String name, String attributes, int categoryID);

	void save(List<Goods> goods, List<Inventory> inventorys);
}
