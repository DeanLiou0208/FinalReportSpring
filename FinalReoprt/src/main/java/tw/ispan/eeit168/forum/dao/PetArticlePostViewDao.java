package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.json.JSONObject;

import tw.ispan.eeit168.forum.domain.PetArticlePostView;

public interface PetArticlePostViewDao {
	public abstract List<PetArticlePostView> select();
	
	public abstract PetArticlePostView selectById(Integer id);
	
	public abstract Long count (Integer memberId);
	
	public abstract List<PetArticlePostView> selectByMemberId(JSONObject obj);
}
