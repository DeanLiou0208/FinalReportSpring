package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;

public interface PetArticlePhotoDao {
	public abstract List<PetArticlePhotoBean> select();
	
	public abstract PetArticlePhotoBean select(Integer id);
	
	public abstract List<PetArticlePhotoBean> selectByPetArticleId(Integer fkPetArticleId);
	
	public abstract PetArticlePhotoBean insert(PetArticlePhotoBean bean);
	
	public abstract PetArticlePhotoBean update(PetArticlePhotoBean bean);
	
	public abstract boolean delete(Integer id);
	

}
