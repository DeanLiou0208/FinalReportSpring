package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.ShoppingCartBean;

@SpringBootTest
public class ShoppingCartBeanDaoTest {
	
	@Autowired
	private ShoppingCartBeanDao shoppingCartBeanDao;
	
	@Test
	public void select() {
		List<ShoppingCartBean> select = shoppingCartBeanDao.select();
		System.out.println(select);
	}
	
}
