package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.PetArticleSpeciesMidBean;

public interface PetArticleSpeciesMidDao {
	
	public abstract List<PetArticleSpeciesMidBean> select();
	
	public abstract List<PetArticleSpeciesMidBean> select(Integer fkPetArticleId);
	
	public abstract PetArticleSpeciesMidBean insert(PetArticleSpeciesMidBean bean);
	
	public abstract PetArticleSpeciesMidBean update(PetArticleSpeciesMidBean bean);
	
	public abstract boolean delete(Integer id);

}
