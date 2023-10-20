package tw.ispan.eeit168.forum.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.forum.domain.CommentsLikePostView;
import tw.ispan.eeit168.forum.service.CommentsLikePostViewAjaxService;
import tw.ispan.eeit168.member.util.DatetimeConverter;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
public class CommentsLikePostViewAjaxController {
	@Autowired
	private CommentsLikePostViewAjaxService commentsLikePostViewAjaxService;
	@PostMapping(path = "/CommentsLikePostView/byPetArticle")
	public String findByPetArticleId(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONArray array = new JSONArray();
		List<CommentsLikePostView> result = commentsLikePostViewAjaxService.findByPetArticleId(body);
		
		JSONObject obj = new JSONObject(body);
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		Integer fkPetArticleId = obj.isNull("petArticleId") ? null : obj.getInt("petArticleId");
		
		
		boolean containsCommentsLikeTarget =false;
		boolean containsCommentsUnlikeTarget= false;
//		if(fkMemberId!=null) {
//			
//			List<Integer> likeCommentRecord = commentsLikePostViewAjaxService.likeCommentRecord(body);
//			List<Integer> unlikeCommentRecord = commentsLikePostViewAjaxService.unlikeCommentRecord(body);
//			查詢會員按讚或是按倒讚是否有紀錄
//			containsCommentsLikeTarget = likeCommentRecord.contains(byPetArticleId.getId());
//			containsCommentsUnlikeTarget = unlikeCommentRecord.contains(byPetArticleId.getId());
//		}

		if(result!=null && !result.isEmpty()) {
			for(CommentsLikePostView byPetArticleId : result) {
				String createAt = DatetimeConverter.toString(
						byPetArticleId.getCreateAt(), "yyyy-MM-dd");
				
				if(fkMemberId!=null) {
				List<Integer> likeCommentRecord = commentsLikePostViewAjaxService.likeCommentRecord(body);
//				System.out.println("likeCommentRecord:"+likeCommentRecord);
				List<Integer> unlikeCommentRecord = commentsLikePostViewAjaxService.unlikeCommentRecord(body);
//				System.out.println("unlikeCommentRecord:"+unlikeCommentRecord);
//				查詢會員按讚或是按倒讚是否有紀錄
				containsCommentsLikeTarget = likeCommentRecord.contains(byPetArticleId.getId());
				
				containsCommentsUnlikeTarget = unlikeCommentRecord.contains(byPetArticleId.getId());
				}

//				判斷按讚數是否為空值
				Integer likeCount = byPetArticleId.getLikeCount();
				if(likeCount== null) {
					likeCount=0;
				}
				Integer unlikeCount = byPetArticleId.getUnlikeCount();
				if(unlikeCount== null) {
					unlikeCount=0;
				}
				JSONObject item = new JSONObject()
						.put("fkCommentId", byPetArticleId.getId())
						.put("fkPetArticleId", byPetArticleId.getFkPetArticleId())
						.put("commentsText",byPetArticleId.getCommentsText())
						.put("userName", byPetArticleId.getUserName())
						.put("likeCount", likeCount)
						.put("unlikeCount", unlikeCount)
						.put("createAt", createAt)
						.put("img", byPetArticleId.getImg())
						.put("likeCommentRecord", containsCommentsLikeTarget)
						.put("unlikeCommentRecord", containsCommentsUnlikeTarget);
				
				
//				if(containsCommentsLikeTarget) {
//					responseJson.put("likeCommentRecord",true);
//				}else {
//					responseJson.put("likeCommentRecord",false);
//				}
//				if(containsCommentsUnlikeTarget) {
//					responseJson.put("unlikeCommentRecord",true);
//				}else {
//					responseJson.put("unlikeCommentRecord",false);
//				}
				
			array = array.put(item);					
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
		
	}
}
