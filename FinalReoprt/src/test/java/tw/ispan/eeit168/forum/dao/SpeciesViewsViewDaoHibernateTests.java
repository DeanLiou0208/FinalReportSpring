package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.SpeciesViewsView;

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
		
		List<Integer> bySpeciesIds = speciesViewsViewDao.selectBySpeciesIds("1,3");
		for(Integer articleId : bySpeciesIds) {
			System.out.println("articleId="+articleId);
		
		}
		
	}
}
