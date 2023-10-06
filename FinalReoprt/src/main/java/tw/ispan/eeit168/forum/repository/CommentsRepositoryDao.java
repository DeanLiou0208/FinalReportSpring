package tw.ispan.eeit168.forum.repository;

import java.util.List;

import tw.ispan.eeit168.forum.domain.CommentsBean;

public interface CommentsRepositoryDao {
	
public abstract List<CommentsBean> select();

public abstract CommentsBean select(Integer id);

public abstract CommentsBean insert(CommentsBean bean);

public abstract CommentsBean update(CommentsBean bean);

public abstract boolean delete(Integer id);
}
