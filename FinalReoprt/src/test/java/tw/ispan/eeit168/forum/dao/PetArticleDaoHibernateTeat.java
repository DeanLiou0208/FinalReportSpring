package tw.ispan.eeit168.forum.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticleBean;

@SpringBootTest
public class PetArticleDaoHibernateTeat {
	@Autowired
	private PetArticleDao petArticleDao;
//	@Test
	public void testSelect() {
		List<PetArticleBean> selects = petArticleDao.select();
		System.out.println("selects="+selects);
	}
	@Test
	public void testSelectById() {
		PetArticleBean select = petArticleDao.select(9);
		System.out.println("select="+select);
	}
//	@Test
	public void testSelectByMemberId() {
		List<PetArticleBean> selectByMemberId = petArticleDao.selectByMemberId(5);
		System.out.println("selectByMemberId="+selectByMemberId);
	}
	@Test
	public void testOrderByTime() {
		List<PetArticleBean> list = petArticleDao.orderByTime();
		System.out.println("list="+list);
	}
//	@Test
	public void testInsert() {
		 PetArticleBean insert = new PetArticleBean();
		 insert.setFkMemberId(5);
		 insert.setTitle("可愛黃金獵犬");
		 insert.setType("寵萌搞笑");
		 insert.setPetArticleText("俏皮可愛");
		 insert.setCreateAt(new Timestamp(System.currentTimeMillis()));
		 
		 PetArticleBean result = petArticleDao.insert(insert);
		 System.out.println("insert="+result);		
	}
//	@Test
	public void testUpdate() {
		PetArticleBean update = new PetArticleBean();
		update.setId(16);
//		update.setUid("95ad4df0-fad0-4873-80cc-2e3aa8780a11");
		update.setFkMemberId(8);
		update.setTitle("調皮大貴賓");
		update.setType("寵萌搞笑");
		update.setPetArticleText("cute!");
		update.setCreateAt(new Timestamp(System.currentTimeMillis()));
		
		PetArticleBean result = petArticleDao.update(update);
		System.out.println("update="+result);
	}
//	@Test
	public void testDelete() {
		boolean delete = petArticleDao.delete(16);
		System.out.println("delete="+delete);
	}

}
