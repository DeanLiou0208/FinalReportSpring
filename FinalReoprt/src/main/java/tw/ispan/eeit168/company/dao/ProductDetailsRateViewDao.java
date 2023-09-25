package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductDetailsRateView;

public interface ProductDetailsRateViewDao {
	List<ProductDetailsRateView> select();
	ProductDetailsRateView select(Integer id);
	
}
