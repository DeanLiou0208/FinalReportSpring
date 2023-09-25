package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.CommentsLikePostView;

public interface CommentsLikePostDao {
	
	public abstract List<CommentsLikePostView> select();

}
