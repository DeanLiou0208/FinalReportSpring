package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.MyShopView;

@SpringBootTest
public class MyShopViewDaoTest {
	
	@Autowired
	private MyShopViewDao myShopViewDaoInterface;
	
	@Test
	public void Select() {
		List<MyShopView> select = myShopViewDaoInterface.select();
		System.out.println(select);
	}

}
