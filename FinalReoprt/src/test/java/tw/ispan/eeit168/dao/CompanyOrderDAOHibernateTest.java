package tw.ispan.eeit168.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.company.dao.CompanyOrderDAO;
import tw.ispan.eeit168.company.domain.CompanyOrderView;

@SpringBootTest
@Transactional
public class CompanyOrderDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CompanyOrderDAO companyOrderDAO;
	
	@Test
	public void testSelect() {
		CompanyOrderView select = companyOrderDAO.select(1);
		System.out.println("select first =" + select);
	}
	
	@Test
	public void testSelectAll() {
		List<CompanyOrderView> selects = companyOrderDAO.select();
		System.out.println("selects="+selects);
	}
}
