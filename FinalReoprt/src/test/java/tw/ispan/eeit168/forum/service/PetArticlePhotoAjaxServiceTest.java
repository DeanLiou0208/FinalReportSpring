package tw.ispan.eeit168.forum.service;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;

@SpringBootTest
public class PetArticlePhotoAjaxServiceTest {
	@Autowired
	private PetArticlePhotoAjaxService petArticlePhotoAjaxService;
	@Test
	public void testCreate() {
		JSONObject obj = new JSONObject()
				.put("fkPetArticleId", 8)
//				.put("main", null)
				.put("img","image/jpeg;base64;pap6");
		
		PetArticlePhotoBean create = petArticlePhotoAjaxService.create(obj.toString());
		System.out.println("create="+create);
	}
}
