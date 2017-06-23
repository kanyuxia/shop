package cn.edu.cuit.shop.web.back.spgl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Inventory;
import cn.edu.cuit.shop.entity.Product;
import cn.edu.cuit.shop.entity.back.order.BackGoods;
import cn.edu.cuit.shop.entity.back.order.SpsjSelect;
import cn.edu.cuit.shop.service.ProductsService;

@Controller
public class SpsjController {
	
	@Autowired
	private ProductsService productService;
	
	@RequestMapping(value = "/addGoods", method = {RequestMethod.GET,RequestMethod.POST}, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void addGoods(@RequestBody BackGoods[] goods1) {
		// 商品
		List<Goods> goods = new ArrayList<Goods>();
		// 库存
		List<Inventory> Inventorys = new ArrayList<Inventory>();
		
		System.out.println("商品上架");
		// 循环取出前台返回的商品对象
		for (BackGoods bg : goods1) {
			// 取得数据库保存的商品实体
			goods.add(getGoods(bg));
			// 库存对象
			Inventorys.add(getInventory(bg));
		}
		productService.save(goods, Inventorys);
	}
	
	/**
	 * 传入页面返回的商品信息，解析得到Goods对象
	 * @param backGoods1
	 * @return
	 */
	public Goods getGoods(BackGoods backGoods1) {
		Goods g = new Goods();
		// 设置产品ID
		g.setProductID(backGoods1.getProductID());
		// 商品属性
		g.setAttributes(backGoods1.getAttributes());
		// 原价
		g.setOriginalPrice(backGoods1.getOriginalPrice());
		// 售价
		g.setSellPrice(backGoods1.getSellPrice());
		return g;
	}
	
	/**
	 * 取得库存实体
	 * @param backGoods1
	 * @return
	 */
	public Inventory getInventory(BackGoods backGoods1) {
		Inventory in = new Inventory();
		in.setInventoryNumber(backGoods1.getInventoryNumber());
		return in;
	}
	
	@RequestMapping(value = "/queryProducts", method = {RequestMethod.GET,RequestMethod.POST}, produces = { "application/json;charset=UTF-8" })
	
	public @ResponseBody List<SpsjSelect> queryProducts() {
		List<Product> list = productService.queryAll();
		System.out.println(list);
		List<SpsjSelect> selects = new ArrayList<SpsjSelect>();
		
		if(list != null) {
			for (Product product : list) {
				SpsjSelect s = new SpsjSelect();
				s.setProductid(product.getProductID());
				s.setName(product.getName());
				selects.add(s);
			}
		}
		return selects;
	}
}
