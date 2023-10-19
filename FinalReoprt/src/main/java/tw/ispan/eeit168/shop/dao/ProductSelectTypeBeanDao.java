package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.ProductAnalysisView;
import tw.ispan.eeit168.shop.domain.ProductSelectTypeBean;

public interface ProductSelectTypeBeanDao {
	
	public abstract List<ProductSelectTypeBean> select();
	
	public abstract ProductSelectTypeBean selectById(Integer id);
	
	public abstract ProductSelectTypeBean insert(ProductSelectTypeBean bean);
	
	public abstract boolean delete(Integer id);
	
	
}
