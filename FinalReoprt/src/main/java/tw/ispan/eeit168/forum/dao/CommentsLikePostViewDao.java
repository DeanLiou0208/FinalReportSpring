package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.json.JSONObject;

import tw.ispan.eeit168.forum.domain.CommentsLikePostView;

public interface CommentsLikePostViewDao {
	
	public abstract List<CommentsLikePostView> select();
	
	public abstract List<CommentsLikePostView> selectByPetArticleId(JSONObject obj);
	
	public abstract List<CommentsLikePostView> selectByPetArticleId(Integer fkPetArticleId);
}
