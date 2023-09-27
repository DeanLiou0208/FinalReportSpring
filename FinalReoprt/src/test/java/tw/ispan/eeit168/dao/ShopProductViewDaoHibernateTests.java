package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.shop.dao.ShopProductViewDao;
import tw.ispan.eeit168.shop.domain.ShopProductView;

@SpringBootTest
public class ShopProductViewDaoHibernateTests {

	@Autowired
	private ShopProductViewDao shopProductViewDao;

	// @Test
	public void testSelectAll() {
		List<ShopProductView> selects = shopProductViewDao.select();
		System.out.println("selects=" + selects);
	}

	@Test
	public void testSelect() {
		ShopProductView select = shopProductViewDao.select(10);
		System.out.println("select=" + select);
	}

}
