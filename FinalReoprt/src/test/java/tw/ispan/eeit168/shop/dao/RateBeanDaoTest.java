package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.RateBean;

@SpringBootTest
public class RateBeanDaoTest {

	@Autowired
	private RateBeanDao rateBeanDao;
	
	@Test
	public void select() {
		List<RateBean> select = rateBeanDao.select();
		System.out.println(select);
		
	}
}
