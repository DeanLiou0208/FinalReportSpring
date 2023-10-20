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

import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;
import tw.ispan.eeit168.forum.service.PetArticleAjaxService;
import tw.ispan.eeit168.forum.service.PetArticlePhotoAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
public class PetArticlePhotoAjaxController {
	@Autowired
	private PetArticlePhotoAjaxService petArticlePhotoAjaxService;
	@Autowired
	private PetArticleAjaxService petArticleAjaxService;
	
	@GetMapping(path = "/petArticlePhoto/byArticleId/{fkPetArticleId}")
	public String findByPetArticleId(@PathVariable(name = "fkPetArticleId")Integer fkPetArticleId) {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<PetArticlePhotoBean> byPetArticleId = petArticlePhotoAjaxService.selectByPetArticleId(fkPetArticleId);
		if(byPetArticleId != null) {
			for(PetArticlePhotoBean petArticlePhoto : byPetArticleId) {
				JSONObject item = new JSONObject()
						.put("id", petArticlePhoto.getId())
						.put("FkPetArticleId",petArticlePhoto.getFkPetArticleId())
						.put("main", petArticlePhoto.getMain())
						.put("img", petArticlePhoto.getImg())
						.put("createAt", petArticlePhoto.getCreateAt());
				array = array.put(item);
				
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	@GetMapping(path = "/petArticlePhoto/byId/{id}")
	public String findById(@PathVariable(name = "id")Integer id) {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		PetArticlePhotoBean petArticlePhoto = petArticlePhotoAjaxService.selectById(id);
		if(petArticlePhoto!=null) {
			JSONObject item = new JSONObject()
					.put("id", petArticlePhoto.getId())
					.put("FkPetArticleId",petArticlePhoto.getFkPetArticleId())
					.put("main", petArticlePhoto.getMain())
					.put("img", petArticlePhoto.getImg())
					.put("createAt", petArticlePhoto.getCreateAt());
			
			array = array.put(item);
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}
	
	@PostMapping(path = "/petArticlePhoto")
	public String create (@RequestBody String body) {
		
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null : obj.getInt("fkPetArticleId");
		if(!petArticleAjaxService.exists(fkPetArticleId)) {
//			System.out.println(fkPetArticleId);
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		}else {
			PetArticlePhotoBean petArticlePhoto = null;
			try {
				petArticlePhoto = petArticlePhotoAjaxService.create(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(petArticlePhoto==null) {
				responseJson.put("message", "新增失敗");
				responseJson.put("success", false);
			}else {
				responseJson.put("message", "新增成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
	@PutMapping(path = "/petArticlePhoto/{id}")
	public String modify (@PathVariable("id")Integer id,@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
	
		if(!petArticlePhotoAjaxService.exists(id)) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		}else {
			PetArticlePhotoBean petArticlePhoto = null;
			try {
				petArticlePhoto = petArticlePhotoAjaxService.modify(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		if(petArticlePhoto==null) {
			responseJson.put("message", "修改失敗");
			responseJson.put("success", false);
		}else {
			responseJson.put("message", "修改成功");
			responseJson.put("success", true);
		}
			
		}
	return responseJson.toString();
	}
	@DeleteMapping(path = "/petArticlePhoto/{id}")
	public String remove(@PathVariable("id")Integer id) {
		JSONObject responseJson = new JSONObject();
		
		if(!petArticlePhotoAjaxService.exists(id)) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
			
		}else {
			if(petArticlePhotoAjaxService.remove(id)) {
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
