package tw.ispan.eeit168.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.shop.service.ProductSelectTypeService;

@RestController
@RequestMapping(path="/shop")
@CrossOrigin
public class ProductSelectTypeController {
	
	@Autowired
	private ProductSelectTypeService productSelectTypeService;
	
	@GetMapping(path ="/type")
	public String findAll() {
		
		String findAll = productSelectTypeService.findAll();
		
		
		return findAll;
	}
	
	
}
