package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.OrderListBean;

@SpringBootTest
public class OrderListBeanDaoTest {
	
	@Autowired
	private OrderListBeanDao orderListBeanDao;
	
	@Test
	public void select() {
		List<OrderListBean> select = orderListBeanDao.select();
		System.out.println(select);
	}
}
