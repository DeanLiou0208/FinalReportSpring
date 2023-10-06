package tw.ispan.eeit168.forum.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;
import tw.ispan.eeit168.forum.service.CommentsPhotoAjaxService;

@RestController
@RequestMapping(path = "/pages/ajax")
@CrossOrigin
public class CommentsPhotoAjaxController {
	@Autowired
	private CommentsPhotoAjaxService commentsPhotoAjaxService;

	@GetMapping(path = "/commentsPhoto")
	public String findByCommentsId(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer fkCommentsId = obj.isNull("fkCommentsId") ? null : obj.getInt("fkCommentsId");
		JSONArray array = new JSONArray();
		List<CommentsPhotoBean> byCommentsId = commentsPhotoAjaxService.findByCommentsId(fkCommentsId);
		if (byCommentsId != null) {
			for (CommentsPhotoBean bean : byCommentsId) {
				JSONObject item = new JSONObject().put("id", bean.getId()).put("fkCommentsId", bean.getFkCommentsId())
						.put("img", bean.getImg()).put("createAt", bean.getCreateAt());
				array = array.put(item);
			}
		}
		responseJson.put("list", array);
		return responseJson.toString();
	}

	@PostMapping(path = "/commentsPhotoCreate")
	public String create(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();

		CommentsPhotoBean commentsPhotoBean = null;
		try {
			commentsPhotoBean = commentsPhotoAjaxService.create(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (commentsPhotoBean == null) {
			responseJson.put("message", "新增失敗");
			responseJson.put("success", false);
		} else {
			responseJson.put("message", "新增成功");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}

	@PutMapping(path = "/commentsPhotoModify")
	public String modify(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null : obj.getInt("id");
		if (!commentsPhotoAjaxService.exists(id)) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		} else {
			CommentsPhotoBean commentsPhotoBean = null;
			try {
				commentsPhotoBean = commentsPhotoAjaxService.modify(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (commentsPhotoBean == null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}

	@DeleteMapping(path = "/commentsPhotoRemove")
	public String remove(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		Integer id = obj.isNull("id") ? null : obj.getInt("id");
		if (!commentsPhotoAjaxService.exists(id)) {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", false);
		} else {
			if (commentsPhotoAjaxService.remove(id)) {
				responseJson.put("message", "刪除成功");
				responseJson.put("success", true);
			} else {
				responseJson.put("message", "刪除失敗");
				responseJson.put("success", false);
			}
		}
		return responseJson.toString();
	}

}