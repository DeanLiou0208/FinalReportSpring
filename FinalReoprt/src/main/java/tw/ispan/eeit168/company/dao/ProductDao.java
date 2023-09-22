package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;

public interface ProductDao {
	List<ProductBean> select();
}
