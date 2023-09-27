package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import tw.ispan.eeit168.shop.domain.OrderDetailsBean;

@SpringBootTest
@Transactional
public class OrderDetailsBeanDaoTest {

	@Autowired
	private OrderDetailsBeanDao orderDetailsBeanDao;
	
	//@Test
	public void select() {
		List<OrderDetailsBean> select = orderDetailsBeanDao.select();
		System.out.println(select);
	
	}
	
	//@Test
	public void selectById() {
		OrderDetailsBean selectById = orderDetailsBeanDao.selectById(99);
		System.out.println(selectById);
	}


}
