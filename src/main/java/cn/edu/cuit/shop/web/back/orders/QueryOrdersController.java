package cn.edu.cuit.shop.web.back.orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.entity.Goods;
import cn.edu.cuit.shop.entity.OrderItem;
import cn.edu.cuit.shop.entity.Orders;
import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.entity.back.order.BackOrder;
import cn.edu.cuit.shop.entity.back.order.BackOrderItem;
import cn.edu.cuit.shop.entity.back.order.DataGridJson;
import cn.edu.cuit.shop.service.OrderItemService;
import cn.edu.cuit.shop.service.OrdersService;

/**
 * 后台订单查询控制器
 * 
 * @author echo
 *
 */
@Controller
public class QueryOrdersController {

	@Autowired
	private OrdersService orderService;
	@Autowired
	private OrderItemService orderItemServiice;

	/**
	 * 查询分页订单数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryOrders", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public DataGridJson queryOrders(int page, int rows, Integer ordersID,
			@RequestParam(defaultValue="-1")long id, HttpServletResponse resp) {
//		System.out.println(id + ordersID);
		// 返回拼装好的数据
		DataGridJson oj = new DataGridJson();
		// 订单集合
		List<BackOrder> list = new ArrayList<BackOrder>();
		// 是否是查询操作
		System.out.println(ordersID);
		if (ordersID == null && id == -1) {
			List<Orders> orders = orderService.queryAllOrders(
					((page - 1) * rows), rows);
			// 循环获得的订单
			for (Orders order : orders) {
				// 获得用户对象
				User user = order.getUser();
				BackOrder bd = new BackOrder();
				// 设置订单编号
				bd.setOrdersID(order.getOrdersID());
				// 设置订单生成时间
				bd.setCreateTime(order.getCreateTime());
				// 设置用户账号
				bd.setNumber(user.getNumber());
				// 设置用户姓名
				bd.setNickname(user.getNickname());
				// 收货地址
				bd.setHarvestAddress(order.getHarvestAddress());
				// 订单状态
				bd.setStatus(order.getStatus());
				// 总价格
				bd.setTotalPrice(order.getTotalPrice());
				list.add(bd);
			}
			oj.setTotal(orders.size());
			oj.setRows(list);
		} else {
			// 不是进行id查询，进行用户名查询
			if (ordersID == null) {
				oj = queryOrderByNickName(id);
			} else { // 否则，进行id查询
				System.out.println(ordersID);
				oj = queryOrderByOrderId(ordersID);
			}
		}
		return oj;
	}

	/**
	 * 根据订单id查询对应的订单项
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryOrderItemsByorderId", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public DataGridJson queryOrderItemsByorderId(long ordersID) {
		// 根据订单id查询订单对应的订单项
		List<OrderItem> orderItems = orderItemServiice.queryByOrderId(ordersID);
		// 装取出的订单项
		List<BackOrderItem> items = new ArrayList<BackOrderItem>();
		// 循环取出对象
		for (OrderItem orderItem : orderItems) {
			BackOrderItem backItem = new BackOrderItem();
			// 设置订单id
			backItem.setOrderItemID(orderItem.getOrderItemID());
			// 设置时间
			backItem.setCreateTime(orderItem.getCreateTime());
			// 设置商品数量
			backItem.setGoodsNumber(orderItem.getGoodsNumber());

			Goods goods = orderItem.getGoods();
			// 设置属性
			backItem.setAttributes(goods.getAttributes());
			// 设置原价
			backItem.setOriginalPrice(goods.getOriginalPrice());
			// 设置售价
			backItem.setSellPrice(goods.getSellPrice());
			items.add(backItem);
		}

		// JSON格式类
		DataGridJson orderJson = new DataGridJson(orderItems.size(), items);
		return orderJson;
	}

	/**
	 * 根据订单id查询订单
	 * 
	 * @return 订单JSON
	 */
	public DataGridJson queryOrderByOrderId(long OrderId) {
		try {
		// 获得订单
		Orders order = orderService.getOrdersById(OrderId);
		// 拼装为前台显示的JSON
		BackOrder bd = new BackOrder();
		// 获得用户对象
		if (order.getUser() != null) {
			User user = order.getUser();
			// 设置用户账号
			bd.setNumber(user.getNumber());
			// 设置用户姓名
			bd.setNickname(user.getNickname());
		}
		// 设置订单编号
		bd.setOrdersID(order.getOrdersID());
		// 设置订单生成时间
		bd.setCreateTime(order.getCreateTime());
		// 收货地址
		bd.setHarvestAddress(order.getHarvestAddress());
		// 订单状态
		bd.setStatus(order.getStatus());
		// 总价格
		bd.setTotalPrice(order.getTotalPrice());

		List<BackOrder> backOrders = new ArrayList<BackOrder>();
		backOrders.add(bd);
		DataGridJson oj = new DataGridJson(backOrders.size(), backOrders);
		return oj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据用户昵称查询订单
	 * 
	 * @return
	 */
	public DataGridJson queryOrderByNickName(long nickname) {
		DataGridJson oj = new DataGridJson();
		try {
			List<Orders> orders = orderService.queryOrdersByNickName(nickname);
			List<BackOrder> list = new ArrayList<BackOrder>();
			// 循环获得的订单
			for (Orders order : orders) {
				// 获得用户对象
				User user = order.getUser();
				BackOrder bd = new BackOrder();
				// 设置订单编号
				bd.setOrdersID(order.getOrdersID());
				// 设置订单生成时间
				bd.setCreateTime(order.getCreateTime());
				// 设置用户账号
				bd.setNumber(user.getNumber());
				// 设置用户姓名
				bd.setNickname(user.getNickname());
				// 收货地址
				bd.setHarvestAddress(order.getHarvestAddress());
				// 订单状态
				bd.setStatus(order.getStatus());
				// 总价格
				bd.setTotalPrice(order.getTotalPrice());
				list.add(bd);
			}
			oj.setTotal(orders.size());
			oj.setRows(list);
		} catch (Exception e) {
			oj.setTotal(0);
		}
		return oj;
	}
}
