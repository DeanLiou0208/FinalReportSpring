package tw.ispan.eeit168.forum.controller;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tw.ispan.eeit168.forum.domain.CommentsLikesBean;
import tw.ispan.eeit168.forum.service.CommentsLikesAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
//@Transactional
public class CommentsLikesAjaxController {
	@Autowired
	private CommentsLikesAjaxService commentsLikesAjaxService;
	
	@GetMapping(path ="/commentsLikes/byMemberId" )
	public String findByMemberId(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		
		try {

			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId")? null : obj.getInt("fkMemberId");
			
			JSONArray array = new JSONArray();
			List<CommentsLikesBean> result = commentsLikesAjaxService.select(fkMemberId);
			if(result!=null && !result.isEmpty()) {
				for(CommentsLikesBean commentsLikes :result) {
					JSONObject item = new JSONObject()
							.put("fkMemberId", commentsLikes.getFkMemberId())
							.put("fkCommentId", commentsLikes.getFkCommentId())
							.put("likeOrUnlike", commentsLikes.getLikeOrUnlike());
					
					array= array.put(item);
				}
			}
			responseJson.put("list", array);
		} catch (Exception e) {
			e.printStackTrace();
		}return responseJson.toString();
	}
	
	@GetMapping(path ="/commentsLikes/byCommentId" )
	public String findByCommentId(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		try {
//			ObjectMapper objectMapper = new ObjectMapper();
//			Map<String, Object> jsonObject = objectMapper.readValue(json, Map.class);
//			Integer fkCommentId = (Integer)jsonObject.get("fkCommentId");
			
			JSONObject obj = new JSONObject(json);
			Integer fkCommentId = obj.isNull("fkCommentId")? null : obj.getInt("fkCommentId");
			
			JSONArray array = new JSONArray();
			List<CommentsLikesBean> result = commentsLikesAjaxService.selectByCommentId(fkCommentId);
			if(result!=null && !result.isEmpty()) {
				for(CommentsLikesBean commentsLikes : result) {
					JSONObject item = new JSONObject()
							.put("fkMemberId",commentsLikes.getFkMemberId() )
							.put("fkCommentId", commentsLikes.getFkCommentId())
							.put("likeOrUnlike", commentsLikes.getLikeOrUnlike());
					array = array.put(item);
				}
				responseJson.put("list", array);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return responseJson.toString();
	}
	
	@PostMapping(path = "/commentsLikes")
	public String create(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		CommentsLikesBean commentsLikesBean = null;
		try {
			commentsLikesBean = commentsLikesAjaxService.create(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(commentsLikesBean==null) {
			responseJson.put("message", "新增失敗");
			responseJson.put("success", false);
		}else {
			responseJson.put("message", "新增成功");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	
	@DeleteMapping(path = "/commentsLikes/commentsLikesRemove/{fkCommentId}")
	public String remove (@PathVariable("fkCommentId") Integer fkCommentId) {
		
		JSONObject responseJson = new JSONObject();
		try {
		
		if(commentsLikesAjaxService.remove(fkCommentId)) {
			responseJson.put("message", "刪除成功");
			responseJson.put("success", true);
		}else {
			responseJson.put("message", "刪除失敗");
			responseJson.put("success", false);
		}
		} catch (Exception e) {
			e.printStackTrace();
	    }
	return responseJson.toString();
}
	
	@DeleteMapping(path = "/commentDislike/{fkCommentId}/{fkMemberId}")
	public String removeLike(@PathVariable Integer fkCommentId,@PathVariable Integer fkMemberId) {
		JSONObject responseJson = new JSONObject();
		boolean result = false;
		try {
			result = commentsLikesAjaxService.removeLike(fkCommentId, fkMemberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result) {
			responseJson.put("message", "已取消愛心");
			responseJson.put("success", true);
		}else {
			responseJson.put("message", "取消失敗");
			responseJson.put("success", false);
		}
		return responseJson.toString();
	}
	
	
	
	
	
}