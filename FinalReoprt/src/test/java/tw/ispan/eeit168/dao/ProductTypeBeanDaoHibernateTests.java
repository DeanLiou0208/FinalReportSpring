package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductTypeBeanDao;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductTypeBean;

@SpringBootTest
public class ProductTypeBeanDaoHibernateTests {

	@Autowired
	private ProductTypeBeanDao productTypeBeanDao;

	//@Test
	public void testSelectAll() {
		List<ProductTypeBean> selects = productTypeBeanDao.select();
		System.out.println("selects=" + selects);
	}
	//@Test
		public void testInsert() {
			
//			 Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ProductTypeBean insert = new ProductTypeBean();
			insert.setName("進口飼料");
			insert.setValue("波多黎各");
			
			
//			insert.setCreateAt(currentTimestamp);
//			insert.setUpdateAt(currentTimestamp);
			ProductTypeBean result = productTypeBeanDao.insert(insert);
			System.out.println("insert="+result);
			List<ProductTypeBean> selects = productTypeBeanDao.select();
			System.out.println("selects=" + selects);
		}
		
		
		//@Test
		public void testUpdate() {
//			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ProductTypeBean update = new ProductTypeBean();
			ProductTypeBean a =productTypeBeanDao.select(9);
			update.setId(a.getId());
			update.setName("飼料品質");
			update.setValue("普通");
			
			productTypeBeanDao.update(update);
			a=productTypeBeanDao.select(9);
			System.out.println("select="+a);
		}
		
		//@Test
		public void testSelect() {
			ProductTypeBean select = productTypeBeanDao.select(4);
			System.out.println("select="+select);
		}
		
		//@Test
		public void testDelete() {
			boolean delete = productTypeBeanDao.delete(9);
			System.out.println("delete="+delete);
		}
}
