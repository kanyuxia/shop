package cn.edu.cuit.shop.dao;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestGoodsDao {
	@Autowired
	private GoodsDao goodsDao;
	
	@Test
	public void testInsert() {
		Goods goods1 = new Goods(12, new Date(), "16G,金色", 2388.00, 2388.00, 10003);
		Goods goods2 = new Goods(12, new Date(), "64G,金色", 2988.00, 2988.00, 10003);
		Goods goods3 = new Goods(12, new Date(), "32G,黑色", 4899.00, 4899.00, 10004);
		Goods goods4 = new Goods(12, new Date(), "128G,金色", 5688.00, 5688.00, 10004);
		Goods goods5 = new Goods(12, new Date(), "32G,白色", 1599.00, 1599.00, 10000);
		Goods goods6 = new Goods(12, new Date(), "32G,金色", 1699.00, 1699.00, 10000);
		
		int countNum1 = goodsDao.insertGoods(goods1);
		int countNum2 = goodsDao.insertGoods(goods2);
		int countNum3 = goodsDao.insertGoods(goods3);
		int countNum4 = goodsDao.insertGoods(goods4);
		int countNum5 = goodsDao.insertGoods(goods5);
		int countNum6 = goodsDao.insertGoods(goods6);
		
		
		System.out.println(countNum1);
		System.out.println(countNum2);
		System.out.println(countNum3);
		System.out.println(countNum4);
		System.out.println(countNum5);
		System.out.println(countNum6);
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
