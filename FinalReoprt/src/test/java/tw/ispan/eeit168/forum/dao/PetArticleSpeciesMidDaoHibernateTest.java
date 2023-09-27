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
//	@Test
	public void testSelect() {
		List<PetArticleSpeciesMidBean> selects = petArticleSpeciesMidDao.select();
		System.out.println("selects="+selects);
	}
	@Test
	public void testSelectByArticleId() {
		List<PetArticleSpeciesMidBean> find = petArticleSpeciesMidDao.select(2);
		System.out.println("articleId="+find);
	}
//	@Test
	public void testInsert() {
		PetArticleSpeciesMidBean insert = new PetArticleSpeciesMidBean();
		insert.setFkPetArticleId(10);
		insert.setFkPetArticleSpeciesId(1);
		PetArticleSpeciesMidBean result = petArticleSpeciesMidDao.insert(insert);
		System.out.println("insert="+result);
	}
//	@Test
	public void testUpdate() {
		PetArticleSpeciesMidBean update = new PetArticleSpeciesMidBean();
		update.setId(11);
		update.setFkPetArticleId(10);
		update.setFkPetArticleSpeciesId(2);
		PetArticleSpeciesMidBean result = petArticleSpeciesMidDao.update(update);
		System.out.println("update="+result);
	}
//	@Test
	public void testDelete() {
		boolean delete = petArticleSpeciesMidDao.delete(11);
		System.out.println("delete="+delete);
	}

}
