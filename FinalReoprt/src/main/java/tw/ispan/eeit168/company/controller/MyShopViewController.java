package tw.ispan.eeit168.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.company.domain.MyShopView;
import tw.ispan.eeit168.company.service.MyShopViewService;

@RestController
@RequestMapping(path = "/pet_web")
@CrossOrigin
public class MyShopViewController {
	@Autowired
	private MyShopViewService myShopViewService;

	@GetMapping(path = "/myshop")
	public List<MyShopView> myShopProduct(@RequestParam(name = "shopName") String shopName) {

		if (shopName != null && shopName.length() != 0) {
			List<MyShopView> myProduct = myShopViewService.myShopProduct(shopName);
			
			if (!myProduct.isEmpty() && myProduct.size() != 0) {
				return myProduct;
			} else {
				return null;
			}
		}
		return null;
	}
}
