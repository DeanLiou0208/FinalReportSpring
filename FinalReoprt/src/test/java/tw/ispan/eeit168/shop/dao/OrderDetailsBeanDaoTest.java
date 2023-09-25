package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.OrderDetailsBean;

@SpringBootTest
public class OrderDetailsBeanDaoTest {

	@Autowired
	private OrderDetailsBeanDao orderDetailsBeanDao;
	
	@Test
	public void select() {
		List<OrderDetailsBean> select = orderDetailsBeanDao.select();
		System.out.println(select);
	
	}
}
