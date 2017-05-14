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
	private UserService UserService;
	
	@RequestMapping(value="/pass/register", method=RequestMethod.GET, 
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Object> register(User user){
		System.out.println(user);
		boolean successed = UserService.register(user.getNumber(), user.getPassword(), 
				user.getNickname(), user.getSex());
		if (successed) {
			return new Result<Object>(true, null);
		}
		return new Result<Object>(false, "注册失败");
	}
}
