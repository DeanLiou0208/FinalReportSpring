package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.PetArticlePostView;

public interface PetArticlePostViewDao {
	public abstract List<PetArticlePostView> select();
	
	public abstract PetArticlePostView selectById(Integer id);
}
