package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.PetBean;

public interface PetDAO {

	public abstract PetBean select(Integer id);
	
	public abstract List<PetBean> select();
}
