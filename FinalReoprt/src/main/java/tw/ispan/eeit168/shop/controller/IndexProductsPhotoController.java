package tw.ispan.eeit168.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletContext;
import tw.ispan.eeit168.shop.service.IndexProductsPhotoService;

@RestController
@RequestMapping(path="/")
@CrossOrigin
public class IndexProductsPhotoController {
	
	@Autowired
	private IndexProductsPhotoService indexProductsPhotoViewService;
	
//	@Autowired
//	private ServletContext servletContext;
	
	@PostMapping(path="/index/productphoto")
	public String findTopfive(@RequestBody String json) {
		String findTopfive = indexProductsPhotoViewService.findTopfive();
		
//		BodyBuilder response = ResponseEntity.ok();
//		BodyBuilder contentType = response.contentType(MediaType.APPLICATION_JSON);
//		ResponseEntity<String> body = contentType.body(findTopfive);
		
		return findTopfive;
	}
}
