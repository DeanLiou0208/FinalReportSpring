package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.member.dao.CollectionPetArticleDao;
import tw.ispan.eeit168.member.domain.CollectionPetArticleView;

@SpringBootTest
public class CollectionPetArticleDaoHibernateTest {
	@Autowired
	private CollectionPetArticleDao collectionPetArticleDao;
	@Test
	public void testSelect() {
		List<CollectionPetArticleView> selects = collectionPetArticleDao.select();
		System.out.println("selects="+selects);
	}
 
}
