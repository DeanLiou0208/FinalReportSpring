package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.shop.dao.IndexProductsPhotoDAO;
import tw.ispan.eeit168.shop.domain.IndexProductsPhotoView;

@SpringBootTest
@Transactional
public class IndexProductsPhotoDAOHibernateTest {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private IndexProductsPhotoDAO indexProductsPhotoDAO;
	
	@Test
	public void testSelect() {
		IndexProductsPhotoView select = indexProductsPhotoDAO.select(1);
		System.out.println("select first =" + select);
	}
	
	@Test
	public void testSelectAll() {
		List<IndexProductsPhotoView> selects = indexProductsPhotoDAO.select();
		System.out.println("selects="+selects);
	}
}
