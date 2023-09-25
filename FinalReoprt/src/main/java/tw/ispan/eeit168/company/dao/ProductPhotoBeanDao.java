package tw.ispan.eeit168.company.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductPhotoBean;

public interface ProductPhotoBeanDao {
	List<ProductPhotoBean> select();
	ProductPhotoBean select(Integer id);
	ProductPhotoBean insert(ProductPhotoBean bean);
	ProductPhotoBean update(ProductPhotoBean bean);
	boolean delete(Integer id);
}
