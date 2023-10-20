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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;
import tw.ispan.eeit168.forum.domain.SpeciesViewsView;
import tw.ispan.eeit168.forum.service.PetArticleAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
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
	@GetMapping(path = "/findByPetArticleId/{id}")
	public String findById(@PathVariable("id") Integer id) {
		JSONObject responseJson = new JSONObject();
		
			PetArticleBean petArticleBean = petArticleAjaxService.findById(id);
			if(petArticleBean!=null) {
//			取出所有寵物物種資料
			JSONArray speciesArray = new JSONArray();
			List<SpeciesViewsView> petArticleSpecies = petArticleAjaxService.findPetArticleSpecies(id);
			if(petArticleSpecies != null && !petArticleSpecies.isEmpty()) {
				for(SpeciesViewsView item : petArticleSpecies) {
					JSONObject species = new JSONObject()
							.put("speciesId",item.getFkPetArticleSpeciesId());
					
					speciesArray = speciesArray.put(species);
					
				}
			}
			List<PetArticlePhotoBean> myPetArticlePhotos = petArticleAjaxService.findMyPetArticlePhoto(id);
			JSONArray arrayPhotos = new JSONArray();
//			JSONObject firstPhoto = new JSONObject();
			if(myPetArticlePhotos!=null && !myPetArticlePhotos.isEmpty()) {
				for(PetArticlePhotoBean myPetArticlePhoto: myPetArticlePhotos) {
					JSONObject photo = new JSONObject()
//							.put("main", myPetArticlePhoto.getMain())
							.put("img", myPetArticlePhoto.getImg());
//					if(myPetArticlePhoto.getMain()!=null) {
//						firstPhoto = photo;
//					}else {
						arrayPhotos = arrayPhotos.put(photo);
//					}
				}
			}
			responseJson.put("id", petArticleBean.getId());
			responseJson.put("type", petArticleBean.getType());
			responseJson.put("title", petArticleBean.getTitle());
			responseJson.put("petArticleText", petArticleBean.getPetArticleText());
//			responseJson.put("createAt", arrayPhotos);
			responseJson.put("speciesId",speciesArray);
			
		}else {
				responseJson.put("message", "查無寵物文章");
				responseJson.put("success", false);
			}
			return responseJson.toString();
	}
	
	
	@PostMapping(path = "/petArticle")
	public String findByMemberId(@RequestBody String body) {
	    JSONObject responseJson = new JSONObject();
	    JSONObject obj = new JSONObject(body);
	    Integer memberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
	    JSONArray array = new JSONArray();
//	    System.out.println("memberId:"+memberId);
	    List<PetArticleBean> byMemberId = petArticleAjaxService.findByMemberId(memberId);
	    
	    if (byMemberId != null) {
	        for (PetArticleBean bean : byMemberId) {
	            String firstPhoto = null;
	            List<PetArticlePhotoBean> myPetArticlePhotos = petArticleAjaxService.findMyPetArticlePhoto(bean.getId());
	            if (myPetArticlePhotos != null && !myPetArticlePhotos.isEmpty()) {
	            	PetArticlePhotoBean firstPhotoBean = myPetArticlePhotos.get(0); // 取得第一張照片
	                firstPhoto = firstPhotoBean.getImg();
	            }          
	            JSONObject item = new JSONObject()
	                    .put("id", bean.getId())
	                    .put("memberId", bean.getFkMemberId())
	                    .put("type", bean.getType())
	                    .put("title", bean.getTitle())
	                    .put("petArticleText", bean.getPetArticleText())
	                    .put("createAt", bean.getCreateAt())
	                    .put("main", firstPhoto);
	            array = array.put(item);
	        }
	    }
	    responseJson.put("list", array);
//	    System.out.println(array);
	    return responseJson.toString();
	}
	

	@GetMapping(path = "/petArticleByTime")
	public String findByTime() {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<PetArticleBean> orderByTime = petArticleAjaxService.orderByTime();
//		System.out.println(orderByTime);
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
//			System.out.println(false);
			responseJson.put("message", "新增失敗");
			responseJson.put("success", false);
		}else {
			
			responseJson.put("message", "新增成功");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	@PutMapping(path = "/petArticleModify")
	public String modify (@RequestParam(value = "files",required = false) MultipartFile[] files, String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null: obj.getInt("id");
//		System.out.println(id);
		if(!petArticleAjaxService.exists(id)) {
			responseJson.put("message", "寵物文章不存在");
			responseJson.put("success", false);
		}else {
			PetArticleBean petArticleBean = null;
			try {
				petArticleBean = petArticleAjaxService.modify(body,files);
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
	@DeleteMapping(path = "/petArticleRemove/{id}")
	public String remove (@PathVariable("id") Integer id) {
		JSONObject responseJson = new JSONObject();
		
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
