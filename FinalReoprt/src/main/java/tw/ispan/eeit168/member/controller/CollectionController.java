package tw.ispan.eeit168.member.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.member.domain.CollectionBean;
import tw.ispan.eeit168.member.domain.CollectionPetArticleView;
import tw.ispan.eeit168.member.domain.CollectionProductView;
import tw.ispan.eeit168.member.service.CollectionService;

@RestController
@RequestMapping(path = "/pages/collection")
@CrossOrigin
public class CollectionController {
	@Autowired
	private CollectionService collectionService;
	
//	顯示收藏
	@PostMapping(path = "/find")
	public String find(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(json);

		JSONArray articleArray = new JSONArray();
		JSONArray productArray = new JSONArray();
		
		//找出文章跟產品
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		List<CollectionPetArticleView> articleResult = collectionService.findCollectArticle(fkMemberId);
		List<CollectionProductView> productResult = collectionService.findCollectProduct(fkMemberId);

		//放入JSON
		if(articleResult!=null && !articleResult.isEmpty()) {
			for(CollectionPetArticleView article : articleResult) {
				JSONObject item = new JSONObject()
						.put("fkMemberId", article.getArticleId())
						.put("name", article.getTitle());
				
				articleArray = articleArray.put(item);
			}
		}
		if(productResult!=null && !productResult.isEmpty()) {
			for(CollectionProductView product : productResult) {
				JSONObject item = new JSONObject()
						.put("fkMemberId", product.getProductId())
						.put("name", product.getName());
				
				productArray = productArray.put(item);
			}
		}
		responseJson.put("articleList", articleArray);
		responseJson.put("productList", productArray);
		return responseJson.toString();
	}
		
//	新增收藏
	@PostMapping(path = "/create")
	public String create(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();

		JSONObject obj = new JSONObject(body);
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		String fk_Uid = obj.isNull("fk_Uid") ? null : obj.getString("fk_Uid");
		
		if(collectionService.exists(fkMemberId,fk_Uid) != null) {
			responseJson.put("message", "資料已存在");
			responseJson.put("success", false);
		} else {
			CollectionBean collection = null;
			try {
				collection = collectionService.createCollect(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(collection == null) {
				responseJson.put("message", "收藏失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "收藏成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
	
//	取消收藏
	@DeleteMapping(path = "/delete")
	public String remove(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		
		JSONObject obj = new JSONObject(body);
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		String fk_Uid = obj.isNull("fk_Uid") ? null : obj.getString("fk_Uid");		
		
		if(collectionService.exists(fkMemberId,fk_Uid) == null) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		} else {
			Boolean result = null;
			try {
				result = collectionService.removeCollect(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(result == true) {
				responseJson.put("message", "取消成功");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "取消失敗");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
	
	
}
