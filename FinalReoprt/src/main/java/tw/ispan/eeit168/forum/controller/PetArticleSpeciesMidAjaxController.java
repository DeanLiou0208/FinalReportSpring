package tw.ispan.eeit168.forum.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.forum.domain.PetArticleSpeciesMidBean;
import tw.ispan.eeit168.forum.service.PetArticleSpeciesMidAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
public class PetArticleSpeciesMidAjaxController {
	@Autowired
	private PetArticleSpeciesMidAjaxService petArticleSpeciesMidAjaxService;
	
	@GetMapping(path = "/petArticleSpeciesMid/{fkPetArticleId}")
	public String findByPetArticleId(@PathVariable(name = "fkPetArticleId") Integer fkPetArticleId) {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<PetArticleSpeciesMidBean> byPetArticleId = petArticleSpeciesMidAjaxService.findByPetArticleId(fkPetArticleId);
		if(byPetArticleId!= null) {
			for(PetArticleSpeciesMidBean petArticleSpeies : byPetArticleId) {
				JSONObject item = new JSONObject()
						.put("id", petArticleSpeies.getId())
						.put("fkPetArticleId", petArticleSpeies.getFkPetArticleId())
						.put("fkPetArticleSpeciesId", petArticleSpeies.getFkPetArticleSpeciesId());
				
				array = array.put(item);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	@PostMapping(path = "/petArticleSpeciesMid")
	public String create(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
//		 JSONObject obj = new JSONObject();
//		 Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null : obj.getInt("fkPetArticleId");
//		 Integer fkPetArticleSpeciesId = obj.isNull("fkPetArticleSpeciesId") ? null : obj.getInt("fkPetArticleSpeciesId");
		 
		 PetArticleSpeciesMidBean petArticleSpeciesMid = null;
				 try {
					petArticleSpeciesMid = petArticleSpeciesMidAjaxService.create(body);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				 if(petArticleSpeciesMid==null) {
					 responseJson.put("message", "新增失敗");
					 responseJson.put("success", false);
				 }else {
					 responseJson.put("message", "新增成功");
					 responseJson.put("success", true);
				 }
				 return responseJson.toString();
		 }
	@PutMapping("/petArticleSpeciesMid/{fkPetArticleId}")
	public String modify (@PathVariable("fkPetArticleId")Integer fkPetArticleId , @RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		if(petArticleSpeciesMidAjaxService.existsByPetArticleId(fkPetArticleId)) {
			Boolean petArticleSpeciesMid = null;
			try {
				petArticleSpeciesMid = petArticleSpeciesMidAjaxService.modify(body);
				System.out.println(petArticleSpeciesMid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(!petArticleSpeciesMid) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			}else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
				
	}
	@DeleteMapping(path = "/petArticleSpeciesMid/{id}")
	public String remove(@PathVariable("id") Integer id) {
		JSONObject responseJson = new JSONObject();
		if(!petArticleSpeciesMidAjaxService.exists(id)) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		}else {
			if(petArticleSpeciesMidAjaxService.remove(id)){
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
