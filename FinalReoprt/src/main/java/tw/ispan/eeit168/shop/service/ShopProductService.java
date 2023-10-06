package tw.ispan.eeit168.shop.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import tw.ispan.eeit168.shop.domain.ShopProductView;
import tw.ispan.eeit168.shop.repository.ShopProductViewRepository;



@Service
@Transactional(rollbackFor = { Exception.class })
public class ShopProductService {
	
	@Autowired
	private ShopProductViewRepository shopProductViewRepository;
	
	public String findAll() {
		
		List<ShopProductView> findAll = shopProductViewRepository.findAll();
		String json = new Gson().toJson(findAll);
		return json;
	}
	
	public List<ShopProductView> find(String json) {
		
		try {
			JSONObject obj = new JSONObject(json);
			//傳入字串 將字串轉為jsonObject物件
			List<ShopProductView> find = shopProductViewRepository.find(obj);
//			String resultJson = new Gson().toJson(find);
			return find;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return null;
	}
	
	public long count (String json) {
		
		try {
			JSONObject obj = new JSONObject(json);
			return shopProductViewRepository.count(obj);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
