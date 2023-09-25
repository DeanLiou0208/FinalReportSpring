package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.PetBean;

@SpringBootTest
@Transactional
public class PetDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetDAO petDAO;
	
	@Test
	public void testSelect() {
		PetBean select = petDAO.select(1);
		System.out.println("select first =" + select);
	}
	
	@Test
	public void testSelectAll() {
		List<PetBean> selects = petDAO.select();
		System.out.println("selects="+selects);
	}
}
