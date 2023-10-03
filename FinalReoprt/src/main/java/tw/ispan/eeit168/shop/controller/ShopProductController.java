package tw.ispan.eeit168.shop.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import jakarta.servlet.ServletContext;
import tw.ispan.eeit168.shop.domain.ShopProductView;
import tw.ispan.eeit168.shop.service.ShopProductService;

@RestController
@RequestMapping(path = "/shop")
@CrossOrigin
public class ShopProductController {

	@Autowired
	private ShopProductService shopProductService;

	@Autowired
	private ServletContext servletContext;
	

	@PostMapping(path = "/product/sreach")
	public String find(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		long count = shopProductService.count(json);
		responseJson.put("count", count);

		JSONArray array = new JSONArray();
		List<ShopProductView> find = shopProductService.find(json);
		if (find != null && !find.isEmpty()) {
			for (ShopProductView product : find) {
				JSONObject item = new JSONObject()
				.put("productId", product.getProductId())
				.put("id", product.getId())
				.put("name", product.getName())
				.put("price", product.getPrice())
				.put("img", product.getImg())
				.put("description", product.getDescription())
				.put("companyShopName", product.getCompanyShopName())
				.put("memberShopName", product.getMemberShopName())
				.put("avgRateScore", product.getAvgRateScore());
				
				array = array.put(item);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	@GetMapping(path = "/product")
	public String  findAll() {
		String findAll = shopProductService.findAll();
		return findAll;
	}
}
