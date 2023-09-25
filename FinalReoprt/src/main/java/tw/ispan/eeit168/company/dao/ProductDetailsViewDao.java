package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductDetailsView;

public interface ProductDetailsViewDao {
	List<ProductDetailsView> select();
	ProductDetailsView select(Integer id);
}
