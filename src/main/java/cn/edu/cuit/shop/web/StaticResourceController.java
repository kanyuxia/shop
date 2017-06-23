package cn.edu.cuit.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticResourceController {
	
	@RequestMapping("/cart")
	public String Cart() {
		return "front/shopcart";
	}
	
	@RequestMapping("/index")
	public String getIndex(){
		return "front/index";
	}
	
	@RequestMapping("/item/{goodsID}")
	public String simpleProduct() {
		return "front/item";
	}
	
	@RequestMapping("/cat/{catID}")
	public String category() {
		return "front/category";
	}
	
}
