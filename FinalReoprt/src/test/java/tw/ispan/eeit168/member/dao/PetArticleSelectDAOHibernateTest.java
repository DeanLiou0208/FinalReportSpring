package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.PetArticleSelectBean;

@SpringBootTest
@Transactional
public class PetArticleSelectDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetArticleSelectDAO petArticleSelectDAO;
	
	@Test
	public void testSelect() {
		PetArticleSelectBean select = petArticleSelectDAO.select(1);
		System.out.println("select first =" + select);
	}
	
	@Test
	public void testSelectAll() {
		List<PetArticleSelectBean> selects = petArticleSelectDAO.select();
		System.out.println("selects="+selects);
	}
}
