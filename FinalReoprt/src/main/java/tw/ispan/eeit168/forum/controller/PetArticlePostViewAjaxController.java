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

import tw.ispan.eeit168.forum.domain.CommentsLikePostView;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;
import tw.ispan.eeit168.forum.domain.SpeciesViewsView;
import tw.ispan.eeit168.forum.service.PetArticlePostViewAjaxService;
import tw.ispan.eeit168.member.util.DatetimeConverter;
import tw.ispan.eeit168.forum.domain.PetArticlePostView;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
public class PetArticlePostViewAjaxController {
	@Autowired
	private PetArticlePostViewAjaxService petArticlePostViewAjaxService;
//	 會員寵物文章呈現
	@PostMapping(path = "PetArticlePostView/ByArticleId")
	public String findById (@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("petArticleId") ? null : obj.getInt("petArticleId");
		PetArticlePostView articlePost = petArticlePostViewAjaxService.findById(id);
		
		if(articlePost!=null) {
			//拿出寵物文章的所有照片資料
			List<PetArticlePhotoBean> myPetArticlePhotos = petArticlePostViewAjaxService.findMyPetArticlePhoto(id);
			JSONArray arrayPhotos = new JSONArray();
			JSONObject firstPhoto = new JSONObject();
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
			//拿出寵物文章的所有寵物物種資料
			List<SpeciesViewsView> petArticleSpecies = petArticlePostViewAjaxService.findPetArticleSpecies(id);
			JSONArray arraySpecies = new JSONArray();
			if(petArticleSpecies!=null && !petArticleSpecies.isEmpty()) {
				for(SpeciesViewsView species : petArticleSpecies) {
					JSONObject item = new JSONObject()
//							.put("id", species.getFkPetArticleId())
							.put("species", species.getSpecies());
					
					arraySpecies = arraySpecies.put(item);
				}	
			}
			JSONObject memberId = new JSONObject(body);
			Integer fkMemberId = memberId.isNull("fkMemberId") ? null : memberId.getInt("fkMemberId");
			
			boolean containsLikeTarget =false;
			boolean containsUnlikeTarget= false;
			if(fkMemberId!=null) {
				
				List<Integer> likeRecord = petArticlePostViewAjaxService.likeRecord(body);
				List<Integer> unlikeRecord = petArticlePostViewAjaxService.unlikeRecord(body);
//				查詢會員按讚或是按倒讚是否有紀錄
				containsLikeTarget = likeRecord.contains(articlePost.getPetArticleId());
				containsUnlikeTarget = unlikeRecord.contains(articlePost.getPetArticleId());
			}
//			判斷按讚數是否為空值
			Integer likeCount = articlePost.getLikeCount();
			if(likeCount == null) {
				likeCount = 0;
			}
			Integer unlikeCount = articlePost.getUnlikeCount();
			if(unlikeCount == null) {
				unlikeCount = 0;
			}
			Integer totalComments = articlePost.getTotalComments();
			if(totalComments == null) {
				totalComments = 0;
			}
			
			String createAt = DatetimeConverter.toString(
					articlePost.getCreateAt(), "yyyy-MM-dd");
			responseJson.put("petArticleId", articlePost.getPetArticleId());
			responseJson.put("type", articlePost.getType());
			responseJson.put("title", articlePost.getTitle());
			responseJson.put("petArticleText", articlePost.getPetArticleText());
			responseJson.put("createAt", createAt);
			responseJson.put("userName", articlePost.getUserName());
			responseJson.put("likeCount", likeCount);
			responseJson.put("unlikeCount", unlikeCount);
			responseJson.put("totalComments",totalComments);
			responseJson.put("img", articlePost.getImg());
			responseJson.put("photo",arrayPhotos);
			responseJson.put("species",arraySpecies);
			responseJson.put("memberId",articlePost.getMemberId());
			
			
			
			if(containsLikeTarget) {
				responseJson.put("likeRecord",true);
			}else {
				responseJson.put("likeRecord",false);
			}
			if(containsUnlikeTarget) {
				responseJson.put("unlikeRecord",true);
			}else {
				responseJson.put("unlikeRecord",false);
			}
			
				
		}else {
			responseJson.put("message", "查無寵物文章");
			responseJson.put("success", false);
		}
		return responseJson.toString();
	}
	@PostMapping(path = "PetArticlePostView/ByMemberId")
	public String findByMemberId (@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("memberId") ? null : obj.getInt("memberId");
		long count = petArticlePostViewAjaxService.count(id);
		responseJson.put("count", count);
//		System.out.println("count:"+count);
		JSONArray array = new JSONArray();
		List<PetArticlePostView> byMemberId = petArticlePostViewAjaxService.findByMemberId(body);
	
		if(byMemberId!=null) {
			for(PetArticlePostView bean : byMemberId) {
//				寵物文章照片
	            List<PetArticlePhotoBean> myPetArticlePhotos = petArticlePostViewAjaxService.findMyPetArticlePhoto(bean.getPetArticleId());
	        	
	            String firstPhoto = null;
	            if (myPetArticlePhotos != null && !myPetArticlePhotos.isEmpty()) {
	            	
	 	            	PetArticlePhotoBean firstPhotoBean = myPetArticlePhotos.get(0); // 取得第一張照片
	 	                firstPhoto = firstPhotoBean.getImg();
	 	                
	            }  
//	            寵物文章貼文按讚數和倒讚數
	            List<CommentsLikePostView> commentLikes = petArticlePostViewAjaxService.selectByPetArticleId(bean.getPetArticleId());
//	            System.out.println("commentLikes:"+commentLikes);
	            Integer commentLikeCount = 0;
	            Integer commentUnlikeCount = 0;
	            if(commentLikes!=null) {
	            	for(CommentsLikePostView commentLike : commentLikes) {
	            		commentLikeCount = commentLike.getLikeCount();
	            		commentUnlikeCount = commentLike.getUnlikeCount();
	            		if(commentLikeCount == null) {
	            			commentLikeCount = 0;
	            		}
	            		if(commentUnlikeCount == null) {
	            			commentUnlikeCount = 0;
	            		}
	            	}
	            }
	            Integer likeCount = bean.getLikeCount();
	            if(likeCount == null) {
	            	likeCount = 0;	            
	            }
	            Integer unLikeCount = bean.getUnlikeCount();
	            if(unLikeCount == null) {
	            	unLikeCount = 0;	            
	            }
	            Integer totalComments = bean.getTotalComments();
	            if(totalComments == null) {
	            	totalComments = 0;	            
	            }
	            
	            JSONObject item = new JSONObject()
	                    .put("id", bean.getPetArticleId())
	                    .put("memberId", bean.getMemberId())
	                    .put("type", bean.getType())
	                    .put("title", bean.getTitle())
	                    .put("petArticleText", bean.getPetArticleText())
	                    .put("userName", bean.getUserName())
	                    .put("createAt", bean.getCreateAt())
	                    .put("img", bean.getImg())
	                    .put("likeCount", likeCount)
	                    .put("unLikeCount", unLikeCount)
	                    .put("totalComments", bean.getTotalComments())
	                    .put("main", firstPhoto)
	                    .put("commentLikeCount",commentLikeCount)
	                    .put("commentUnlikeCount",commentUnlikeCount);
	                    
	            		array = array.put(item);
	        }
			}
			responseJson.put("list", array);
//			System.out.println(array);
			
		return responseJson.toString();
		}
	

	}

