package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsLikesBean;

@SpringBootTest
public class CommentsLikesDaoHibernateTest {
	@Autowired
	private CommentsLikesDao commentsLikesDao;
	
	@Test
	public void testSelect() {
		List<CommentsLikesBean> selects = commentsLikesDao.select();
		System.out.println("selects="+selects);
	}
}
