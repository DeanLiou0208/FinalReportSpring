package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import tw.ispan.eeit168.shop.domain.OrderDetailsBean;
import tw.ispan.eeit168.shop.repository.OrderDetailsBeanDaoRepository;

@SpringBootTest
@Transactional
public class OrderDetailsBeanDaoTest {

	@Autowired
	private OrderDetailsBeanDaoRepository orderDetailsBeanDaoRepository;
	
	@Test
	public void select() {
		List<OrderDetailsBean> select = orderDetailsBeanDaoRepository.select();
		System.out.println(select);
	
	}
	
	//@Test
	public void selectById() {
		OrderDetailsBean selectById = orderDetailsBeanDaoRepository.selectById(99);
		System.out.println(selectById);
	}
	
	@Test
	public void findAll() {
		List<OrderDetailsBean> findAll = orderDetailsBeanDaoRepository.findAll();
		System.out.println(findAll);
	}
	
}
