package tw.ispan.eeit168.forum.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;

@SpringBootTest
public class CommentsPhotoDaoHibernateTest {
	
	@Autowired
	private CommentsPhotoDao commentsPhotoDao;
	
//	@Test
	public void testSelect() {
		List<CommentsPhotoBean> selects = commentsPhotoDao.select();
		System.out.println("selects="+selects);
	}
	@Test
	public void testSelectById() {
		CommentsPhotoBean select = commentsPhotoDao.select(10);
		System.out.println("select="+select);
		
	}
//	@Test
	public void testInsert() {
		CommentsPhotoBean insert = new CommentsPhotoBean();
		insert.setFkCommentsId(26);
		insert.setImg("data:image/jpeg;base64;cp13");
//		insert.setCreateAt(new Timestamp(System.currentTimeMillis()));
		
		CommentsPhotoBean result = commentsPhotoDao.insert(insert);
		System.out.println("insert="+result);
	}
//	@Test
	public void testUpdate() {
		CommentsPhotoBean update = new CommentsPhotoBean();	
		update.setId(14);
		update.setFkCommentsId(25);
		update.setImg("data:image/jpeg;base64;cp14");
		update.setCreateAt(new Timestamp(System.currentTimeMillis()));
		
		CommentsPhotoBean result = commentsPhotoDao.update(update);
		System.out.println("update="+result);
	}
//	@Test
	public void testDelete() {
		boolean delete = commentsPhotoDao.delete(14);
		System.out.println("delete="+delete);
	}

}
