package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.json.JSONObject;

import tw.ispan.eeit168.forum.domain.SpeciesViewsView;

public interface SpeciesViewsViewDao {
	
	public abstract List<SpeciesViewsView> select();
	
	public abstract List<Integer> selectBySpeciesIds(String fkPetArticleSpeciesId);
}
