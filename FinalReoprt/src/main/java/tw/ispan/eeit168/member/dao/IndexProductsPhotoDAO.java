package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.IndexProductsPhotoView;

public interface IndexProductsPhotoDAO {

	public abstract IndexProductsPhotoView select(Integer id);
	
	public abstract List<IndexProductsPhotoView> select();
}
