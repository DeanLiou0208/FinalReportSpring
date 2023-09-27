package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import tw.ispan.eeit168.forum.dao.ArticleLikesBeanDao;
import tw.ispan.eeit168.forum.domain.ArticleLikesBean;
import tw.ispan.eeit168.shop.util.DoublePrimaryKey;

@SpringBootTest
@Transactional
public class ArticleLikesBeanDaoTest {
	
	@Autowired
	private ArticleLikesBeanDao articleLikesBeanDao;
	
	//@Test
	public void select() {
		List<ArticleLikesBean> select = articleLikesBeanDao.select();
		System.out.println(select);
	}
	//@Test
	public void selectLikeByMemberId() {
		List<ArticleLikesBean> result = articleLikesBeanDao.selectLikeByMemberId(1);
		System.out.println(result);
	}
	
	//@Test
	public void selectLikeByFkPetArticleId() {
		List<ArticleLikesBean> result = articleLikesBeanDao.selectLikeByFkPetArticleId(1);
		System.out.println(result);
	}
	//@Test
	public void insert() {
		ArticleLikesBean insert = new ArticleLikesBean();
		insert.setFkMemberId(9);
		insert.setFkPetArticleId(1);
		insert.setLikeOrUnlike(true);
		
		ArticleLikesBean result = articleLikesBeanDao.insert(insert);
		System.out.println(result);
	}
	//@Test
	public void update() {
		ArticleLikesBean update = new ArticleLikesBean();
		update.setFkMemberId(9);
		update.setFkPetArticleId(1);
		update.setLikeOrUnlike(true);
		
		ArticleLikesBean result = articleLikesBeanDao.update(update);
		System.out.println(result);
	}
	
	@Test
	public void delete() {
		DoublePrimaryKey delete = new DoublePrimaryKey();
		delete.setFkMemberId(1);
		delete.setFkPetArticleId(1);
		
		boolean result = articleLikesBeanDao.delete(delete);
		System.out.println(result);
	}
}
