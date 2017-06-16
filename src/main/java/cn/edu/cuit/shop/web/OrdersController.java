package cn.edu.cuit.shop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.edu.cuit.shop.dto.Result;
import cn.edu.cuit.shop.entity.Orders;
import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.exception.SysException;
import cn.edu.cuit.shop.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping(value="/my", method=RequestMethod.GET, 
			produces={"application/json;charset=UTF-8"})
	public @ResponseBody Result<List<Orders>> getMyOrders(User user){
		List<Orders> orders;
		orders = ordersService.queryUserOrders(user);
		return new Result<List<Orders>>(true, orders);
	}
	
	@RequestMapping(value="/cancel/{ordersId}", method=RequestMethod.GET, 
			produces={"application/json;charset=UTF-8"})
	public @ResponseBody Result<Object> cancelOrders(@PathVariable long ordersId){
		boolean flag = ordersService.cancelOrdersById(ordersId);
		if (flag) {
			return new Result<Object>(true, "取消成功");
		}
		return new Result<Object>(false, "取消失败");
	}
	
	@RequestMapping(value="/item/{ordersId}", method=RequestMethod.GET, 
			produces={"application/json;charset=UTF-8"})
	public @ResponseBody Result<Orders> item(@PathVariable long ordersId){
		Orders orders = ordersService.getOrdersById(ordersId);
		return new Result<Orders>(true, orders);
	}
	
	@RequestMapping(value="/commit", method=RequestMethod.GET, 
			produces={"application/json;charset=UTF-8"})
	public @ResponseBody Result<Object> commit(Orders orders){
		boolean flag = false;
		try {
			flag = ordersService.commitOrders(orders);
			if (flag) {
				return new Result<Object>(true, "提交成功");
			}
			return new Result<Object>(false, "提交失败");
		} catch (SysException e) {
			return new Result<Object>(true, e.getMessage());
		}
	}
}
