package tw.ispan.eeit168.forum.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;

@SpringBootTest
public class PetArticlePhotoDaoHibernateTest {
	@Autowired
	private PetArticlePhotoDao petArticlePhotoDao;
//	@Test
	public void testSelect() {
		List<PetArticlePhotoBean> selects = petArticlePhotoDao.select();
		System.out.println("selects="+selects);
	}
//	@Test
	public void testSelectById() {
		PetArticlePhotoBean select = petArticlePhotoDao.select(10);
		System.out.println("select="+select);		
	}
//	@Test
	public void testSelectByPetArticleId() {
		List<PetArticlePhotoBean> petArticleId = petArticlePhotoDao.selectByPetArticleId(9);
		System.out.println("petArticleId="+petArticleId);	
	}
//	@Test
	public void testInsert() {
		PetArticlePhotoBean insert = new PetArticlePhotoBean();
		insert.setFkPetArticleId(8);
		insert.setMain(null);
		insert.setImg("image/jpeg;base64;pap6");
		insert.setCreateAt(new Timestamp(System.currentTimeMillis()));
		
		PetArticlePhotoBean result = petArticlePhotoDao.insert(insert);
		System.out.println("insert="+result);
	}
//	@Test
	public void testUpdate() {
		PetArticlePhotoBean update = new PetArticlePhotoBean();
		update.setId(30);
		update.setFkPetArticleId(5);
		update.setMain(null);
		update.setImg("image/jpeg;base64;pap6");
		update.setCreateAt(new Timestamp(System.currentTimeMillis()));
		
		PetArticlePhotoBean result = petArticlePhotoDao.update(update);		
		System.out.println("update="+result);
	}
//	@Test
	public void testDelete() {
		boolean delete = petArticlePhotoDao.delete(29);
		System.out.println("delete="+delete);
	}
	@Test
	public void testDeleteByPetArticleId() {
		Boolean deleteByPetArticleId = petArticlePhotoDao.deleteByPetArticleId(1);
		System.out.println("deleteByPetArticleId="+deleteByPetArticleId);
	}
	
}
