package cn.edu.cuit.shop.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.dto.Result;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Orders;
import cn.edu.cuit.shop.entity.ShopCart;
import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.exception.SysException;
import cn.edu.cuit.shop.service.OrdersService;
import cn.edu.cuit.shop.service.ShopCatService;


/**
 * 该Controller是用户购物车、订单有关的Controller
 * @author kanyuxia
 *
 */
@Controller
public class UserBuyController {
	
	@Autowired
	private ShopCatService shopCatService;
	@Autowired
	private OrdersService ordersService;
	
	
	/**
	 * 获取用户购物车信息
	 * @return 用户购物车信息
	 */
	@RequestMapping(value="/cart/current", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<ShopCart>> getShopCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			List<ShopCart> list = shopCatService.listShopsByUserID(user.getUserID());
			return new Result<List<ShopCart>>(true, list);
		}
		return new Result<List<ShopCart>>(false, "没有登录");
	}
	
	/**
	 * 加入购物车
	 * @param goodsID 商品ID
	 * @param goodsNum 商品数量
	 * @return 是否加入成功
	 */
	@RequestMapping(value="/cart/addcart", method={RequestMethod.GET,RequestMethod.POST},
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Boolean> addCart(@RequestParam(value="gid", required=true) long goodsID,
			@RequestParam(value="gnum", defaultValue="1") long goodsNumber) {
		if (goodsNumber <= 0) {
			return new Result<Boolean>(false, "加入购物车失败,商品数量小于等于0");
		}
		//TODO 没有写用户的获取，这里直接写了用户ID
		boolean successed = shopCatService.addShopCart(10000, goodsID, goodsNumber);
		if (successed) {
			return new Result<Boolean>(true, true);
		}
		return new Result<Boolean>(false, "加入购物车失败");
	}
	
	
	/**
	 * 购物车中修改商品数量
	 * @param shopCartID 购物车ID
	 * @param goodsNum 商品数量
	 * @return 是否加入成功
	 */
	@RequestMapping(value="/cart/changeNum", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Boolean> changeNum(@RequestParam(value="sid", required=true) long shopCartID,
			@RequestParam(value="gnum", required=true) long goodsNumber) {
		if (goodsNumber <= 0) {
			return new Result<Boolean>(false, "加入购物车失败,商品数量小于等于0");
		}
		boolean successed = shopCatService.updateGoodsNumber(shopCartID, goodsNumber);
		if (successed) {
			return new Result<Boolean>(true, true);
		}
		return new Result<Boolean>(false, "加入购物车失败");
	}
	
	/**
	 * 购物车中删除商品
	 * @param shopCartID 购物车ID
	 * @return 是否加入成功
	 */
	@RequestMapping(value="/cart/delete", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Boolean> changeNum(@RequestParam(value="sid", required=true) long shopCartID) {
		boolean successed = shopCatService.deleteShopCart(shopCartID);
		if (successed) {
			return new Result<Boolean>(true, true);
		}
		return new Result<Boolean>(false, "失败");
	}
	
	/**
	 * 获得用户订单
	 * @return 是否购买成功
	 */
	@RequestMapping(value="/order/current", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<List<Orders>> getOrders(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			List<Orders> list = ordersService.queryUserOrders(user);
			return new Result<List<Orders>>(true, list);
		}
		return new Result<List<Orders>>(false, "没有登录");
	}
	
	/**
	 * 提交订单(购买商品)
	 * @param orders 商品信息
	 * @return 是否购买成功
	 */
	@RequestMapping(value="/order/commit", method=RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Boolean> commitOrders(@RequestBody() Orders orders) {
		orders.setCreateTime(new Date());
		for (OrderItem orderItem : orders.getItems()) {
			orderItem.setCreateTime(new Date());
		}
		try {
			ordersService.commitOrders(orders);
			return new Result<Boolean>(true, true);
		} catch (SysException e) {
			return new Result<Boolean>(false, e.getMessage());
		}
	}
}
