package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.MyShopViewDao;
import tw.ispan.eeit168.company.domain.MyShopView;

@SpringBootTest
public class MyShopViewDaoTest {
	
	@Autowired
	private MyShopViewDao myShopViewDao;
	
	@Test
	public void select() {
		List<MyShopView> select = myShopViewDao.select();
		System.out.println(select);
	}
	
	@Test
	public void selectByShopName() {
		List<MyShopView> selectByShopName = myShopViewDao.selectByShopName("劉學長的店");
		System.out.println(selectByShopName);
	}

}
