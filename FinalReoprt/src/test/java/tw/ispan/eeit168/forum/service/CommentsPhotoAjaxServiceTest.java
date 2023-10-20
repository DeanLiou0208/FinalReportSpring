package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;

@SpringBootTest
public class CommentsPhotoAjaxServiceTest {
	@Autowired
	private CommentsPhotoAjaxService commentsPhotoAjaxService;

//	@Test
	public void testFindAll() {
		List<CommentsPhotoBean> findAll = commentsPhotoAjaxService.findAll();
		System.out.println("findAll="+findAll);
	}
//	@Test
	public void testCreate() {
		JSONObject obj = new JSONObject()
				.put("fkCommentsId", 26)
				.put("img", "data:image/jpeg;base64;cp13");
		
		CommentsPhotoBean create = commentsPhotoAjaxService.create(obj.toString());
//		System.out.println("create="+create);
	}
//	@Test
	public void testModify() {
		JSONObject obj = new JSONObject()
				.put("id", 19)
				.put("fkCommentsId", 26)
				.put("img", "data:image/jpeg;base64;cp14");
		
		CommentsPhotoBean modify = commentsPhotoAjaxService.modify(obj.toString());

		
	}
//	@Test
	public void testRemove() {
		boolean remove = commentsPhotoAjaxService.remove(19);
		System.out.println("remove="+remove);
	}
}
