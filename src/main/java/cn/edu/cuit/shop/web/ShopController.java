package cn.edu.cuit.shop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.dto.Result;
import cn.edu.cuit.shop.entity.Category;
import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Product;
import cn.edu.cuit.shop.entity.Property;
import cn.edu.cuit.shop.service.CategoryService;
import cn.edu.cuit.shop.service.GoodsService;
import cn.edu.cuit.shop.service.PropertyService;

/**
 * 该Controller是购物商城商品信息有关的Controller
 * @author kanyuxia
 *
 */
@Controller
public class ShopController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 获得所有的分类信息
	 * @return 所有的分类信息
	 */
	@RequestMapping(value="shop.com/cats", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<Category>> getCategory() {
		List<Category> listCategory = categoryService.listCats();
		return new Result<List<Category>>(true, listCategory);
	}
	
	/**
	 * 获得产品信息
	 * @return 产品信息
	 */
	@RequestMapping(value="list.shop.com/cat/{catID}/products", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<Product>> getProsBySellNum(
			@PathVariable(value="catID", required=true) long catID,
			@RequestParam(value="sort", required=true) String sort, 
			@RequestParam(value="offset", defaultValue="0") long offset,
			@RequestParam(value="number", defaultValue="20") long number) {
		List<Product> list = null;
		System.out.println(sort + offset + number);
		if (sort.equals("sort_totalsales")) {
			list = goodsService.listPageBySellNum(offset, number);
		} else if (sort.equals("sort_date")) {
			list = goodsService.listPageByTime(offset, number);
		} else if (sort.equals("sort_inventorynums")) {
			list = goodsService.listPageByInvNum(offset, number);
		}
		return new Result<List<Product>>(true, list);
	}
	
	
	/**
	 * 通过分类ID查询其所对应的属性信息及其属性值信息(唯一性)
	 * @return 对应的属性信息及其属性值信息(唯一性)
	 */
	@RequestMapping(value="list.shop.com/cat/{catID}/properties", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<Property>> getProperties(@PathVariable(value="catID", required=true)long catID) {
		List<Property> list = propertyService.listProperties(catID);
		return new Result<List<Property>>(true, list);
	}
	
	
	@RequestMapping(value="item.shop.com/{goodsID}/current", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Goods> getGoods(@PathVariable(value="goodsID", required=true) long goodsID) {
		Goods goods = goodsService.getGoodsByGoodsID(goodsID);
		return new Result<Goods>(true, goods);
	}
}
