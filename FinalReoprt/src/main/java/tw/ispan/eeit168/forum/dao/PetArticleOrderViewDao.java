package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.json.JSONObject;

import tw.ispan.eeit168.forum.domain.PetArticleOrderView;

public interface PetArticleOrderViewDao {
	public abstract List<PetArticleOrderView> select();
	
	public abstract List<PetArticleOrderView> selectShrech(String srt);
	
	public abstract Long count (List<Integer> petArticleIdRecord,JSONObject obj);
	
	public abstract List<PetArticleOrderView> find (List<Integer> speciesRecord,JSONObject obj);
	
	public abstract List<PetArticleOrderView> findByMemberId (JSONObject obj);
}
