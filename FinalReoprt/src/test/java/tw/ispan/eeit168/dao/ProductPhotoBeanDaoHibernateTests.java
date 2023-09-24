package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductPhotoBeanDao;
import tw.ispan.eeit168.company.domain.ProductPhotoBean;

@SpringBootTest
public class ProductPhotoBeanDaoHibernateTests {

	@Autowired
	private ProductPhotoBeanDao productPhotoBeanDao;

	@Test
	public void testSelectAll() {
		List<ProductPhotoBean> selects = productPhotoBeanDao.select();
		System.out.println("selects=" + selects);
	}

}
