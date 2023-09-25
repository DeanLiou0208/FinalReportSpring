package tw.ispan.eeit168.forum.dao;

import java.util.List;
import tw.ispan.eeit168.forum.domain.CommentsLikesBean;

public interface CommentsLikesDao {
	public abstract List<CommentsLikesBean> select();
}
