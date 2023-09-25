package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductTypeMidBeanDao;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductTypeMidBean;

@SpringBootTest
public class ProductTypeMidBeanDaoHibernateTests {

	@Autowired
	private ProductTypeMidBeanDao productTypeMidBeanDao;

	//@Test
	public void testSelectAll() {
		List<ProductTypeMidBean> selects = productTypeMidBeanDao.select();
		System.out.println("selects=" + selects);
	}

//	@Test
		public void testInsert() {
			
//			 Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ProductTypeMidBean insert = new ProductTypeMidBean();
			insert.setFkProductId(1);
			insert.setFkTypeId(2);
			
			
//			insert.setCreateAt(currentTimestamp);
//			insert.setUpdateAt(currentTimestamp);
			ProductTypeMidBean result = productTypeMidBeanDao.insert(insert);
			System.out.println("insert="+result);
			List<ProductTypeMidBean> selects = productTypeMidBeanDao.select();
			System.out.println("selects=" + selects);
		}
		
		
	//	@Test
		public void testUpdate() {
//			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ProductTypeMidBean update = new ProductTypeMidBean();
			ProductTypeMidBean a =productTypeMidBeanDao.select(21);
			update.setId(a.getId());
			update.setFkProductId(4);
			update.setFkTypeId(2);
		
			productTypeMidBeanDao.update(update);
			
		}
		
		//@Test
		public void testSelect() {
			ProductTypeMidBean select = productTypeMidBeanDao.select(10);
			System.out.println("select="+select);
		}
		
		@Test
		public void testDelete() {
			boolean delete = productTypeMidBeanDao.delete(21);
			System.out.println("delete="+delete);
		}
}
