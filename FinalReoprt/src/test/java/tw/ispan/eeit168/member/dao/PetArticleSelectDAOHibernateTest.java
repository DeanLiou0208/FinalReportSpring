package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.PetArticleSelectDAO;
import tw.ispan.eeit168.forum.domain.PetArticleSelectBean;
import tw.ispan.eeit168.member.domain.PetLikesBean;

@SpringBootTest
public class PetArticleSelectDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetArticleSelectDAO petArticleSelectDAO;
	
//	@Test
	public void testSelect() {
		PetArticleSelectBean select = petArticleSelectDAO.select(1);
		System.out.println("select first =" + select);
	}
	
//	@Test
	public void testSelectAll() {
		List<PetArticleSelectBean> selects = petArticleSelectDAO.select();
		System.out.println("selects="+selects);
	}
	
//	@Test
	public void testInsert() {
		PetArticleSelectBean insert = new PetArticleSelectBean();
		insert.setType("測試");
		
		PetArticleSelectBean result = petArticleSelectDAO.insert(insert);
		System.out.println("insert="+result);
	}
	
//	@Test
	public void testDelete() {
		boolean delete = petArticleSelectDAO.delete(1003);
		System.out.println("delete="+delete);
	}
}
