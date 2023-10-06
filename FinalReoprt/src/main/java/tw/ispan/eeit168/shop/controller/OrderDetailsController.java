package tw.ispan.eeit168.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.ispan.eeit168.shop.service.OrderListService;

@Controller
@CrossOrigin
@RequestMapping(path ="/")
public class OrderDetailsController {

	@Autowired
	private OrderListService orderListService;
	
	@PostMapping(path = "/member/order")
	public void createOrderList(@RequestBody  String json) {
		orderListService.createOrderList(json);
	}
}
