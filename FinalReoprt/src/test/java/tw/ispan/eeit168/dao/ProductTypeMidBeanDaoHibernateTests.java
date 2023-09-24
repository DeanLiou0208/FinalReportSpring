package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductTypeMidBeanDao;
import tw.ispan.eeit168.company.domain.ProductTypeMidBean;

@SpringBootTest
public class ProductTypeMidBeanDaoHibernateTests {

	@Autowired
	private ProductTypeMidBeanDao productTypeMidBeanDao;

	@Test
	public void testSelectAll() {
		List<ProductTypeMidBean> selects = productTypeMidBeanDao.select();
		System.out.println("selects=" + selects);
	}

}
