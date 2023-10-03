package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.IndexProductsPhotoView;

public interface IndexProductsPhotoDAO {

	public abstract IndexProductsPhotoView select(Integer id);
	
	public abstract List<IndexProductsPhotoView> select();
	
	public abstract List<IndexProductsPhotoView> selectTopFive();
}
