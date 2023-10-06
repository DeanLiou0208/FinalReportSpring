package tw.ispan.eeit168.forum.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.forum.domain.CommentsBean;
import tw.ispan.eeit168.forum.service.CommentsAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
public class CommentsAjaxController {
	@Autowired
	private CommentsAjaxService commentsAjaxService;
	@PostMapping(path = "/Comments")
	public String create(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		CommentsBean commentsBean = null;
		try {
			commentsBean = commentsAjaxService.create(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(commentsBean==null) {
			responseJson.put("message", "新增失敗");
			responseJson.put("success", false);
		}else {
			responseJson.put("message", "新增成功");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	@PutMapping(path = "/CommentsModify")
	public String modify(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null: obj.getInt("id");
		if(!commentsAjaxService.exists(id)) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		}else {
			CommentsBean commentsBean = null;
			try {
				commentsBean = commentsAjaxService.modify(body);
			} catch (Exception e) {
				e.printStackTrace();
			}if(commentsBean==null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			}else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
			}
		return responseJson.toString();
		}
	@DeleteMapping(path = "/CommentsRemove")
	public String Remove(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null: obj.getInt("id");
		if(!commentsAjaxService.exists(id)) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		}else {
			 if(commentsAjaxService.remove(id)) {
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
		
	

