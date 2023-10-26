package tw.ispan.eeit168.shop.controller;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.member.domain.MemberBean;
import tw.ispan.eeit168.shop.dao.ShoppingCartBeanDao;
import tw.ispan.eeit168.shop.domain.OrderDetailsBean;
import tw.ispan.eeit168.shop.domain.OrderListBean;
import tw.ispan.eeit168.shop.repository.OrderDetailsBeanDaoRepository;
import tw.ispan.eeit168.shop.repository.OrderListBeanRepostiory;

@RestController
@CrossOrigin
@RequestMapping(path = "/pet_web")
public class OrderDetailsController {

	@Autowired
	private OrderListBeanRepostiory orderListBeanRepostiory;

	@Autowired
	private OrderDetailsBeanDaoRepository orderDetailsBeanDaoRepository;

	@Autowired
	private ShoppingCartBeanDao shoppingCartBeanDao;
	
	@Autowired
	private MemberDAO memberDAO;

	@PostMapping(path = "/shoppingcart/payment")
	@Transactional
	public String createOrderList(@RequestBody String json) {
		System.out.println(json);//確認傳入格式無誤
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(json);

		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		Integer totalPrice = obj.isNull("totalPrice") ? null : obj.getInt("totalPrice");
//		Integer bonus = obj.isNull("bonus") ? null : obj.getInt("bonus");
		JSONArray productList = obj.isNull("productList") ? new JSONArray() : obj.getJSONArray("productList");
		
		Integer orderListId = null;
		if (fkMemberId != null && totalPrice != 0) {
				OrderListBean oListBean = new OrderListBean();
				oListBean.setFkMemberId(fkMemberId);
				oListBean.setTotalPrice(totalPrice);
				oListBean.setBonus(1);
				OrderListBean orderListsave = orderListBeanRepostiory.save(oListBean);
				System.out.println(orderListsave);
				if (orderListsave != null) {
					responseJson.put("message", "訂單建立成功");
					responseJson.put("success", true);
					orderListId = orderListsave.getId();
				}else {
				responseJson.put("message", "訂單建立失敗");
				responseJson.put("success", false);
				}
//			Integer orderListId = orderListBeanRepostiory.findOrderId(fkMemberId);
			System.out.println(orderListId);
			
			OrderDetailsBean orderDetailsBean = new OrderDetailsBean();
			if (productList.length() != 0 && !productList.isEmpty()) {
				for (int i = 0; productList.length() > i; i++) {
					JSONObject detailObject = productList.getJSONObject(i);
					Integer id = detailObject.getInt("id");
					Integer productId = detailObject.getInt("productId");
					Integer count = detailObject.getInt("count");
					String shopName = detailObject.getString("shopName");

					orderDetailsBean.setFkOrderId(orderListId);
					orderDetailsBean.setProductId(productId);
					orderDetailsBean.setQuantity(count);
					orderDetailsBean.setShopName(shopName);
					orderDetailsBean.setState("訂單已成立");
					orderDetailsBean.setStateChangeTime(new Timestamp(System.currentTimeMillis()));
					OrderDetailsBean detailSave = orderDetailsBeanDaoRepository.save(orderDetailsBean);
					if (detailSave != null) {
						shoppingCartBeanDao.delect(id);
					}
					
				}
			}
		}
		else {
		responseJson.put("message", "未選擇結帳資料");
		responseJson.put("success", false);
		}
		System.out.println(responseJson);
		return responseJson.toString();
	}
	
	@PostMapping(path="/paymentmember")
	public String showPayMember (@RequestBody String json) {
		JSONObject obj = new JSONObject(json);
		Integer id = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		MemberBean selectMember = memberDAO.select(id);
		
		String memberReturn = new Gson().toJson(selectMember);
		
		return memberReturn;
	}
	
	@PostMapping(path = "/paybycredit")
	public String creadieCard(@RequestBody String json) {
		System.out.println(1);
		JSONObject obj = new JSONObject(json);
		Integer totalPrice = obj.isNull("totalPrice") ? null : obj.getInt("totalPrice");
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		
		
		
		AllInOne allInOne = new AllInOne("");
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedDate = dateFormat.format(currentDate);
		
		Random random = new Random();
		
		System.out.println(2);
		
		 StringBuilder randomString = new StringBuilder();
	        for (int i = 0; i < 10; i++) {
	            int digit = random.nextInt(10); // 生成0到9之間的隨機數
	            randomString.append(digit);
	        }
	        String autoID = randomString.toString();
	        String cusId = fkMemberId.toString();
	        String payprice = totalPrice.toString();
		
		AioCheckOutALL check = new AioCheckOutALL();
		check.setMerchantTradeNo("10000000");
		System.out.println("10000000");
		check.setMerchantTradeDate(formattedDate);
		System.out.println(formattedDate);
		check.setTotalAmount(payprice);
		System.out.println(payprice);
		check.setTradeDesc("信用卡一次付清");
		check.setItemName("寵物飼集消費明細請見訂單=>");
		check.setReturnURL("http://localhost:5173/membershoppingcart");
		System.out.println(3);
		check.setClientBackURL("http://localhost:5173/membershoppingcart");
		System.out.println(4);
		check.setNeedExtraPaidInfo("N");
		System.out.println(5);
		
		String from = allInOne.aioCheckOut(check, null);
		System.out.println(from);
		
		return from;
	}
}
