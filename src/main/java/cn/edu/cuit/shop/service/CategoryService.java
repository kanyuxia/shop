package cn.edu.cuit.shop.service;

import java.util.List;

import cn.edu.cuit.shop.entity.Category;

public interface CategoryService {
	
	/**
	 * 管理员：查询所有的分类信息(不级联)
	 * @return 所有的分类信息
	 */
	List<Category> getAllCatsOfMana();
	
	/**
	 * 管理员：修改分类名称
	 * @param categoryID 分类ID
	 * @param newName 新分类名称
	 * @return 是否成功
	 */
	boolean modifyCatOfMana(long categoryID, String newName);
	
	/**
	 * 管理员：删除分类
	 * @param categoryID 分类ID
	 * @return 是否成功
	 */
	boolean deleteCatOfMana(long categoryID);
	
	
	/**
	 * 管理员：插入分类信息
	 * @param name 分类名称
	 * @return 是否成功
	 */
	boolean insertCatOfMana(String name);
	
}
