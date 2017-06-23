package cn.edu.cuit.shop.web.back.spgl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cuit.shop.service.ProductsService;
import sun.net.www.content.text.plain;

@Controller
public class AddProducts {
	
	@Autowired
	private ProductsService productService;
	
	@RequestMapping(value = "/addProducts", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public boolean addProduce(String name, String attributes, int categoryID) {
		System.out.println(name);
		System.out.println(attributes);
		System.out.println(categoryID);
		return productService.addProduct(name, attributes, 10000);
	}
}
