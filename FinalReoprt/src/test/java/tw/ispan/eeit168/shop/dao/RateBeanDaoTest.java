package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import tw.ispan.eeit168.shop.domain.RateBean;

@SpringBootTest
@Transactional
public class RateBeanDaoTest {

	@Autowired
	private RateBeanDao rateBeanDao;
	
	//@Test
	public void select() {
		List<RateBean> select = rateBeanDao.select();
		System.out.println(select);
		
	}
	//@Test
	public void selectById() {
		RateBean selectById = rateBeanDao.selectById(1);
		System.out.println(selectById);
	}
	//@Test
	public void insert() {
		RateBean insert = new  RateBean();
		insert.setFkMemberId(1);
		insert.setFkProductId(2);
		insert.setFkOrderId(10016);
		insert.setRateComment("XXXXX");
		insert.setRateScore(4);
		
		RateBean result = rateBeanDao.insert(insert);
		System.out.println(result);
	}
	
	//@Test
	public void update() {
		RateBean update = new RateBean();
		update.setId(3);
		update.setFkMemberId(2);
		update.setFkProductId(3);
		update.setFkOrderId(10003);
		update.setRateComment("XXXX");
		update.setRateScore(3);
		
		RateBean result = rateBeanDao.update(update);
		System.out.println(result);
	}
	
	//@Test
	public void delete() {
		boolean delete = rateBeanDao.delete(66);
		System.out.println(delete);
	}
	
	
}
