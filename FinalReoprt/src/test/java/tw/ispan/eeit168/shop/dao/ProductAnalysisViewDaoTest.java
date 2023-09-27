package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.ProductAnalysisView;

@SpringBootTest
public class ProductAnalysisViewDaoTest {

	@Autowired
	private ProductAnalysisViewDao productAnalysisViewDao;
	
	@Test
	public void select() {
		List<ProductAnalysisView> select = productAnalysisViewDao.select();
		System.out.println(select);
	}
	
	@Test
	public void selectByShopName() {
		List<ProductAnalysisView> selectByShopName = productAnalysisViewDao.selectByShopName("劉學長的店");
		System.out.println(selectByShopName);
	}
	
}
