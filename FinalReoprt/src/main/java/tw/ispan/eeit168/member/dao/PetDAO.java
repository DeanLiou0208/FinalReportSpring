package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.PetBean;

public interface PetDAO {

	public abstract PetBean select(Integer id);
	
	public abstract List<PetBean> select();

	public abstract PetBean insert(PetBean bean);

	public abstract PetBean update(PetBean bean);

	public abstract boolean delete(Integer id);
	
	
}
