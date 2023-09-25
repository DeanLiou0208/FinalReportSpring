package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.PetArticleSelectBean;

public interface PetArticleSelectDAO {
	
	public abstract PetArticleSelectBean select(Integer id);

	public abstract List<PetArticleSelectBean> select();
}
