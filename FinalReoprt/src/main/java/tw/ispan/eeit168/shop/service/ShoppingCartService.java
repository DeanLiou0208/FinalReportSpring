package tw.ispan.eeit168.shop.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.shop.dao.ShoppingCartBeanDao;
import tw.ispan.eeit168.shop.domain.ShoppingCartBean;

@Service
@Transactional(rollbackFor = {Exception.class})
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartBeanDao shoppingCartBeanDao;
	
	public boolean exists(Integer id) {
		return shoppingCartBeanDao.selectById(id) != null;
	}
	
	
	public ShoppingCartBean addShoppingCart(String json) {
		try {
		JSONObject obj = new JSONObject(json);
		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		Integer fkProductId = obj.isNull("fkProductId") ? null : obj.getInt("fkProductId");
//		Integer count = obj.isNull("count") ? null : obj.getInt("count");
		
		if(fkMemberId != null && fkProductId != null) {
		ShoppingCartBean insert = new ShoppingCartBean();
		insert.setFkMemberId(fkMemberId);
		insert.setFkProductId(fkProductId);
		insert.setCount(1);
		
		return shoppingCartBeanDao.insert(insert);
		}
		}catch(Throwable e){
			e.printStackTrace();
		}
		return null;
	}

}

