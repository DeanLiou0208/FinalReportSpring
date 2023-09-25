package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticleSpeciesBean;

@SpringBootTest
public class PetArticleSpeciesDaoHibernateTest {
	@Autowired
	private PetArticleSpeciesDao petArticleSpeciesDao;
	@Test
	public void testSelect() {
		List<PetArticleSpeciesBean> selects = petArticleSpeciesDao.select();
		System.out.println("selects="+selects);
	}
}
