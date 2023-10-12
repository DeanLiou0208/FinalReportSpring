package tw.ispan.eeit168.company.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductDetailsRateView;
import tw.ispan.eeit168.company.domain.ProductDetailsView;

import tw.ispan.eeit168.company.domain.ProductPhotoBean;
import tw.ispan.eeit168.company.service.ProductService;

@RestController
@RequestMapping(path = "/pet_web")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productservice;

	@PostMapping(path = "/product/insert")
	public String selectProduct(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer fkCompanyId = obj.isNull("fkCompanyId") ? null : obj.getInt("fkCompanyId");
		String name = obj.isNull("name") ? null : obj.getString("name");
		String size=obj.isNull("size")? "無" :obj.getString("size");

		
		
		if (fkCompanyId != null) {
	
			ProductBean productBean = null;
			ProductBean product = null;
			
			if (productservice.existsProductType(name,size)) {
	
				productBean = productservice.existsProductNameAndType(fkCompanyId, name,size);

				if (productBean != null) {
					responseJson.put("message", "商品已存在,編號: " + productBean.getId() + ",uid: " + productBean.getUid());
					responseJson.put("success", false);

				} else {
					try {
			
						product = productservice.create(body);

					} catch (Exception e) {
						e.printStackTrace();
					}
					if (product == null) {
						responseJson.put("message", "新增失敗");
						responseJson.put("success", false);
					} else {
						responseJson.put("message", "新增成功");
						responseJson.put("success", true);
					}
				}

			} else {
				try {
		
					product = productservice.create(body);

				} catch (Exception e) {
					e.printStackTrace();
				}
				if (product == null) {
					responseJson.put("message", "新增失敗");
					responseJson.put("success", false);
				} else {
					responseJson.put("message", "新增成功");
					responseJson.put("success", true);
				}
			}
		} else {
			responseJson.put("message", "資料不正確");
			responseJson.put("success", false);
		}

		return responseJson.toString();
	}

	@PutMapping(path = "/product/update")
	public String modify(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);

		Integer id = obj.isNull("id") ? null : obj.getInt("id");
		Integer fkCompanyId = obj.isNull("fkCompanyId") ? null : obj.getInt("fkCompanyId");
		String name = obj.isNull("name") ? null : obj.getString("name");
		String size = obj.isNull("size") ? null : obj.getString("size");
		ProductBean productBean = null;
		
		if (productservice.idExists(id) == null) {
			responseJson.put("message", "查無此商品");
			responseJson.put("success", false);
			
		} else if (productservice.existsForUpdate(id,fkCompanyId, name,size) != null) {
			productBean = productservice.existsForUpdate(id,fkCompanyId, name,size);
			
			responseJson.put("message", "商品資料匹配不正確" );
			responseJson.put("success", false);

		} else {
			ProductBean product = null;

			try {
				product = productservice.modify(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (product == null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}

	@GetMapping(path = "/product-detail")
	public ProductDetailsView productdetail(@RequestParam(name = "productId") Integer productId) {

		ProductDetailsView product = null;

		if (productId != null) {

			product = productservice.findProduct(productId);
			if (product != null) {
				return product;
			} else {
				return null;
			}
		}
		return null;
	}

//	@GetMapping(path = "/product-detail-rate")
//	public List<ProductDetailsRateView> productDetailRate(@RequestParam(name = "productId") Integer productId) {
//
//		List<ProductDetailsRateView> product = null;
//
//		if (productId != null) {
//
//			product = productservice.findProductRate(productId);
//
//			if (product != null) {
//
//				return product;
//			} else {
//				return null;
//			}
//		}
//		return null;
//	}

	
	@PostMapping(path = "/product-photo")
	public String productPhoto(@RequestBody String json) {
		
		JSONObject obj = new JSONObject(json);
		Integer fkProductId = obj.isNull("fkProductId") ? null: obj.getInt("fkProductId");
		JSONObject responesJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject main = new JSONObject();
		if(fkProductId != null) {
		List<ProductPhotoBean> find = productservice.findProductPhoto(fkProductId);
			if(find != null && !find.isEmpty()) {
				for(ProductPhotoBean productPhoto : find) {
					JSONObject item = new JSONObject()
							.put("id", productPhoto.getId())
							.put("fkProductId", productPhoto.getFkProductId())
							.put("main", productPhoto.getMain())
							.put("img", productPhoto.getImg());
							if(productPhoto.getMain() != null ) {
								main =item;
							}else {
							jsonArray = jsonArray.put(item)	;
							}
				}
			}
		
		}
		responesJson.put("mainPhoto", main);
		responesJson.put("photoList", jsonArray);
		return responesJson.toString();
	}
	
	@PostMapping(path = "/productshow/info")
	public String productfind(@RequestBody String srt) {
		
		JSONObject obj = new JSONObject(srt);
		Integer id = obj.isNull("productId") ? null : obj.getInt("productId");
		
		if(id != null) {
		ProductDetailsView findProduct = productservice.findProduct(id);
		String json = new Gson().toJson(findProduct);
		
		return json;
		}
		return null;
	}
	@PostMapping(path = "/productshowrate/info")
	public String productRatefind(@RequestBody String json) {
		
		JSONObject responesJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		List<ProductDetailsRateView> find = productservice.findProductRate(json);
		if(find != null && !find.isEmpty()) {
			for(ProductDetailsRateView productRate : find) {
				JSONObject item = new JSONObject()
						.put("id", productRate.getId())
						.put("userName",productRate.getUserName())
						.put("fkProductId", productRate.getFkProductId())
						.put("rateScore", productRate.getRateScore())
						.put("rateComment", productRate.getRateComment());
				jsonArray = jsonArray.put(item);
			}
		}
		responesJson.put("list", jsonArray);
		return responesJson.toString();
	}

}