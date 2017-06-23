package cn.edu.cuit.shop.web;

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
import cn.edu.cuit.shop.entity.User;
import cn.edu.cuit.shop.service.UserService;

/**
 * 该Controller是有关用户账户信息的Controller
 * @author kanyuxia
 *
 */
@Controller
public class UserAccountController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 注册用户
	 * @param user 用户信息
	 * @return
	 */
	@RequestMapping(value="/pass/register", method=RequestMethod.POST, 
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Object> register(@RequestParam() User user, HttpServletRequest request){
		System.out.println(user);
		boolean successed = userService.register(user.getNumber(), user.getPassword(), 
				user.getNickname(), user.getSex());
		if (successed) {
			User user1 = userService.login(user.getNickname(), user.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("user", user1);
			return new Result<Object>(true, null);
		}
		return new Result<Object>(false, "注册失败");
	}
	
	
	/**
	 * 获取用户信息
	 * @param number
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/pass/getUser", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<User> login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return new Result<User>(true, user);
	}
	/**
	 * 用户登录
	 * @param number
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/pass/login", method=RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<User> login(@RequestParam(required=true)String number, 
			@RequestParam(required=true)String password, HttpServletRequest request) {
		System.out.println(number + password);
		User user = userService.login(number, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return new Result<User>(true, user);
		}
		return new Result<User>(false, "登录失败");
	}
	
	/**
	 * 修改密码
	 * @param number 用户名
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return
	 */
	@RequestMapping(value="/pass/modifyPassword", method=RequestMethod.GET,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Result<Object> modifyPassword(String number, String oldPassword, String newPassword) {
		System.out.println(number + oldPassword + newPassword);
		boolean successed = userService.modifyPassword(number, oldPassword, newPassword);
		if (successed) {
			return new Result<Object>(true, null);
		}
		return new Result<Object>(false, "修改失败");
	}
	
	@RequestMapping(value="/pass/modifyUser", method=RequestMethod.GET,
			produces={"application/json;chart=UTF-8"})
	@ResponseBody
	public Result<Object> modifyUser(User user) {
		System.out.println(user);
		boolean successed = userService.modifyUser(user);
		if (successed) {
			return new Result<Object>(true,null);
		}
		return new Result<Object>(false, "修改失败");
	}
}
