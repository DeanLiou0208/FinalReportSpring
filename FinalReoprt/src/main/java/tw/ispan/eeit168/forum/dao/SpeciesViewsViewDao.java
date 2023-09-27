package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.forum.domain.SpeciesViewsView;

public interface SpeciesViewsViewDao {
	List<SpeciesViewsView> select();
	SpeciesViewsView select(Integer id);
}
