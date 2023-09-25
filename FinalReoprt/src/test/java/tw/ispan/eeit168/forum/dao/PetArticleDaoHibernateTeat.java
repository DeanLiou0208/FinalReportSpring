package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticleBean;

@SpringBootTest
public class PetArticleDaoHibernateTeat {
	@Autowired
	private PetArticleDao petArticleDao;
	@Test
	public void testSelect() {
		List<PetArticleBean> selects = petArticleDao.select();
		System.out.println("selects="+selects);
	}

}
