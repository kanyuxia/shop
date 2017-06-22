package cn.edu.cuit.shop.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.dto.Result;
import cn.edu.cuit.shop.entity.Category;
import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Inventory;
import cn.edu.cuit.shop.entity.Product;
import cn.edu.cuit.shop.entity.Property;
import cn.edu.cuit.shop.entity.PropertyValue;
import cn.edu.cuit.shop.service.CategoryService;
import cn.edu.cuit.shop.service.GoodsService;
import cn.edu.cuit.shop.service.InventoryService;
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
	@Autowired
	private InventoryService inventoryService;
	
	
	/**
	 * 获得所有的分类信息
	 * @return 所有的分类信息
	 */
	@RequestMapping(value="/index/cats", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<Category>> getCategory() {
		List<Category> listCategory = categoryService.listCats();
		return new Result<List<Category>>(true, listCategory);
	}
	
	/**
	 * 获得最高销量相关商品信息
	 * @param number 商品数量
	 * @return 相关商品信息
	 */
	@RequestMapping(value="/index/highsell/{number}", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<Product>> getHighsell(
			@PathVariable(value="number", required=true)long number) {
		List<Product> list = goodsService.listHightestBySellNum(number);
		return new Result<List<Product>>(true, list);
	}
	
	/**
	 * 通过分类IDs获取其相关商品信息
	 * @param catID 分类ID
	 * @return 相关商品信息
	 */
	@RequestMapping(value="/index/info", method=RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<List<List<Product>>>> getHighsellByCatID(@RequestBody long[] catIDs) {
		System.out.println(Arrays.toString(catIDs));
		List<List<List<Product>>> list = new ArrayList<>(2);
		for (long categoryID : catIDs) {
			List<List<Product>> sonList = new ArrayList<>(2);
			// 返回6件最高销量的商品信息
			List<Product> inventProducts = goodsService.listInventByCatID(categoryID);
			// 返回5件最多库存的商品信息
			List<Product> sellProducts = goodsService.listHightestSellByCatID(categoryID);
			sonList.add(inventProducts);
			sonList.add(sellProducts);
			list.add(sonList);
		}
		
		return new Result<List<List<List<Product>>>>(true, list); 
	}
	
	
	/**
	 * 获得商品信息
	 * @param catID 产品ID
	 * @param sort 排序方式
	 * @param offset 起始偏移量
	 * @param number 产品数量
	 * @return 商品信息
	 */
	@RequestMapping(value="/cat/{catID}/products", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<Product>> getProsBySellNum(
			@PathVariable(value="catID", required=true) long catID,
			@RequestParam(value="sort", required=true) String sort, 
			@RequestParam(value="offset", defaultValue="0") long offset,
			@RequestParam(value="number", defaultValue="20") long number) {
		List<Product> list = null;
		System.out.println(catID + sort + offset + number);
		if (sort.equals("sort_sales")) {
			list = goodsService.listPageBySellNum(catID, offset, number);
		} else if (sort.equals("sort_date")) {
			list = goodsService.listPageByTime(catID, offset, number);
		} else if (sort.equals("sort_inventorynums")) {
			list = goodsService.listPageByInvNum(catID, offset, number);
		} else if (sort.equals("sort_price")) {
			list = goodsService.listPageByPrice(catID, offset, number);
		}
		return new Result<List<Product>>(true, list);
	}
	
	
	/**
	 * 通过分类ID查询其所对应的属性信息及其属性值信息(唯一性)
	 * @param catID 分类ID
	 * @return 对应的属性信息及其属性值信息(唯一性)
	 */
	@RequestMapping(value="/cat/{catID}/properties", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<Property>> getProsByCatID(@PathVariable(value="catID", required=true)long catID) {
		List<Property> list = propertyService.listProperties(catID);
		return new Result<List<Property>>(true, list);
	}
	
	
	/**
	 * 通过商品ID请求商品的所有信息:包含其关联的产品的全部信息
	 * @param goodsID 商品ID
	 * @return 商品的所有信息:包含其关联的产品的全部信息
	 */
	@RequestMapping(value="/item/{goodsID}/current", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Goods> getGoods(@PathVariable(value="goodsID", required=true) long goodsID) {
		Goods goods = goodsService.getGoodsByGoodsIDofAll(goodsID);
		return new Result<Goods>(true, goods);
	}
	
	/**
	 * 通过商品ID返回其对于产品的属性信息
	 * @param goodsID 商品ID
	 * @return 商品对于的属性信息
	 */
	@RequestMapping(value="/item/{goodsID}/properties", method=RequestMethod.GET,
			produces={"application/json;chartset=UTF-8"})
	@ResponseBody
	public Result<List<PropertyValue>> getProsByGoodsID(
			@PathVariable(value="goodsID", required=true)long goodsID) {
		List<PropertyValue> list = propertyService.listValuesByProID(goodsID);
		return new Result<List<PropertyValue>>(true, list);
	}
	
	/**
	 * 通过商品ID返回其对于的库存信息
	 * @param goodsID 商品ID
	 * @return 商品对于的库存信息
	 */
	@RequestMapping(value="/item/{goodsID}/inventory", method=RequestMethod.GET,
			produces={"application/json;chartset=UTF-8"})
	@ResponseBody
	public Result<Inventory> getInventByGoodsID(
			@PathVariable(value="goodsID", required=true)long goodsID) {
		Inventory inventory = inventoryService.getInventByGoodsID(goodsID);
		return new Result<Inventory>(true, inventory);
	}
}
