package tw.ispan.eeit168.shop.dao;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.PetArticleOrderView;

@SpringBootTest
public class PetArticleOrderViewDaoTest {
	
	@Autowired
	private PetArticleOrderViewDao petArticleOrderViewDao;
	
	@Test
	public void select() {
		List<PetArticleOrderView> select = petArticleOrderViewDao.select();
		System.out.println(select);
	}
}
