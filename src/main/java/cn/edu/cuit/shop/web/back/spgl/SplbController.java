package cn.edu.cuit.shop.web.back.spgl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.Inventory;
import cn.edu.cuit.shop.entity.Product;
import cn.edu.cuit.shop.entity.back.order.BackGoods;
import cn.edu.cuit.shop.entity.back.order.DataGridJson;
import cn.edu.cuit.shop.service.GoodsService;
import cn.edu.cuit.shop.service.ProductsService;

/**
 * 商品列表控制器
 * @author echo
 *
 */
@Controller
public class SplbController {
	@Autowired
	private ProductsService productsService;
	@Autowired
	private GoodsService goodsService;
	/**
	 * 返回产品数据
	 * @param page
	 * @param rows
	 */
	@RequestMapping(value = "/QueryProducts", method = {RequestMethod.GET,RequestMethod.POST}, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public DataGridJson QueryProducts(int page, int rows) {
		List<Product> list = productsService.queryByPageSize((page - 1) * rows, rows);
		
		DataGridJson dj = new DataGridJson();
		dj.setTotal(list.size());
		dj.setRows(list);
		
		return dj;
		
	}
	
	@RequestMapping(value = "/QueryByProductId", method = {RequestMethod.GET,RequestMethod.POST}, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public DataGridJson QueryByProductId(Long productID) {
		if (productID == null) {
			return null;
		}
		System.out.println("商品列表");
		// 通过产品id获得对应的商品
		List<Goods> goods = goodsService.getGoodsByProductId(productID);
		// 返回的商品信息类型
		List<BackGoods> backGoods = new ArrayList<BackGoods>();
		
		if (goods != null) {
			for (Goods good : goods) {
				BackGoods bk = new BackGoods();
				bk.setGoodsID(good.getGoodsID());
				bk.setCreateTime(good.getCreateTime());
				bk.setAttributes(good.getAttributes());
				bk.setOriginalPrice(good.getOriginalPrice());
				bk.setSellPrice(good.getSellPrice());
				// 库存
				backGoods.add(bk);
			}
		}
		
		DataGridJson dj = new DataGridJson(backGoods.size(), backGoods);
		return dj;
	}
}
