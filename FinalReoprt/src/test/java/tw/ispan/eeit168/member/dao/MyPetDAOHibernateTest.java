package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.domain.MyPetView;

@SpringBootTest
@Transactional
public class MyPetDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private MyPetDAO myPetDAO;
	
	@Test
	public void testSelect() {
		MyPetView select = myPetDAO.selectId(1);
		System.out.println("select first =" + select);
	}
	
	@Test
	public void testSelectAll() {
		List<MyPetView> selects = myPetDAO.select();
		System.out.println("selects="+selects);
	}
}
