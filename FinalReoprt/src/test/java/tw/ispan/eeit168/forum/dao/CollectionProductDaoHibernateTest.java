package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.member.dao.CollectionProductDao;
import tw.ispan.eeit168.member.domain.CollectionProductView;

@SpringBootTest
public class CollectionProductDaoHibernateTest {
	@Autowired
	private CollectionProductDao collectionProductDao;
	@Test
	public void testSelect() {
		List<CollectionProductView> selects = collectionProductDao.select();
		System.out.println("selects="+selects);
	}

}
