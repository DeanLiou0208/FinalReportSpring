package tw.ispan.eeit168.forum.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.service.PetArticleAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
public class PetArticleAjaxController {
	@Autowired
	private PetArticleAjaxService petArticleAjaxService;
	@GetMapping(path = "/petArticleAll")
	public String findAll() {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<PetArticleBean> findAll = petArticleAjaxService.findAll();
		for(PetArticleBean bean : findAll) {
			JSONObject item = new JSONObject()
					.put("memberId", bean.getFkMemberId())
					.put("img", bean.getUid())
					.put("type", bean.getType())
					.put("title", bean.getTitle())
					.put("petArticleText", bean.getPetArticleText())
					.put("createAt", bean.getCreateAt());
			
			array = array.put(item);
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	
	
	@GetMapping(path = "/petArticle")
	public String findByMemberId(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer memberId = obj.isNull("memberId") ? null : obj.getInt("memberId");
		JSONArray array = new JSONArray();
				
		List<PetArticleBean> byMemberId = petArticleAjaxService.findByMemberId(memberId);
		
		if(byMemberId!=null) {
			for(PetArticleBean bean : byMemberId) {
				JSONObject item = new JSONObject()
						.put("memberId", bean.getFkMemberId())
						.put("img", bean.getUid())
						.put("type", bean.getType())
						.put("title", bean.getTitle())
						.put("petArticleText", bean.getPetArticleText())
						.put("createAt", bean.getCreateAt());
						
						array = array.put(item);		
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	@GetMapping(path = "/petArticleByTime")
	public String findByTime() {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<PetArticleBean> orderByTime = petArticleAjaxService.orderByTime();
		System.out.println(orderByTime);
		if(orderByTime!=null) {
	    	for(PetArticleBean bean : orderByTime) {
	    		JSONObject item = new JSONObject()
	    				.put("memberId", bean.getFkMemberId())
						.put("img", bean.getUid())
						.put("type", bean.getType())
						.put("title", bean.getTitle())
						.put("petArticleText", bean.getPetArticleText())
						.put("createAt", bean.getCreateAt());
	    		array = array.put(item);
	    	}
	    }
	    responseJson.put("list", array);
		return responseJson.toString();
	}
	@PostMapping(path = "petArticleCreate")
	public String create (@RequestParam(value = "files",required = false) MultipartFile[] files, String body) {
		JSONObject responseJson = new JSONObject();
		PetArticleBean petArticleBean = null;
		try {
			petArticleBean = petArticleAjaxService.create(body,files);
		} catch (Exception e) {
			e.printStackTrace();
		}if(petArticleBean==null) {
			System.out.println(false);
			responseJson.put("message", "新增失敗");
			responseJson.put("success", false);
		}else {
			
			responseJson.put("message", "新增成功");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	@PutMapping(path = "/petArticleModify")
	public String modify (@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null: obj.getInt("id");
		System.out.println(id);
		if(!petArticleAjaxService.exists(id)) {
			responseJson.put("message", "寵物文章不存在");
			responseJson.put("success", false);
		}else {
			PetArticleBean petArticleBean = null;
			try {
				petArticleBean = petArticleAjaxService.modify(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(petArticleBean==null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			}else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
	@DeleteMapping(path = "/petArticleRemove")
	public String remove (@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null: obj.getInt("id");
		if(!petArticleAjaxService.exists(id)) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		}else {
			if(petArticleAjaxService.remove(id)) {
				 responseJson.put("message", "刪除成功");
				 responseJson.put("success", true);
			}else {
				responseJson.put("message", "刪除失敗");
				responseJson.put("success", false);
			}
		}
		return responseJson.toString();
	}
}
