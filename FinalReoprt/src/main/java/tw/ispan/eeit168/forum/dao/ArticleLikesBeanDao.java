package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.ArticleLikesBean;
import tw.ispan.eeit168.shop.util.DoublePrimaryKey;

public interface ArticleLikesBeanDao {
	public abstract List<ArticleLikesBean> select();
	
	public abstract List<ArticleLikesBean> selectLikeByMemberId(Integer id);
	
	public abstract List<ArticleLikesBean> selectLikeByFkPetArticleId(Integer id);
	
	public abstract ArticleLikesBean insert(ArticleLikesBean bean);
	
	public abstract ArticleLikesBean update(ArticleLikesBean bean);
	
	public abstract boolean delete(DoublePrimaryKey bean);
}
