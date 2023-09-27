package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import tw.ispan.eeit168.shop.domain.ProductSelectTypeBean;

@SpringBootTest
@Transactional
public class ProductSelectTypeBeanDaoTset {
	
	@Autowired
	private ProductSelectTypeBeanDao productSelectTypeBeanDao;
	
	//@Test
	public void select() {
		List<ProductSelectTypeBean> select = productSelectTypeBeanDao.select();
		System.out.println(select);
	}
	
	//@Test
	public void selectById() {
		ProductSelectTypeBean selectById = productSelectTypeBeanDao.selectById(1);
		System.out.println(selectById );
	}
	
	@Test
	public void insert() {
		ProductSelectTypeBean insert = new ProductSelectTypeBean();
		insert.setType("清潔用品");
		
		ProductSelectTypeBean result = productSelectTypeBeanDao.insert(insert);
		System.out.println(result);
	}
	
	//@Test
	public void delete() {
		boolean delete = productSelectTypeBeanDao.delete(1);
		System.out.println(delete);
	}
}
