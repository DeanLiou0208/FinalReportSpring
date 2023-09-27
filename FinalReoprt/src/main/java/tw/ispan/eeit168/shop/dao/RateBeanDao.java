package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.RateBean;

public interface RateBeanDao {
	public List<RateBean> select();
	
	public RateBean selectById(Integer id);
	
	public RateBean insert(RateBean bean);
	
	public RateBean update(RateBean bean);
	
	public boolean delete(Integer id);
	
}
