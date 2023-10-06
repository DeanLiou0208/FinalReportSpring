package tw.ispan.eeit168.forum.dao;


import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticleOrderView;

@SpringBootTest
public class PetArticleOrderViewDaoTest {
	
	@Autowired
	private PetArticleOrderViewDao petArticleOrderViewDao;
	
//	@Test
	public void select() {
		List<PetArticleOrderView> select = petArticleOrderViewDao.select();
		System.out.println(select);
	}
//	@Test
	public void selectShrech() {
		List<PetArticleOrderView> selectShrech = petArticleOrderViewDao.selectShrech("寶寶");
		System.out.println(selectShrech);
	}
//	@Test
//	public void testFind() {
//		JSONObject obj = new JSONObject()
//				.put("type", ("萌寵搞笑"))
//				.put("title", "貓")
//				.put("sort", "lastTime")
//				.put("order", "desc");
//		List<PetArticleOrderView> find = petArticleOrderViewDao.find(obj);
//		for(PetArticleOrderView bean : find) {
//			System.out.println("bean="+bean);
//		}
//	}
	@Test
	public void testFindByMemberId() {
		JSONObject obj = new JSONObject()
				.put("fkMemberId", 5)
				.put("sort", "lastTime")
				.put("order", "dest");
		List<PetArticleOrderView> byMemberId = petArticleOrderViewDao.findByMemberId(obj);
		for(PetArticleOrderView bean : byMemberId) {
			System.out.println("bean="+bean);
		}
	
	}
}
