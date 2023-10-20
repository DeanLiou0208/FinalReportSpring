package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.dao.PetArticlePostViewDao;
import tw.ispan.eeit168.forum.domain.PetArticlePostView;

@SpringBootTest
public class PetArticlePostViewDaoTest {
	
	@Autowired
	private PetArticlePostViewDao petArticlePostViewDao;
	
	//@Test
	public void select() {
		List<PetArticlePostView> select = petArticlePostViewDao.select();
		System.out.println(select);
	}
	
//	@Test
	public void selectById() {
		PetArticlePostView selectById = petArticlePostViewDao.selectById(1);
		System.out.println(selectById);
	}
//	@Test
	public void count () {
		Long count = petArticlePostViewDao.count(2);
		System.out.println(count);
	}
}
