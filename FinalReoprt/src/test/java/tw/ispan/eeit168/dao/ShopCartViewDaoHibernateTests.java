package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ShopCartViewDao;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ShopCartView;

@SpringBootTest
public class ShopCartViewDaoHibernateTests {

	@Autowired
	private ShopCartViewDao shopCartViewDao;

	//@Test
	public void testSelectAll() {
		List<ShopCartView> selects = shopCartViewDao.select();
		System.out.println("selects=" + selects);
	}

	@Test
	public void testSelect() {
		ShopCartView select = shopCartViewDao.select(10);
		System.out.println("select=" + select);
	}
}
