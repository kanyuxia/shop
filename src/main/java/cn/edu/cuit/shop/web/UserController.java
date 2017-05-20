package cn.edu.cuit.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.dto.Result;
import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 注册用户
	 * @param user 用户信息
	 * @return 注册结果
	 */
	@RequestMapping(value="/pass/register", method=RequestMethod.GET, 
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Object> register(User user){
		System.out.println(user);
		boolean successed = userService.register(user.getNumber(), user.getPassword(), 
				user.getNickname(), user.getSex());
		if (successed) {
			return new Result<Object>(true, null);
		}
		return new Result<Object>(false, "注册失败");
	}
	
	
	@RequestMapping(value="/pass/login", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<User> login(String number, String password) {
		System.out.println(number + password);
		User user = userService.login(number, password);
		if (user != null) {
			return new Result<>(true, user);
		}
		return new Result<>(false, "登录失败");
	}
}
