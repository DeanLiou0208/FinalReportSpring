package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsLikePostView;

@SpringBootTest
public class CommentsLikePostDaoHibernateTest {
	@Autowired
	private CommentsLikePostDao commentsLikePostDao;
	@Test
	public void testSelect() {
		List<CommentsLikePostView> selects = commentsLikePostDao.select();
		System.out.println("selects="+selects);
	}
 
}
