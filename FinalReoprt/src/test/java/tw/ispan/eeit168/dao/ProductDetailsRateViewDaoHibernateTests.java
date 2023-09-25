package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductDetailsRateViewDao;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductDetailsRateView;

@SpringBootTest
public class ProductDetailsRateViewDaoHibernateTests {

	@Autowired
	private ProductDetailsRateViewDao productDetailsRateViewDao;

	//@Test
	public void testSelectAll() {
		List<ProductDetailsRateView> selects = productDetailsRateViewDao.select();
		System.out.println("selects=" + selects);
	}
	@Test
			public void testSelect() {
				ProductDetailsRateView select = productDetailsRateViewDao.select(1);
				System.out.println("select="+select);
			}
}
