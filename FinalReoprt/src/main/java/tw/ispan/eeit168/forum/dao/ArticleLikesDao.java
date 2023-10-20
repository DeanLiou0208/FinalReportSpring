package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.ArticleLikesBean;
import tw.ispan.eeit168.shop.util.DoublePrimaryKey;

public interface ArticleLikesDao {
	public abstract List<ArticleLikesBean> select();
	
	public abstract List<ArticleLikesBean> selectLikeByMemberId(Integer fkMemberId);
	
	public abstract List<ArticleLikesBean> selectLikeByFkPetArticleId(Integer fkPetArticleId);
	
	public abstract ArticleLikesBean insert(ArticleLikesBean bean);
	
	public abstract ArticleLikesBean update(ArticleLikesBean bean);
	
	public abstract List<Integer> petArticleLike(Integer fkMemberId);
	
	public abstract List<Integer> petArticleUnlike(Integer fkMemberId);
	
	public abstract Boolean delete(Integer fkPetArticleId);

}
