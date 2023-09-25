package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.shop.domain.PetPhotoOrderView;

@SpringBootTest
public class PetPhotoOrderViewDaoTest {
	@Autowired
	private PetPhotoOrderViewDao petPhotoOrderViewDao;
	
	@Test
	public void select(){
		List<PetPhotoOrderView> select = petPhotoOrderViewDao.select();
		System.out.println(select);
	}
}
