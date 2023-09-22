package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.domain.CompanyBean;

@SpringBootTest
public class CompanyDaoHibernateTests {

	@Autowired
	private CompanyDao companyDao;

	@Test
	public void testSelectAll() {
		List<CompanyBean> selects = companyDao.select();
		System.out.println("selects=" + selects);
	}

}
