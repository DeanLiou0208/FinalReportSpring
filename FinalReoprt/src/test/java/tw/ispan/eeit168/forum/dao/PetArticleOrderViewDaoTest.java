package tw.ispan.eeit168.forum.dao;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.dao.PetArticleOrderViewDao;
import tw.ispan.eeit168.forum.domain.PetArticleOrderView;

@SpringBootTest
public class PetArticleOrderViewDaoTest {
	
	@Autowired
	private PetArticleOrderViewDao petArticleOrderViewDao;
	
	@Test
	public void select() {
		List<PetArticleOrderView> select = petArticleOrderViewDao.select();
		System.out.println(select);
	}
	@Test
	public void selectShrech() {
		List<PetArticleOrderView> selectShrech = petArticleOrderViewDao.selectShrech("寶寶");
		System.out.println(selectShrech);
	}
}
