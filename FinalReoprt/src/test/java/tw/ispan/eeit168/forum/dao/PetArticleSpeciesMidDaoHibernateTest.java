package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticleSpeciesMidBean;

@SpringBootTest
public class PetArticleSpeciesMidDaoHibernateTest {
	@Autowired
	private PetArticleSpeciesMidDao petArticleSpeciesMidDao;
	@Test
	public void testSelect() {
		List<PetArticleSpeciesMidBean> selects = petArticleSpeciesMidDao.select();
		System.out.println("selects="+selects);
	}

}
