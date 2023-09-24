package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ShopProductViewDao;
import tw.ispan.eeit168.company.domain.ShopProductView;

@SpringBootTest
public class ShopProductViewDaoHibernateTests {

	@Autowired
	private ShopProductViewDao shopProductViewDao;

	@Test
	public void testSelectAll() {
		List<ShopProductView> selects = shopProductViewDao.select();
		System.out.println("selects=" + selects);
	}

}
