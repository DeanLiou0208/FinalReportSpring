package tw.ispan.eeit168.shop.dao;

import java.util.List;

import tw.ispan.eeit168.shop.domain.PetArticleOrderView;

public interface PetArticleOrderViewDao {
	public abstract List<PetArticleOrderView> select();
	
	public abstract List<PetArticleOrderView> selectShrech(String srt);
}
