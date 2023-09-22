package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.domain.ProductDetailsRateView;

@SpringBootTest
public class ProductDetailsRateViewTests {

	@Autowired
	private ProductDetailsRateViewDao productDetailsRateViewDao;

	@Test
	public void testSelectAll() {
		List<ProductDetailsRateView> selects = productDetailsRateViewDao.select();
		System.out.println("selects=" + selects);
	}

}
