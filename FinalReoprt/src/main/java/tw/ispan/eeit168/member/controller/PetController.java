package tw.ispan.eeit168.member.controller;

import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.member.domain.MyPetView;
import tw.ispan.eeit168.member.domain.PetBean;
import tw.ispan.eeit168.member.domain.PetPhotoBean;
import tw.ispan.eeit168.member.domain.PetPhotoOrderView;
import tw.ispan.eeit168.member.service.PetService;
import tw.ispan.eeit168.member.util.DatetimeConverter;

@RestController
@RequestMapping(path = "/pages/pet")
@CrossOrigin
public class PetController {
	@Autowired
	private PetService petService;
	
	//新增寵物
	@PostMapping(path = "/newPet")
	public String newPet(@RequestParam("files") MultipartFile[] files, String body) {
		JSONObject responseJson = new JSONObject();
		PetBean pet = null;
		try {
			pet = petService.createPet(body,files);
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
	
	//修改寵物  之後修改  等前端確認
	@PutMapping(path = "/updatePet")
	public String modify(@RequestParam("files") MultipartFile[] files, String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null : obj.getInt("id");	

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
	
	//刪除寵物  看要不要改 可能改成刪除單一隻
	@DeleteMapping(path = "/delete")
	public String remove(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		
		JSONObject obj = new JSONObject(body);
		String petsId = obj.isNull("petsId") ? null : obj.getString("petsId");	
		if(petsId != null && petsId.length() != 0) {		
			String[] string = petsId.split("-");
			Integer[] arrayId = new Integer[string.length];
			for (int i = 0; i < string.length; i++) {
				arrayId[i] = Integer.parseInt(string[i]);
			}
			List<Integer> asList = Arrays.asList(arrayId);
			
			if(asList.isEmpty()) {
				responseJson.put("message", "查無寵物");
				responseJson.put("success", false);
			} else {
				if(petService.remove(asList)) {
					responseJson.put("message", "刪除成功");
					responseJson.put("success", true);
				} else {
					responseJson.put("message", "刪除失敗");
					responseJson.put("success", false);
				}
			}
		}else {
			responseJson.put("message", "查無寵物");
			responseJson.put("success", false);
		}
		return responseJson.toString();
	}
	
	//找出一隻寵物資訊
	@PostMapping(path="/information/exists")
	public String exist(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null : obj.getInt("id");	
		
		MyPetView pet = petService.findById(id);
		if(pet != null) {
			//拿出單一隻寵物的所有照片資料
			List<PetPhotoBean> myPetPhotos = petService.findMyPetPhoto(pet.getPetId());
			JSONArray arrayPhotos = new JSONArray();
			JSONObject firstPhoto = new JSONObject();
			//將單一隻寵物所有照片包裝成陣列
			if(myPetPhotos != null && !myPetPhotos.isEmpty()) {
				for(PetPhotoBean myPetPhoto : myPetPhotos) {	
					JSONObject photo = new JSONObject()
							.put("photoId", myPetPhoto.getId())
							.put("fkPetId", myPetPhoto.getFkPetId())
							.put("main", myPetPhoto.getMain())
							.put("img", myPetPhoto.getImg());
					if(myPetPhoto.getMain() != null) {
						firstPhoto = photo;
					}else {						
						arrayPhotos = arrayPhotos.put(photo);	
					}
				}
			}
			responseJson.put("id", pet.getPetId());
			responseJson.put("fkMemberId", pet.getFkMemberId());
			responseJson.put("name", pet.getName());
			responseJson.put("species", pet.getSpecies());
			responseJson.put("breed", pet.getBreed());
			responseJson.put("age", pet.getAge());
			responseJson.put("gender", pet.getGender());
			responseJson.put("firstPhoto",firstPhoto);
			responseJson.put("imgList", arrayPhotos);
		} else {
			responseJson.put("message", "查無寵物");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	
	//找出某人的寵物
	@PostMapping(path="/information/find")
	public String findMyPet(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		
		JSONObject obj = new JSONObject(body);
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");	
		
		//拿出使用者的所有寵物資料
		List<MyPetView> result = petService.findMyPet(fkMemberId);		

		if(result != null && !result.isEmpty()) {	
			//用迴圈跑每一隻寵物
			for(MyPetView myPet : result) {	
				//拿出單一隻寵物的所有照片資料
				List<PetPhotoBean> myPetPhotos = petService.findMyPetPhoto(myPet.getPetId());
				JSONArray arrayPhotos = new JSONArray();
				JSONObject firstPhoto = new JSONObject();
				//將單一隻寵物所有照片包裝成陣列
				if(myPetPhotos != null && !myPetPhotos.isEmpty()) {
					for(PetPhotoBean myPetPhoto : myPetPhotos) {	
						JSONObject photo = new JSONObject()
								.put("photoId", myPetPhoto.getId())
								.put("fkPetId", myPetPhoto.getFkPetId())
								.put("main", myPetPhoto.getMain())
								.put("img", myPetPhoto.getImg());
						if(myPetPhoto.getMain() != null) {
							firstPhoto = photo;
						}else {						
							arrayPhotos = arrayPhotos.put(photo);	
						}
					}
				}
				//包裝單一隻寵物資料
				JSONObject item = new JSONObject()
						.put("petId", myPet.getPetId())
						.put("fkMemberId", myPet.getFkMemberId())
						.put("name", myPet.getName())
						.put("species", myPet.getSpecies())
						.put("breed", myPet.getBreed())
						.put("age", myPet.getAge())
						.put("gender", myPet.getGender())
						.put("firstPhoto",firstPhoto)
						.put("imgList", arrayPhotos);
				array = array.put(item);
			}
			responseJson.put("petList", array);			
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
				String createAt = DatetimeConverter.toString(
						pet.getCreateAt(), "yyyy-MM-dd");
				JSONObject item = new JSONObject()
						.put("id", pet.getId())
						.put("name", pet.getName())
						.put("species", pet.getSpecies())
						.put("breed", pet.getBreed())
						.put("userName", pet.getUserName())
						.put("likeCount", pet.getLikeCount())
						.put("createAt", createAt)
						.put("img", pet.getImg());
				array = array.put(item);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}	
}
