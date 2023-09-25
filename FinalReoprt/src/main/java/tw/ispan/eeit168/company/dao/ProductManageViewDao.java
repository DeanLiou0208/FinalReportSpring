package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductManageView;

public interface ProductManageViewDao {
	List<ProductManageView> select();
	ProductManageView select(Integer id);
}
