package tw.ispan.eeit168.shop.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import tw.ispan.eeit168.shop.domain.OrderDetailsBean;
import tw.ispan.eeit168.shop.domain.OrderListBean;
import tw.ispan.eeit168.shop.domain.ShopCartView;
import tw.ispan.eeit168.shop.repository.OrderDetailsBeanDaoRepository;
import tw.ispan.eeit168.shop.repository.OrderListBeanRepostiory;

@Service
@Transactional(rollbackFor = {Exception.class})
public class OrderListService {
	
	@Autowired
	private OrderListBeanRepostiory orderListBeanRepostiory;
	
	@Autowired
	private OrderDetailsBeanDaoRepository orderDetailsBeanDaoRepository;
	
	public List<ShopCartView> createOrderList(String srt) {
		Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(srt, JsonObject.class);
        System.out.println(jsonObject);
        List<ShopCartView> shopCartList = new ArrayList<ShopCartView>();
        if (jsonObject.has("list") && jsonObject.get("list").isJsonArray()) {
            JsonArray jsonArray = jsonObject.getAsJsonArray("list");

            // 使用 TypeToken 將 JSON 數組轉換為 List<ShopCartView>
            shopCartList = gson.fromJson(jsonArray, new TypeToken<List<ShopCartView>>() {}.getType());
            System.out.println(shopCartList);
        }
        Iterator<ShopCartView> shopCarts = shopCartList.iterator();
//        orderDetailsBeanDaoRepository.saveAll(shopCarts);
//        下一步要製作 從ShopCartView裡面取出要的資料寫入orderDetailBean裡然後裝成List在做savall
        return Collections.emptyList(); // 返回空列表或處理其他錯誤情況
        
        
    }
}







//		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
//		Integer fkProductId = obj.isNull("fkProductId") ? null : obj.getInt("fkProductId");
//		Integer count = obj.isNull("count") ? null : obj.getInt("count");
//		Integer totalPrice = obj.isNull("totalPrice") ? null : obj.getInt("totalPrice");
//		Integer bonus = obj.isNull("bonus") ? null : obj.getInt("bonus");
//		String  state = obj.isNull("state") ? null : obj.getString("state");		

//		System.out.println(fkMemberId);
//		System.out.println(fkProductId);
//		System.out.println(count);
//		System.out.println(totalPrice);
//		System.out.println(bonus);
//		System.out.println(state);
		
		
		
		
	    
			
	
		
	
	

