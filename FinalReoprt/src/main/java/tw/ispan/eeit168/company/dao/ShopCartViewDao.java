package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ShopCartView;

public interface ShopCartViewDao {
	List<ShopCartView> select();
	ShopCartView select(Integer id);
}
