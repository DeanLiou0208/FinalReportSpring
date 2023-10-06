package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsLikePostView;

@SpringBootTest
public class CommentsLikePostViewDaoHibernateTest {
	@Autowired
	private CommentsLikePostViewDao commentsLikePostDao;
//	@Test
	public void testSelect() {
		List<CommentsLikePostView> selects = commentsLikePostDao.select();
		System.out.println("selects="+selects);
	}
	@Test
	public void testSelectByPetArticleId() {
		JSONObject obj = new JSONObject()
				.put("fkPetArticleId", 2)
				.put("sort", "createAt")
				.put("order", "desc");
		List<CommentsLikePostView> byPetArticleId = commentsLikePostDao.selectByPetArticleId(obj);
		for(CommentsLikePostView bean : byPetArticleId ) {
			System.out.println("bean="+bean);
		}
	}
}
