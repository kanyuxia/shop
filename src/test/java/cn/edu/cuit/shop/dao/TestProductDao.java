package cn.edu.cuit.shop.dao;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestProductDao {
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testInsertOrderItem() {
		Product product = new Product(10, new Date(), "苹果", "内存,cpu", 1);
		
		int countNum = productDao.insertProduct(product);
		System.out.println(countNum);
	}
	
	@Test
	public void testUpdateProduct() {
		Product product = productDao.selectWithCleanById(2);
		product.setName("三星");
		
		int countNum = productDao.updateProduct(product);
		System.out.println(countNum);
	}
	@Test
	public void testSelectCleanById() {
		Product product = productDao.selectWithCleanById(2);
		System.out.println(product);
	}
	
	@Test
	public void testSelectWithOneById() {
		Product product = productDao.selectWithOneById(2);
		System.out.println(product);
	}
	
	@Test
	public void testSelectWithGoodsById() {
		Product product = productDao.selectWithGoodsById(1);
		System.out.println(product);
	}
	
	@Test
	public void testDeleteById() {
		int countNum = productDao.deleteById(2);
		System.out.println(countNum);
	}
}
