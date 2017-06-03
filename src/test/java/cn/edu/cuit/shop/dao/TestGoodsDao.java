package cn.edu.cuit.shop.dao;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestGoodsDao {
	@Autowired
	private GoodsDao goodsDao;
	
	@Test
	public void testInsert() {
		Goods goods = new Goods(12, new Date(), "四核,64G", 1200, 1199, 2);
		
		int countNum = goodsDao.insertGoods(goods);
		System.out.println(countNum);
	}
	
	@Test
	public void testUpdate() {
		Goods goods = goodsDao.selectWithCleanById(4);
		goods.setAttributes("64G,四核");
		goods.setSellPrice(10.00);
		
		int countNum = goodsDao.updateGoods(goods);
		System.out.println(countNum);
	}
	@Test
	public void testSelectCleanById() {
		Goods goods = goodsDao.selectWithCleanById(4);
		System.out.println(goods);
	}
	
	@Test
	public void testSelectWithOneById() {
		Goods goods = goodsDao.selectWithOneById(4);
		System.out.println(goods);
	}
	
	
	@Test
	public void testDeleteById() {
		int countNum = goodsDao.deleteById(4);
		System.out.println(countNum);
	}
}
