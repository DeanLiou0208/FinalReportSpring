package tw.ispan.eeit168.forum.dao;

import java.util.List;
import tw.ispan.eeit168.forum.domain.CommentsLikesBean;

public interface CommentsLikesDao {
	public abstract List<CommentsLikesBean> select();
	
	public abstract List<CommentsLikesBean> select(Integer fkMemberId);
	
	public abstract List<CommentsLikesBean> selectByCommentId(Integer fkCommentId);
	
	public abstract CommentsLikesBean insert(CommentsLikesBean bean);
	
	public abstract boolean delete(Integer fkCommentId);
	
	public abstract boolean deleteLike (Integer fkCommentId,Integer fkMemberId);
	
	public abstract List<Integer> commentLike(Integer fkMemberId);
	
	public abstract List<Integer> commentUnlike(Integer fkMemberId);
	
	
}
