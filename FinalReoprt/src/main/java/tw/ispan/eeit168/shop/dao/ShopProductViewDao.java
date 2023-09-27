package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.shop.domain.ShopProductView;

public interface ShopProductViewDao {
	List<ShopProductView> select();
	ShopProductView select(Integer id);
}
