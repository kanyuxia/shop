package cn.edu.cuit.shop.web.back.yhgl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.entity.back.order.BackUser;
import cn.edu.cuit.shop.entity.back.order.DataGridJson;
import cn.edu.cuit.shop.service.UserService;

@Controller
public class YhlbController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/queryUserByPageSize", method = {RequestMethod.GET,RequestMethod.POST}, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public DataGridJson queryUserByPageSize(int page, int rows) {
		// 得到用户数据
		List<User> users = userService.queryUsersByPageSize((page - 1) * rows, rows);
		// 返回的数据
		List<BackUser> backUsers = new ArrayList<BackUser>();
		if(users != null) {
			for (User user : users) {
				BackUser bu = new BackUser(user.getUserID(), user.getCreateTime(), user.getNumber(), user.getNickname(), user.getSex());
				backUsers.add(bu);
			}
		}
		DataGridJson dj = new DataGridJson(backUsers.size(), backUsers);
		return dj;
	}
}
