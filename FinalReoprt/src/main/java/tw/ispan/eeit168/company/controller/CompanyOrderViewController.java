package tw.ispan.eeit168.company.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tw.ispan.eeit168.company.domain.CompanyOrderView;
import tw.ispan.eeit168.company.service.CompanyOrderViewService;
import tw.ispan.eeit168.shop.domain.OrderDetailsBean;
@RestController
@RequestMapping(path = "/pet_web")
@CrossOrigin
public class CompanyOrderViewController {
	@Autowired
	private CompanyOrderViewService companyOrderService;
	
	
	@PostMapping(path="/companys/orders")
	public List<CompanyOrderView> selectCompanyOrder(@RequestBody String body) {	
		
		JSONObject obj = new JSONObject(body);
		String shopName = obj.isNull("shopName") ? null : obj.getString("shopName");
		
		
		return companyOrderService.existsShopName(shopName);
	}
	@PostMapping(path="/companys/ordersupdate")
	public String modify(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		if(obj.isEmpty()||obj.isNull("id")) {
			responseJson.put("message", "修改失敗");
			responseJson.put("success", false);
		}else {
			OrderDetailsBean odb = null;
			try {
				odb = companyOrderService.modify(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (odb == null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
}
