package cn.edu.cuit.shop.dao;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestProductDao {
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testInsertOrderItem() {
		Product product1 = new Product(10, new Date(), "小米5", "内存,颜色", 10000);
		Product product2 = new Product(10, new Date(), "小米6", "内存,颜色", 10000);
		Product product3 = new Product(10, new Date(), "华为mate9", "内存,颜色", 10000);
		Product product4 = new Product(10, new Date(), "IPhone6", "内存,颜色", 10000);
		Product product5 = new Product(10, new Date(), "IPhone7", "内存,颜色", 10000);
		
		int countNum1 = productDao.insertProduct(product1);
		int countNum2 = productDao.insertProduct(product2);
		int countNum3 = productDao.insertProduct(product3);
		int countNum4 = productDao.insertProduct(product4);
		int countNum5 = productDao.insertProduct(product5);
		
		
		System.out.println(countNum1);
		System.out.println(countNum2);
		System.out.println(countNum3);
		System.out.println(countNum4);
		System.out.println(countNum5);
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
