package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.OrderListBean;

public interface OrderListBeanDao {
	
	public abstract List<OrderListBean> select();
}
