package tw.ispan.eeit168.shop.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tw.ispan.eeit168.shop.dao.ShoppingCartBeanDao;
import tw.ispan.eeit168.shop.domain.ShoppingCartBean;
import tw.ispan.eeit168.shop.service.ShopCartViewService;
import tw.ispan.eeit168.shop.service.ShoppingCartService;

@RestController
@RequestMapping(path = "/")
@CrossOrigin
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private ShopCartViewService shopCartViewService;
	
	@Autowired
	private ShoppingCartBeanDao shoppingCartBeanDao;

	@PutMapping(path = "/product/addShoppingCart")
	public String addShoppingCart(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

		Integer fkMemberId = null;
		if (jsonObject.has("fkMemberId") && !jsonObject.get("fkMemberId").isJsonNull()) {
			fkMemberId = jsonObject.get("fkMemberId").getAsInt();
		}

		Integer fkProductId = null;
		if (jsonObject.has("fkProductId") && !jsonObject.get("fkProductId").isJsonNull()) {
			fkProductId = jsonObject.get("fkProductId").getAsInt();
		}

		if (fkMemberId == null || !shoppingCartService.memberExists(fkMemberId)) {
			responseJson.put("message", "會員不存在");
			responseJson.put("success", false);
		}

		else if (fkProductId == null || !shoppingCartService.productExists(fkProductId)) {
			responseJson.put("message", "商品不存在");
			responseJson.put("success", false);
		} else {
			ShoppingCartBean addShoppingCart = null;
			try {
				addShoppingCart = shoppingCartService.addShoppingCart(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (addShoppingCart == null) {
				responseJson.put("message", "新增失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "新增成功");
				responseJson.put("success", true);
			}

		}
		return responseJson.toString();
	}// addShoppingCart end
	
	@PutMapping(path ="/member/shoppingcartupdate")
	public String updateShoppingCart(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		
		Integer id = null;
		if (jsonObject.has("id") && !jsonObject.get("id").isJsonNull()) {
			id = jsonObject.get("id").getAsInt();
		}
		
		if (id == null || !shoppingCartService.exists(id)) {
			responseJson.put("message", "購物車不存在");
			responseJson.put("success", false);
		} else {
			ShoppingCartBean updateCart = null;
			try {
				updateCart = shoppingCartService.updateCart(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (updateCart == null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}//updateShoppingCart end
	
	@PostMapping(path ="/member/shoppingCartRemove")
	public String shoppingCartRemove(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		
		JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
		
		Integer id = null;
		if (jsonObject.has("id") && !jsonObject.get("id").isJsonNull()) {
			id = jsonObject.get("id").getAsInt();
		}
		System.out.println(id);
		
		Integer fkMemberId = null;
		if (jsonObject.has("fkMemberId") && !jsonObject.get("fkMemberId").isJsonNull()) {
			fkMemberId = jsonObject.get("fkMemberId").getAsInt();
		}
		
		
		if(id == null || !shoppingCartService.exists(id)) {
			responseJson.put("message", "購物車不存在");
			responseJson.put("success", false);
		} else if(fkMemberId == null ) {
			responseJson.put("message", "請登入會員");
			responseJson.put("success", false);
		}else if(!shoppingCartService.memberExists(fkMemberId)) {
			responseJson.put("message", "查無會員");
			responseJson.put("success", false);
		}else {
			if(shoppingCartService.shoppingCartRemove(json)) {
				responseJson.put("message", "刪除成功");
				responseJson.put("success", true);	
			}else {
				responseJson.put("message", "刪除失敗");
				responseJson.put("success", false);	
			}
		}
		return responseJson.toString();
	}
	
	@PostMapping(path ="/member/shoppingcart")
	public String findMemberCart (@RequestBody String json) {
//		JsonObject responseJson = new JsonObject();
		String findMemberCart = shopCartViewService.findMemberCart(json);
		
		return findMemberCart;
	}
	
	@PostMapping(path = "/member/addshoppingcartmore")
	public boolean addShoppingCartMore(@RequestBody String json) {
		
		boolean checkShoppingCartExits = shoppingCartService.CheckShoppingCartExits(json);
		return checkShoppingCartExits;
	}
	
//	還沒寫完
//	@PostMapping(path = "/member/addshoppingcartplus")
//	public String addshoppingCartPlus(@RequestBody String json) {
//		JSONObject responseJson = new JSONObject();
//		boolean checkShoppingCartExits = shoppingCartService.CheckShoppingCartExits(json);
//		JSONObject obj = new JSONObject(json);
//		
//		Integer fkMemberId = obj.isNull("fkMember") ? null : obj.getInt("fkMember");
//		Integer fkProductId = obj.isNull("fkProductId") ? null : obj.getInt("fkProductId");
//		Integer count = obj.isNull("count") ? null : obj.getInt("count");
//		
//		
//		if (fkMemberId == null || !shoppingCartService.memberExists(fkMemberId)) {
//			responseJson.put("message", "會員不存在");
//			responseJson.put("success", false);
//		}
//
//		else if (fkProductId == null || !shoppingCartService.productExists(fkProductId)) {
//			responseJson.put("message", "商品不存在");
//			responseJson.put("success", false);
//		} else {
//			ShoppingCartBean addShoppingCart = null;
//			try {
//				if(checkShoppingCartExits == false) {
//					addShoppingCart = shoppingCartService.addShoppingCart(json);
//				}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if (addShoppingCart == null) {
//				responseJson.put("message", "新增失敗");
//				responseJson.put("success", false);
//			} else {
//				responseJson.put("message", "新增成功");
//				responseJson.put("success", true);
//			}
//
//		}
//		return responseJson.toString();
//		
//	}
	
}
