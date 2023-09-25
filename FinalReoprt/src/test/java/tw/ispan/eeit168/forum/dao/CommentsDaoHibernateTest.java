package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsBean;

@SpringBootTest
public class CommentsDaoHibernateTest {
	@Autowired
	private CommentsDao commentsDao;
	
	@Test
	public void testSelect() {
		List<CommentsBean> selects = commentsDao.select();
		System.out.println("selects="+selects);
	}
}
