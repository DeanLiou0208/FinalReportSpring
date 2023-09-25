package tw.ispan.eeit168.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.company.dao.ProductPhotoBeanDao;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductPhotoBean;

@SpringBootTest
public class ProductPhotoBeanDaoHibernateTests {

	@Autowired
	private ProductPhotoBeanDao productPhotoBeanDao;

	//@Test
	public void testSelectAll() {
		List<ProductPhotoBean> selects = productPhotoBeanDao.select();
		System.out.println("selects=" + selects);
	}

//	@Test
		public void testInsert() {
			
//			 Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ProductPhotoBean insert = new ProductPhotoBean();
			insert.setFkProductId(4);
			insert.setImg("img.....");
			
			
//			insert.setCreateAt(currentTimestamp);
//			insert.setUpdateAt(currentTimestamp);
			ProductPhotoBean result = productPhotoBeanDao.insert(insert);
			System.out.println("insert="+result);
			List<ProductPhotoBean> selects = productPhotoBeanDao.select();
			System.out.println("selects=" + selects);
		}
		
		
//		@Test
		public void testUpdate() {
//			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			ProductPhotoBean update = new ProductPhotoBean();
			ProductPhotoBean a =productPhotoBeanDao.select(27);
			update.setId(a.getId());
			update.setFkProductId(a.getFkProductId());
			update.setImg("imgtest");
			update.setMain(true);
		
			productPhotoBeanDao.update(update);
			
		}
		
		//@Test
		public void testSelect() {
			ProductPhotoBean select = productPhotoBeanDao.select(10);
			System.out.println("select="+select);
		}
		
		//@Test
		public void testDelete() {
			boolean delete = productPhotoBeanDao.delete(27);
			System.out.println("delete="+delete);
		}
}
