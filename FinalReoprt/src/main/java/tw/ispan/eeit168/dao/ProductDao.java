package tw.ispan.eeit168.dao;

import java.util.List;

import tw.ispan.eeit168.domain.ProductBean;

public interface ProductDao {
	List<ProductBean> select();
}
