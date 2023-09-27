package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.PetArticleSelectBean;

public interface PetArticleSelectDAO {
	
	public abstract PetArticleSelectBean select(Integer id);

	public abstract List<PetArticleSelectBean> select();

	public abstract PetArticleSelectBean insert(PetArticleSelectBean bean);

	public abstract boolean delete(Integer id);
}
