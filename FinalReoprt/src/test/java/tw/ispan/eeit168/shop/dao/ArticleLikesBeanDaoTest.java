package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.ArticleLikesBean;

@SpringBootTest
public class ArticleLikesBeanDaoTest {
	
	@Autowired
	private ArticleLikesBeanDao articleLikesBeanDao;
	
	@Test
	public void select() {
		List<ArticleLikesBean> select = articleLikesBeanDao.select();
		System.out.println(select);
	}
}
