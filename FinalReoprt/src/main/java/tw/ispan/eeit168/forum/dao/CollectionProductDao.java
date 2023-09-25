package tw.ispan.eeit168.forum.dao;

import java.util.List;

import tw.ispan.eeit168.forum.domain.CollectionProductView;

public interface CollectionProductDao {

	public abstract List<CollectionProductView> select();
}
