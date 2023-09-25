package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;

@SpringBootTest
public class PetArticlePhotoDaoHibernateTest {
	@Autowired
	private PetArticlePhotoDao petArticlePhotoDao;
	@Test
	public void testSelect() {
		List<PetArticlePhotoBean> selects = petArticlePhotoDao.select();
		System.out.println("selects="+selects);
	}

}
