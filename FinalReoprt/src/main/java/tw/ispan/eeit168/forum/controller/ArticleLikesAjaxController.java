package tw.ispan.eeit168.forum.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.forum.domain.ArticleLikesBean;
import tw.ispan.eeit168.forum.service.ArticleLikesAjaxService;
import tw.ispan.eeit168.shop.util.DoublePrimaryKey;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
@Transactional
public class ArticleLikesAjaxController {
	@Autowired
	private ArticleLikesAjaxService articleLikesAjaxService;
	
	@GetMapping(path = "/articleLikes/byMemberId")
	public String findByMemberId(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		JSONArray array = new JSONArray();
		List<ArticleLikesBean> byMemberId = articleLikesAjaxService.findByMemberId(fkMemberId);
		if(byMemberId!=null) {
			for(ArticleLikesBean bean : byMemberId) {
				JSONObject item = new JSONObject()
						.put("fkMemberId", bean.getFkMemberId())
						.put("fkPetArticleId", bean.getFkPetArticleId())
						.put("creatAt", bean.getCreateAt())
						.put("likeOrUnlike", bean.getLikeOrUnlike());
				
			array =	array.put(item);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	

	@GetMapping(path = "/articleLikes/byArticleId")
	public String findByArticleId(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null : obj.getInt("fkPetArticleId");
		JSONArray array = new JSONArray();
		List<ArticleLikesBean> byArticleId = articleLikesAjaxService.findByFkPetArticleId(fkPetArticleId);
		if(byArticleId!=null) {
			for(ArticleLikesBean bean : byArticleId) {
				JSONObject item = new JSONObject()
						.put("fkMemberId", bean.getFkMemberId())
						.put("fkPetArticleId", bean.getFkPetArticleId())
						.put("creatAt", bean.getCreateAt())
						.put("likeOrUnlike", bean.getLikeOrUnlike());
				
			array =	array.put(item);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	@PostMapping(path = "/articleLikesCreate")
	public String create (@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		ArticleLikesBean articleLikesBean = null;
		try {
			articleLikesBean = articleLikesAjaxService.createLike(body);
//			System.out.println("2="+articleLikesBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(articleLikesBean==null) {
			responseJson.put("message", "新增失敗");
			responseJson.put("success", false);
		}else {
			responseJson.put("message", "新增成功");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	@PutMapping(path = "/articleLikesModify")
	public String modifyLike(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		ArticleLikesBean articleLikesBean = null;
		try {
			articleLikesBean = articleLikesAjaxService.modifyLike(body);
//			System.out.println("2="+articleLikesBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(articleLikesBean==null) {
			responseJson.put("message", "新增失敗");
			responseJson.put("success", false);
		}else {
			responseJson.put("message", "新增成功");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
		
	
	@DeleteMapping(path = "/articleLikesRemove/{id}")
	public String remove (@PathVariable("id") Integer id) {
		JSONObject responseJson = new JSONObject();
//		System.out.println(id);
		
		try {			
			if(articleLikesAjaxService.remove(id)){
//				System.out.println("1");
				responseJson.put("message", "刪除成功");
				responseJson.put("success", true);
			}else {
				responseJson.put("message", "刪除失敗");
				responseJson.put("success", false);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return responseJson.toString();
	}
	@DeleteMapping(path = "/dislike/{fkMemberId}/{petArticleId}")
	public String dislike(@PathVariable Integer fkMemberId,@PathVariable Integer petArticleId) {
		JSONObject responseJson = new JSONObject();
		System.out.println(fkMemberId);
		System.out.println(petArticleId);
		boolean result = false;
		try {
			result = articleLikesAjaxService.removeLike(fkMemberId, petArticleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result) {
			responseJson.put("message", "已取消愛心");
			responseJson.put("success", true);
		} else {
			responseJson.put("message", "取消失敗");
			responseJson.put("success", false);
		}
		return responseJson.toString();
	}
}
