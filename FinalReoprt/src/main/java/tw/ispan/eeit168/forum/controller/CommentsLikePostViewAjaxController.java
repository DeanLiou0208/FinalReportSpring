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
		if(result!=null && !result.isEmpty() ) {
			for(CommentsLikePostView byPetArticleId : result) {
				JSONObject item = new JSONObject()
						.put("fkPetArticleId", byPetArticleId.getFkPetArticleId())
						.put("commentsText",byPetArticleId.getCommentsText())
						.put("user_name", byPetArticleId.getUserName())
						.put("likeCount", byPetArticleId.getLikeCount())
						.put("unlikeCount", byPetArticleId.getUnlikeCount());
//						.put("createAt", byPetArticleId.getCreateAt());
				
			array = array.put(item);					
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
		
	}
}
