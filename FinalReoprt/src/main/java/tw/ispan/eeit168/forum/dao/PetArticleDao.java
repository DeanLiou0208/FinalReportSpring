package tw.ispan.eeit168.forum.dao;

import java.util.List;


import tw.ispan.eeit168.forum.domain.PetArticleBean;

public interface PetArticleDao {
	public abstract List<PetArticleBean> select();
	
	public abstract PetArticleBean select(Integer id);
	
	public abstract List<PetArticleBean> selectByMemberId(Integer memberId);
	
	public abstract List<PetArticleBean> orderByTime();
	
	public abstract PetArticleBean insert(PetArticleBean bean);

	public abstract PetArticleBean update(PetArticleBean bean);

	public abstract boolean delete(Integer id);
	


}
