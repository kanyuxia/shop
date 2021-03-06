package cn.edu.cuit.shop.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cuit.shop.entity.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TestCategoryDao {
	@Autowired
	private CategoryDao categoryDao;
	
	@Test
	public void testInsertCategory() {
		int countNum1 =  categoryDao.insertCategory("手机");
		int countNum2 = categoryDao.insertCategory("手机配件");
		System.out.println(countNum1);
		System.out.println(countNum2);
	}
	
	@Test
	public void testUpdateCategory() {
		int countNum1 = categoryDao.updateCategory(10001, "手机配件1");
		System.out.println(countNum1);
	}
	
	@Test
	public void testDeleteCategory() {
		int countNum1 = categoryDao.deleteCategory(10001);
		System.out.println(countNum1);
	}
	
	@Test
	public void testSelectAll() {
		List<Category> categories = categoryDao.selectAll();
		System.out.println(categories);
	}
}
