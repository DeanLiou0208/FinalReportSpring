package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.PetArticleOrderView;

public interface PetArticleOrderViewDao {
	public abstract List<PetArticleOrderView> select();
	
	public abstract List<PetArticleOrderView> selectShrech(String srt);
}
