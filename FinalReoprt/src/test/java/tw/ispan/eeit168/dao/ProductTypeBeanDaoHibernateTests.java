package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductTypeBeanDao;
import tw.ispan.eeit168.company.domain.ProductTypeBean;

@SpringBootTest
public class ProductTypeBeanDaoHibernateTests {

	@Autowired
	private ProductTypeBeanDao productTypeBeanDao;

	@Test
	public void testSelectAll() {
		List<ProductTypeBean> selects = productTypeBeanDao.select();
		System.out.println("selects=" + selects);
	}

}
