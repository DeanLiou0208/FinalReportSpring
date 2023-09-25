package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductTypeMidBean;

public interface ProductTypeMidBeanDao {
	List<ProductTypeMidBean> select();
	ProductTypeMidBean select(Integer id);
	ProductTypeMidBean insert(ProductTypeMidBean bean);
	ProductTypeMidBean update(ProductTypeMidBean bean);
	boolean delete(Integer id);
}
