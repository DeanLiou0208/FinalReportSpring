package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.ProductAnalysisView;

public interface ProductAnalysisViewDao {
	public List<ProductAnalysisView> select();
	
	public List<ProductAnalysisView> selectByShopName(String shopName);
}
