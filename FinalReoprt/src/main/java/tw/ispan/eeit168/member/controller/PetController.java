package tw.ispan.eeit168.member.controller;

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

import tw.ispan.eeit168.member.domain.MyPetView;
import tw.ispan.eeit168.member.domain.PetBean;
import tw.ispan.eeit168.member.domain.PetPhotoOrderView;
import tw.ispan.eeit168.member.service.PetService;

@RestController
@RequestMapping(path = "/pages/pet")
@CrossOrigin
public class PetController {
	@Autowired
	private PetService petService;
	
	//新增寵物
	@PostMapping(path = "/newPet")
	public String newPet(@RequestParam("files") MultipartFile[] files, String json) {
		JSONObject responseJson = new JSONObject();
		PetBean pet = null;
		try {
			pet = petService.createPet(json,files);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(pet==null) {
			responseJson.put("message", "新增失敗");
			responseJson.put("success", false);
		} else {
			responseJson.put("message", "新增成功");
			responseJson.put("success", true);
		}
		
		return responseJson.toString();
	}
	//修改寵物
	@PutMapping(path = "/update/{id}")
	public String modify(@PathVariable("id") Integer id, @RequestBody String body) {
		JSONObject responseJson = new JSONObject();

		if(!petService.exists(id)) {
			responseJson.put("message", "查無寵物");
			responseJson.put("success", false);
		} else {
			PetBean pet = null;
			try {
				pet = petService.modify(id,body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(pet==null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
	//刪除寵物
	@DeleteMapping(path = "/delete/{id}")
	public String remove(@PathVariable("id") Integer id) {
		JSONObject responseJson = new JSONObject();
		
		if(!petService.exists(id)) {
			responseJson.put("message", "查無寵物");
			responseJson.put("success", false);
		} else {
			if(petService.remove(id)) {
				responseJson.put("message", "刪除成功");
				responseJson.put("success", true);
			} else {
				responseJson.put("message", "刪除失敗");
				responseJson.put("success", false);
			}
		}
		return responseJson.toString();
	}
	
	
	//找出一隻寵物資訊
	@GetMapping(path="/information/exists")
	public String exist(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		
		JSONObject obj = new JSONObject(json);
		Integer id = obj.isNull("id") ? null : obj.getInt("id");	
		
		MyPetView pet = petService.findById(id);
		if(pet != null) {			
			responseJson.put("id", pet.getPetId());
			responseJson.put("fkMemberId", pet.getFkMemberId());
			responseJson.put("name", pet.getName());
			responseJson.put("species", pet.getSpecies());
			responseJson.put("breed", pet.getBreed());
			responseJson.put("age", pet.getAge());
			responseJson.put("gender", pet.getGender());
		} else {
			responseJson.put("message", "查無寵物");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	//找出某人的寵物
	@PostMapping(path="/information/find")
	public String findMyPet(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		
		JSONObject obj = new JSONObject(json);
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");	
		
		List<MyPetView> result = petService.findMyPet(fkMemberId);		
		
		if(result != null && !result.isEmpty()) {				
			for(MyPetView myPet : result) {
				JSONObject item = new JSONObject()
				.put("petId", myPet.getPetId())
				.put("fkMemberId", myPet.getFkMemberId())
				.put("name", myPet.getName())
				.put("species", myPet.getSpecies())
				.put("breed", myPet.getBreed())
				.put("age", myPet.getAge())
				.put("gender", myPet.getGender());
			
			array = array.put(item);
		}
		responseJson.put("list", array);			
		} else {
			responseJson.put("message", "查無寵物");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	
	//寵物大廳
	@PostMapping(path = "/find")
	public String find(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		
//		long count = petService.count(body);
//		responseJson.put("count", count);
//		
		JSONArray array = new JSONArray();
		List<PetPhotoOrderView> result = petService.find(body);
		if(result!=null && !result.isEmpty()) {
			for(PetPhotoOrderView pet : result) {
//				String make = DatetimeConverter.toString(
//						product.getMake(), "yyyy-MM-dd");
				JSONObject item = new JSONObject()
						.put("id", pet.getId())
						.put("name", pet.getName())
						.put("species", pet.getSpecies())
//						.put("make", make)
						.put("breed", pet.getBreed())
						.put("userName", pet.getUserName())
						.put("likeCount", pet.getLikeCount())
//						.put("createAt", pet.getCreateAt())
						.put("img", pet.getImg());
				
				array = array.put(item);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}	
	
	
	
}
