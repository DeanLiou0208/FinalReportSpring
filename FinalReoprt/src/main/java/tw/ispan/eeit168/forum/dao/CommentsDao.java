package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.CommentsBean;

public interface CommentsDao {
	
public abstract List<CommentsBean> select();

public abstract CommentsBean select(Integer id);

public abstract List<CommentsBean> selectByPetArticleId(Integer fkPetArticleId);

public abstract CommentsBean insert(CommentsBean bean);

public abstract CommentsBean update(CommentsBean bean);

public abstract boolean delete(Integer id);

public abstract boolean deleteByPetArticleId(Integer fkPetArticleId);
}
