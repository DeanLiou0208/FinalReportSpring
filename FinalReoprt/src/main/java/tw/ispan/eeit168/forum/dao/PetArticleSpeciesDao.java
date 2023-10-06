package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.PetArticleSpeciesBean;

public interface PetArticleSpeciesDao {
	
	public abstract List<PetArticleSpeciesBean> selects();
	
//	public abstract PetArticleSpeciesBean selectBySpecies(String species);	
	
	public abstract PetArticleSpeciesBean select(Integer id);	

}
