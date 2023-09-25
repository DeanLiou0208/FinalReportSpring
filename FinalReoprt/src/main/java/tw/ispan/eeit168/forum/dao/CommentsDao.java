package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.CommentsBean;

public interface CommentsDao {
	
public abstract List<CommentsBean> select();
}
