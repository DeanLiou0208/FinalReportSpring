package tw.ispan.eeit168.forum.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsBean;

//@Transactional
@SpringBootTest
public class CommentsDaoHibernateTest {
	@Autowired
	private CommentsDao commentsDao;

//	@Test
	public void testSelect() {
		List<CommentsBean> selects = commentsDao.select();
		System.out.println("selects=" + selects);
	}

//	@Test
	public void testSelectById() {
		CommentsBean select = commentsDao.select(10);
		System.out.println("select=" + select);
	}

//	@Test
	public void testInsert() {
		CommentsBean insert = new CommentsBean();
//		insert.setId(28);
		insert.setFkMemberId(10);
		insert.setFkPetArticleId(3);
		insert.setCommentsText("awesome");
//		insert.setCreateAt(new Timestamp(System.currentTimeMillis()));
		CommentsBean rs = commentsDao.insert(insert);
		System.out.println("insert=" + rs);

	}
//	@Test
	public void testUpdate() {
		CommentsBean update = new CommentsBean();
		update.setId(28);
		update.setFkMemberId(10);
		update.setFkPetArticleId(4);
		update.setCommentsText("not good!");
		update.setCreateAt(new Timestamp(System.currentTimeMillis()));
		CommentsBean result = commentsDao.update(update);
		System.out.println("result="+result);
		
	}
//	@Test
	public void testDelete() {
		boolean delete = commentsDao.delete(28);
		System.out.println("delete="+delete);
	}

}
