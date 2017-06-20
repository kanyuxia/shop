package cn.edu.cuit.shop.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.Inventory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestInventoryDao {
	
	@Autowired
	private InventoryDao inventoryDao;
	
	@Test
	public void testInsert() {
		Inventory inventory = new Inventory(1, new Date(), 1000, 1, 10004);
		
		int countNum = inventoryDao.insertInventory(inventory);
		System.out.println(countNum);
	}
	
	@Test
	public synchronized void testUpdate() {
		
		int shopNum = 5;
		
		Inventory inventory = inventoryDao.selectWithCleanByGoodsId(1);
		inventory.setInventoryNumber(inventory.getInventoryNumber() - shopNum);
		inventory.setSellNumber(inventory.getSellNumber() + shopNum);
		
		int countNum = inventoryDao.updateInventoryByGoodsId(inventory);
		System.out.println(countNum);
	}
	@Test
	public void testSelectCleanById() {
		Inventory inventory = inventoryDao.selectWithCleanById(1);
		System.out.println(inventory);
	}
	
	@Test
	public void testSelectWithCleanByGoodsId() {
		Inventory inventory = inventoryDao.selectWithCleanByGoodsId(1);
		System.out.println(inventory);
	}
	
	
	@Test
	public void testDeleteById() {
		int countNum = inventoryDao.deleteById(1);
		System.out.println(countNum);
	}
	
	@Test
	public void testDeleteByGoodsId() {
		int countNum = inventoryDao.deleteByGoodsId(1);
		System.out.println(countNum);
	}
}
