package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.json.JSONObject;

import tw.ispan.eeit168.shop.domain.ShopProductView;

public interface ShopProductViewDao {
	public abstract List<ShopProductView> select();
	
	public abstract ShopProductView select(Integer id);
	
	public abstract List<ShopProductView> find(JSONObject obj);
	
	public abstract Long count(JSONObject obj);
	
}
