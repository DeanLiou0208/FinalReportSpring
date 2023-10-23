package tw.ispan.eeit168.forum.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsLikesBean;

@SpringBootTest
public class CommentsLikesDaoHibernateTest {
	@Autowired
	private CommentsLikesDao commentsLikesDao;
	
//	@Test
	public void testSelect() {
		List<CommentsLikesBean> selects = commentsLikesDao.select();
		System.out.println("selects="+selects);
	}
//	@Test
	public void testSelectByMemberId() {
		List<CommentsLikesBean> select = commentsLikesDao.select(9);
		System.out.println("select="+select);
	}
	@Test
	public void testSelectByCommentId() {
		List<CommentsLikesBean> byCommentId = commentsLikesDao.selectByCommentId(2);
		System.out.println("byCommentId="+byCommentId);
	}
//	@Test
	public void testInsert() {
		CommentsLikesBean insert = new CommentsLikesBean();
		insert.setFkMemberId(5);
		insert.setFkCommentId(18);
		insert.setCreateAt(new Timestamp(System.currentTimeMillis()));
		insert.setLikeOrUnlike(true);
		
		CommentsLikesBean result = commentsLikesDao.insert(insert);
		System.out.println("result="+result);
		
	}
//	@Test
//	public void testDelete() {
//		boolean delete = commentsLikesDao.delete(5, 18);
//		System.out.println("delete="+delete);
//	}
//	
	
	}
