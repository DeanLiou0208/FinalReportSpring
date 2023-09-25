package tw.ispan.eeit168.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductDao;
import tw.ispan.eeit168.company.domain.CompanyBean;
import tw.ispan.eeit168.company.domain.ProductBean;

@SpringBootTest
public class ProductDaoHibernateTests {

	@Autowired
	private ProductDao productDao;

	//@Test
	public void testSelectAll() {
		List<ProductBean> selects = productDao.select();
		System.out.println("selects=" + selects);
	}

//	@Test
		public void testInsert() {
			
//			 Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ProductBean insert = new ProductBean();
			insert.setName("這是輸入商品");
			insert.setType("寵物用品");
			insert.setInventory(50);
			insert.setPrice(1000);
			
//			insert.setCreateAt(currentTimestamp);
//			insert.setUpdateAt(currentTimestamp);
			ProductBean result = productDao.insert(insert);
			System.out.println("insert="+result);
			List<ProductBean> selects = productDao.select();
			System.out.println("selects=" + selects);
		}
		
		
		//@Test
		public void testUpdate() {
//			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ProductBean update = new ProductBean();
			ProductBean a =productDao.select(11);
			update.setId(a.getId());
			update.setFkCompanyId(3);
			update.setName("商品%");
			update.setType(a.getType());
			update.setInventory(20);
			update.setPrice(320);
		
			productDao.update(update);
			
		}
		
		//@Test
		public void testSelect() {
			ProductBean select = productDao.select(10);
			System.out.println("select="+select);
		}
		
		//@Test
		public void testDelete() {
			boolean delete = productDao.delete(11);
			System.out.println("delete="+delete);
		}
}
