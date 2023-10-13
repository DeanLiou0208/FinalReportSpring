package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticleBean;

@SpringBootTest
public class PetArticleAjaxServiceTest {
	@Autowired
	private PetArticleAjaxService petArticleAjaxService;
	@Test
	public void testFindAll() {
		List<PetArticleBean> findAll = petArticleAjaxService.findAll();
		System.out.println("findAll="+findAll);
		
	}
//	@Test
	public void testFindByMemberId() {
		List<PetArticleBean> findByMemberId = petArticleAjaxService.findByMemberId(5);
		System.out.println("findByMemberId="+findByMemberId);
	}
	@Test
	public void testFindByTime() {
		List<PetArticleBean> byTime = petArticleAjaxService.orderByTime();
		System.out.println("byTime="+byTime);
	}
//	@Test
//	public void testCreate() {
//		JSONObject obj = new JSONObject()
//				.put("fkMemberId", 9)
//				.put("type", "寵萌搞笑")
//				.put("title", "可愛黃金獵犬")
//				.put("petArticleText", "俏皮可愛");
//		PetArticleBean create = petArticleAjaxService.create(obj.toString());
//		System.out.println("create="+create);
//	}
//	@Test
	public void testModify() {
		JSONObject obj = new JSONObject()
				.put("id", 19)
				.put("type", "寵萌搞笑")
				.put("title", "調皮大貴賓")
				.put("petArticleText", "cute!");
	PetArticleBean modify = petArticleAjaxService.modify(obj.toString());
	System.out.println("modify="+modify);
	}	
//	@Test
	public void testRemove() {
		boolean remove = petArticleAjaxService.remove(17);
		System.out.println("remove="+remove);
	}
}
