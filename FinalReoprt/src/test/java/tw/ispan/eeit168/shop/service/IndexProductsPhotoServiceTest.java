package tw.ispan.eeit168.shop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class IndexProductsPhotoServiceTest {
	
	@Autowired	
	private IndexProductsPhotoService indexProductsPhotoViewService;
	
	@Test
	public void findTopfive() {
		String findTopfive = indexProductsPhotoViewService.findTopfive();
		System.out.println(findTopfive);
	}
	
}
