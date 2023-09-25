package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.ShoppingCartBean;

public interface ShoppingCartBeanDao {
	
	public abstract List<ShoppingCartBean> select();
}
