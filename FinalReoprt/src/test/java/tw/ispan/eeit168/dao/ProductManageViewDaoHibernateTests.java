package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductManageViewDao;
import tw.ispan.eeit168.company.domain.ProductManageView;

@SpringBootTest
public class ProductManageViewDaoHibernateTests {

	@Autowired
	private ProductManageViewDao productManageViewDao;

	@Test
	public void testSelectAll() {
		List<ProductManageView> selects = productManageViewDao.select();
		System.out.println("selects=" + selects);
	}

}
