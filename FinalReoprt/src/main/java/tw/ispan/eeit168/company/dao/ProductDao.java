package tw.ispan.eeit168.company.dao;

import java.util.List;


import tw.ispan.eeit168.company.domain.ProductBean;

public interface ProductDao {
	List<ProductBean> select();
	
	ProductBean select(Integer id);
	ProductBean insert(ProductBean bean);
	ProductBean update(ProductBean bean);
	boolean delete(Integer id);
}
