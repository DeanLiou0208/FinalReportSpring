package tw.ispan.eeit168.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tw.ispan.eeit168.shop.domain.ShoppingCartBean;
import tw.ispan.eeit168.shop.service.ShoppingCartService;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PutMapping(path = "/product/addShoppingCart")
	public String addShoppingCart(@RequestBody String json) {
		
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		int fkMemberId = jsonObject.get("fkMemberId").getAsInt();
		int fkProductId = jsonObject.get("fkProductId").getAsInt();
		
		
		ShoppingCartBean addShoppingCart = shoppingCartService.addShoppingCart(json);
		String result = new Gson().toJson(addShoppingCart);
		return result;
	}
	
}
