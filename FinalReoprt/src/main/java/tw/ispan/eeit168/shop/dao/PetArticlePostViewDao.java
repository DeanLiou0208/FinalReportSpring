package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.PetArticlePostView;

public interface PetArticlePostViewDao {
	public abstract List<PetArticlePostView> select();
	
	public abstract PetArticlePostView selectById(Integer id);
}
