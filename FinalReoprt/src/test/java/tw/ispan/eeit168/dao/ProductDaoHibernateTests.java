package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductDao;
import tw.ispan.eeit168.company.domain.ProductBean;

@SpringBootTest
public class ProductDaoHibernateTests {

	@Autowired
	private ProductDao productDao;

	@Test
	public void testSelectAll() {
		List<ProductBean> selects = productDao.select();
		System.out.println("selects=" + selects);
	}

}
