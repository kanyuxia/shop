package cn.edu.cuit.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticResourceController {
	
	
	
	@RequestMapping("/aboutUs")
	public String getAboutUs() {
		return "front/about_us";
	}
	
	@RequestMapping("/cart")
	public String Cart() {
		return "front/cart";
	}
	
	@RequestMapping("/checkout")
	public String getCheckout() {
		return "front/checkout";
	}
	
	@RequestMapping("/contactUs")
	public String getContactUs() {
		return "front/contact_us";
	}
	
	@RequestMapping("/index")
	public String getIndex(){
		return "front/index";
	}
	
	@RequestMapping("/myAccount")
	public String getMyAccount() {
		return "front/my_account";
	}
	
	@RequestMapping("/shop")
	public String getShop() {
		return "front/shop";
	}
	
	@RequestMapping("/simpleProduct")
	public String simpleProduct() {
		return "front/simple_product";
	}
	
	
}
