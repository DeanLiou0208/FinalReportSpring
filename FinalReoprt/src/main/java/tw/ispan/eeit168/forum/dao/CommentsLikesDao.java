package tw.ispan.eeit168.forum.dao;

import java.util.List;
import tw.ispan.eeit168.forum.domain.CommentsLikesBean;

public interface CommentsLikesDao {
	public abstract List<CommentsLikesBean> select();
	
	public abstract List<CommentsLikesBean> select(Integer fkMemberId);
	
	public abstract CommentsLikesBean insert(CommentsLikesBean bean);
	
	public abstract boolean delete(Integer fkMemberId, Integer fkCommentId);
	
	
}
