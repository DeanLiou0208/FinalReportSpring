package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductDetailsViewDao;
import tw.ispan.eeit168.company.domain.ProductDetailsView;

@SpringBootTest
public class ProductDetailsViewDaoHibernateTests {

	@Autowired
	private ProductDetailsViewDao productDetailsViewDao;

	@Test
	public void testSelectAll() {
		List<ProductDetailsView> selects = productDetailsViewDao.select();
		System.out.println("selects=" + selects);
	}

}
