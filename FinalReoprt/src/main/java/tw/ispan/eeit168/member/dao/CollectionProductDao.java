package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.CollectionProductView;

public interface CollectionProductDao {

	public abstract List<CollectionProductView> select();
}
