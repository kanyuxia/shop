package cn.edu.cuit.shop.web.back.flgl.spfl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.entity.Category;
import cn.edu.cuit.shop.entity.back.order.DataGridJson;
import cn.edu.cuit.shop.service.CategoryService;

@Controller
public class SpflController {
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
	@ResponseBody
	public boolean addcategory(String spfl) {
		return categoryService.insertCat(spfl);
	}
	
	
	/**
	 * 分页查询分类数据
	 */
	@RequestMapping(value = "/querycategory", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public DataGridJson queryPage(int page, int rows) {
		// 查询数据
		List<Category> list = categoryService.queryByPagesize((page -1 ) * rows, rows);
		DataGridJson oj = new DataGridJson(list.size(), list);
		return oj;
	}
}
