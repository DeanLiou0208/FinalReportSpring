package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.PetCategroyBean;

@SpringBootTest
@Transactional
public class PetCategroyDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PetCategroyDAO petCategroyDAO;
	
	@Test
	public void testSelect() {
		PetCategroyBean select = petCategroyDAO.select(1);
		System.out.println("select first =" + select);
	}
	
	@Test
	public void testSelectAll() {
		List<PetCategroyBean> selects = petCategroyDAO.select();
		System.out.println("selects="+selects);
	}
}
