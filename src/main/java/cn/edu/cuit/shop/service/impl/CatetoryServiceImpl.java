package cn.edu.cuit.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cuit.shop.dao.CategoryDao;
import cn.edu.cuit.shop.entity.Category;
import cn.edu.cuit.shop.service.CategoryService;

@Service
public class CatetoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	/**
	 * 管理员/用户：查询所有的分类信息
	 * @return 所有的分类信息
	 */
	public List<Category> listCats() {
		List<Category> categoryList = categoryDao.selectAll();
		return categoryList;
	}

	@Override
	public boolean modifyCat(long categoryID, String newName) {
		
		return false;
	}

	@Override
	public boolean deleteCat(long categoryID) {
		return false;
	}

	@Override
	public boolean insertCat(String name) {
		int countNum = categoryDao.insertCategory(name);
		return countNum == 1 ? true : false;
	}

	@Override
	public List<Category> queryByPagesize(int i, int rows) {
		List<Category> list = categoryDao.selectBypage(i, rows);
		return list;
	}

}
