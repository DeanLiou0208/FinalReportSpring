package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.MyShopView;

public interface MyShopViewDao {
	
	public abstract List<MyShopView> select();
	
	public abstract List<MyShopView> selectByShopName(String shopName);
}
