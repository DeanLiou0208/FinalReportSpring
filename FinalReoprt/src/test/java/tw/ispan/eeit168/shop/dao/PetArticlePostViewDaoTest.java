package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.PetArticlePostView;

@SpringBootTest
public class PetArticlePostViewDaoTest {
	
	@Autowired
	private PetArticlePostViewDao petArticlePostViewDao;
	
	@Test
	public void select() {
		List<PetArticlePostView> select = petArticlePostViewDao.select();
		System.out.println(select);
	}
}
