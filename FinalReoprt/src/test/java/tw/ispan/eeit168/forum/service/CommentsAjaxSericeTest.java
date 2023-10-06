package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import tw.ispan.eeit168.forum.domain.CommentsBean;

@SpringBootTest
public class CommentsAjaxSericeTest {

	@Autowired
	private CommentsAjaxService commentsAjaxService;
	@Test
	public void testFindAll() {
		List<CommentsBean> findAll = commentsAjaxService.findAll();
		System.out.println("findAll="+findAll);
	}

//	@Test
	public void testCreate() {
		JSONObject obj = new JSONObject()
				.put("fkMemberId", 10)
				.put("fkPetArticleId", 3)
				.put("commentsText", "Good!");
				
				CommentsBean create = commentsAjaxService.create(obj.toString());
				System.out.println("create="+create);		
	}
//	@Test
	public void testModify() {
		JSONObject obj = new JSONObject()
				.put("id", 30)
				.put("commentsText", "It is sooooo good!");
		CommentsBean modify = commentsAjaxService.modify(obj.toString());
		System.out.println("modifye="+modify);
	}
//	@Test
	public void testRemove() {
		boolean remove = commentsAjaxService.remove(30);
		System.out.println("remove="+remove);
	}
}
