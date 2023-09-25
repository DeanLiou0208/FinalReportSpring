package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.SpeciesViewsViewDao;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.SpeciesViewsView;

@SpringBootTest
public class SpeciesViewsViewDaoHibernateTests {

	@Autowired
	private SpeciesViewsViewDao speciesViewsViewDao;

	//@Test
	public void testSelectAll() {
		List<SpeciesViewsView> selects = speciesViewsViewDao.select();
		System.out.println("selects=" + selects);
	}
	@Test
	public void testSelect() {
		SpeciesViewsView select = speciesViewsViewDao.select(10);
		System.out.println("select="+select);
	}
}
