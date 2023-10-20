package tw.ispan.eeit168.forum.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.forum.domain.PetArticleOrderView;
import tw.ispan.eeit168.forum.service.PetArticleOrderViewAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
public class PetArticleOrderViewAjaxController {
	@Autowired
	private PetArticleOrderViewAjaxService petArticleOrderViewAjaxService;
	@GetMapping(path = "/PetArticleOrderView")
	public String findAll() {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<PetArticleOrderView> list = petArticleOrderViewAjaxService.findAll();
		if(list!=null) {
			for(PetArticleOrderView petArticle : list) {
//				判斷按讚數是否為空值
				Integer likeCount = petArticle.getLikeCount();
				if(likeCount == null) {
					likeCount = 0;
				}
				Integer unlikeCount = petArticle.getUnLikeCount();;
				if(unlikeCount == null) {
					unlikeCount = 0;
				}
				JSONObject item = new JSONObject()
						.put("id", petArticle.getId())
						.put("fkMemberId", petArticle.getFkMemberId())
						.put("title", petArticle.getTitle())
						.put("type", petArticle.getType())
						.put("petArticleText", petArticle.getPetArticleText())
						.put("likeCount", likeCount)
						.put("unLikeCount", unlikeCount)
						.put("lastTime", petArticle.getCreateAt())
						.put("img", petArticle.getImg())
						.put("mian",petArticle.getMain());
				array = array.put(item);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	@PostMapping(path = "/PetArticleOrderView/find")
	public String find(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		long count = petArticleOrderViewAjaxService.count(body);
		responseJson.put("count", count);
		JSONArray array = new JSONArray();
		List<PetArticleOrderView> find = petArticleOrderViewAjaxService.find(body);
		
		if(find!=null && !find.isEmpty()) {
			for(PetArticleOrderView petArticle :find) {
//			判斷按讚數是否為空值
				Integer likeCount = petArticle.getLikeCount();
				if(likeCount == null) {
					likeCount = 0;
				}
				Integer unlikeCount = petArticle.getUnLikeCount();;
				if(unlikeCount == null) {
					unlikeCount = 0;
				}
				JSONObject item = new JSONObject()
						.put("id", petArticle.getId())
						.put("fkMemberId", petArticle.getFkMemberId())
						.put("title", petArticle.getTitle())
						.put("type", petArticle.getType())
						.put("petArticleText", petArticle.getPetArticleText())
						.put("likeCount", likeCount)
						.put("unLikeCount", unlikeCount)
						.put("lastTime", petArticle.getCreateAt())
						.put("img", petArticle.getImg())
						.put("mian",petArticle.getMain());
				array = array.put(item);
//				System.out.println("array="+array);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	@PostMapping(path = "/PetArticleOrderView/findMemberId")
	public String findByMemberId(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<PetArticleOrderView> byMemberId = petArticleOrderViewAjaxService.findByMemberId(body);
		if(byMemberId!=null && !byMemberId.isEmpty()) {
			for(PetArticleOrderView bean : byMemberId) {
				JSONObject item = new JSONObject()
						.put("id", bean.getId())
						.put("fkMemberId", bean.getFkMemberId())
						.put("title", bean.getTitle())
						.put("type", bean.getType())
						.put("petArticleText", bean.getPetArticleText())
						.put("likeCount", bean.getLikeCount())
						.put("unLikeCount", bean.getUnLikeCount())
						.put("lastTime", bean.getCreateAt())
						.put("img", bean.getImg())
						.put("mian",bean.getMain());
							
				array = array.put(item);	
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
}
