package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;

@SpringBootTest
public class CommentsPhotoDaoHibernateTest {
	
	@Autowired
	private CommentsPhotoDao commentsPhotoDao;
	
	@Test
	public void testSelect() {
		List<CommentsPhotoBean> selects = commentsPhotoDao.select();
		System.out.println("selects="+selects);
	}

}
