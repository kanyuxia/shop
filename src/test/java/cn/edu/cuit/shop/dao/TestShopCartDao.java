package cn.edu.cuit.shop.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cn.edu.cuit.shop.entity.ShopCart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestShopCartDao {
	@Autowired
	private ShopCartDao shopCartDao;
	
	@Test
	public void testInsertGoods() {
		int countNum1 = shopCartDao.insertGoods(10004, 1, 10000);
		int countNum2 = shopCartDao.insertGoods(10003, 1, 10000);
		int countNum3 = shopCartDao.insertGoods(10002, 1, 10001);
		
		System.out.println(countNum1);
		System.out.println(countNum2);
		System.out.println(countNum3);
	}
	
	@Test
	public void testSelectOneShopCart() {
		ShopCart shopCart = shopCartDao.selectOneShopCart(10004, 10000);
		System.out.println(shopCart);
	}
	
	@Test
	public void testUpdateGoodsNumber() {
		int countNum = shopCartDao.updateGoodsNumber(10000, 2);
		System.out.println(countNum);
	}
	
	@Test
	public void testSelectShopCart() {
		List<ShopCart> shopCarts = shopCartDao.selectShopCart(10000);
		System.out.println(shopCarts);
	}
	
	@Test
	public void testSelectShopCartAll() {
		List<ShopCart> shopCarts = shopCartDao.selectShopCartAll(10000);
		System.out.println(shopCarts);
	}
}
