package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.ShoppingCartBean;


public interface ShoppingCartBeanDao {
	
	public abstract List<ShoppingCartBean> select();
	
	public abstract ShoppingCartBean selectById(Integer id);
	
	public abstract ShoppingCartBean insert(ShoppingCartBean bean);
	
	public abstract boolean delect(Integer id);
	
	public abstract ShoppingCartBean update(ShoppingCartBean bean);
	
	
}
