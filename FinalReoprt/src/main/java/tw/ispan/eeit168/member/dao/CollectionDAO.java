package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.CollectionBean;

public interface CollectionDAO {
	public abstract CollectionBean select(Integer fkMemberId,String fkUid);
	
	public abstract List<CollectionBean> select();
	
	public abstract CollectionBean insert(CollectionBean bean);

	public abstract boolean delete(Integer id, String uid);
}
