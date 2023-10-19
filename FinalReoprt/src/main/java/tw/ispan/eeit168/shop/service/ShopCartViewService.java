package tw.ispan.eeit168.shop.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import tw.ispan.eeit168.shop.dao.ShopCartViewDao;
import tw.ispan.eeit168.shop.domain.ShopCartView;

@Service
@Transactional(rollbackFor = {Exception.class} )
public class ShopCartViewService {
	
	@Autowired
	private ShopCartViewDao shopCartViewDao;
	
	
	public String findMemberCart(String json) {
		
		JSONObject obj= new JSONObject(json);
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		
		if(fkMemberId != null) {
			List<ShopCartView> cartList = shopCartViewDao.selectByFkmember(fkMemberId);
			String jsonList = new Gson().toJson(cartList);
			return jsonList;
		}
		
		return null;
	}
}
