package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.OrderDetailsBean;

public interface OrderDetailsBeanDao {
	public abstract List<OrderDetailsBean> select();
}
