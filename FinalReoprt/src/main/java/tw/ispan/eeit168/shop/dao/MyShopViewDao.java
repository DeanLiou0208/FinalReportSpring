package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.MyShopView;

public interface MyShopViewDao {
	
	public abstract List<MyShopView> select();
}
