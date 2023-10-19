package tw.ispan.eeit168.shop.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import tw.ispan.eeit168.shop.dao.ProductAnalysisViewDao;
import tw.ispan.eeit168.shop.domain.ProductAnalysisView;

@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class ProductAnalysisController {

	@Autowired
	private ProductAnalysisViewDao productAnalysisViewDao;
	
	@PostMapping(path = "/shopproductanalysis")
	public String productAnalysis(@RequestBody String json) {
		
		JSONObject obj = new JSONObject(json);
		String shopName = obj.isNull("shopName") ? null : obj.getString("shopName");
		
		if(shopName != null && shopName.length() != 0) {
			List<ProductAnalysisView> selectByShopName = productAnalysisViewDao.selectByShopName(shopName);
			String returnJson = new Gson().toJson(selectByShopName);
			return returnJson;
		}
		
		return  null;
	}
	
	@PostMapping(path = "/shopproductanalysisproduct")
	public String selectByShopNameProductCount(@RequestBody String json) {
		
		JSONObject obj = new JSONObject(json);
		String shopName = obj.isNull("shopName") ? null : obj.getString("shopName");
		
		if(shopName != null && shopName.length() != 0) {
			List<ProductAnalysisView> selectByShopName = productAnalysisViewDao.selectByShopName(shopName);
			String returnJson = new Gson().toJson(selectByShopName);
			return returnJson;
		}
		
		return null;
	}
}
