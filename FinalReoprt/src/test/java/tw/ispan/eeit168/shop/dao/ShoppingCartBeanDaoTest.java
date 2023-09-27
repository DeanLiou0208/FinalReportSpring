package tw.ispan.eeit168.shop.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import tw.ispan.eeit168.shop.domain.ShoppingCartBean;

@SpringBootTest
@Transactional
public class ShoppingCartBeanDaoTest {
	
	@Autowired
	private ShoppingCartBeanDao shoppingCartBeanDao;
	
	//@Test
	public void select() {
		List<ShoppingCartBean> select = shoppingCartBeanDao.select();
		System.out.println(select);
	}
	//@Test
	public void selectById() {
		ShoppingCartBean selectById = shoppingCartBeanDao.selectById(1);
		System.out.println(selectById);
	}
	
	//@Test
	public void insert() {
		ShoppingCartBean insert = new ShoppingCartBean();
		
		insert.setFkMemberId(5);
		insert.setFkProductId(3);
		insert.setCount(2);
		
		ShoppingCartBean result = shoppingCartBeanDao.insert(insert);
		System.out.println(result);
	}
	
	//@Test
	public void delect() {
		boolean result = shoppingCartBeanDao.delect(25);
		System.out.println(result);
	}
	
	@Test
	public void update() {
		ShoppingCartBean update = new ShoppingCartBean();
		update.setId(28);
		update.setFkMemberId(9);
		update.setFkProductId(2);
		update.setCount(2);
		
		
		ShoppingCartBean result = shoppingCartBeanDao.update(update);
		System.out.println(result);
	}
	
}
