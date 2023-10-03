package tw.ispan.eeit168.shop.dao;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import tw.ispan.eeit168.shop.domain.ShopProductView;
import tw.ispan.eeit168.shop.repository.ShopProductViewRepository;

@SpringBootTest
public class ShopProductViewDaoTests {

//	@Autowired
//	private ShopProductViewDao shopProductViewDao;
	@Autowired
	private ShopProductViewRepository shopProductViewRepository;
	
//	@Test
	public void testSelectAll() {
		List<ShopProductView> selects = shopProductViewRepository.select();
		System.out.println("selects=" + selects);
	}

//	@Test
	public void testSelect() {
		ShopProductView select = shopProductViewRepository.select(10);
		System.out.println("select=" + select);
	}
	
	@Test
	public void find() {
		JSONObject obj = new JSONObject()
		.put("name", "這是")
		.put("description", "這是")
		.put("maxPrice", 1000)
		.put("minPrice", 100)
		.put("start", 0)
		.put("rows", 5)
		.put("sort", "productId")
		.put("order", "asc");
		
		List<ShopProductView> finds = shopProductViewRepository.find(obj);
//		System.out.println(finds);
		
		for(ShopProductView bean :finds) {
			System.out.println("bean="+bean);
		}		
	}
	
	@Test
	public void count() {
		JSONObject obj = new JSONObject()
		.put("name", "這是");
		
		Long count = shopProductViewRepository.count(obj);
		System.out.println(count);
	}
}
