package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.OrderListBean;
import tw.ispan.eeit168.shop.repository.OrderListBeanRepostiory;

@SpringBootTest
public class OrderListBeanDaoTest {
	
	@Autowired
	private OrderListBeanRepostiory orderListBeanRepostiory;
	
	@Test
	public void select() {
		List<OrderListBean> select = orderListBeanRepostiory.select();
		System.out.println(select);
	}
}
