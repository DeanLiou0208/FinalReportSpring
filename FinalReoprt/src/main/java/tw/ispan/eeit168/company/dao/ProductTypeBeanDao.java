package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductTypeBean;

public interface ProductTypeBeanDao {
	List<ProductTypeBean> select();
	ProductTypeBean select(Integer id);
	ProductTypeBean insert(ProductTypeBean bean);
	ProductTypeBean update(ProductTypeBean bean);
	boolean delete(Integer id);
}
