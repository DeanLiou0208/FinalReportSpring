package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.PetPhotoOrderView;

public interface PetPhotoOrderViewDao {

	public abstract List<PetPhotoOrderView> select();
	
	public abstract PetPhotoOrderView selectById(Integer id);
}
