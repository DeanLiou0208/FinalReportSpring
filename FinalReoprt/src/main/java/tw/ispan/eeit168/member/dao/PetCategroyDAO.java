package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.PetCategroyBean;

public interface PetCategroyDAO {
	
	public abstract PetCategroyBean select(Integer id);
	
	public abstract List<PetCategroyBean> select();
}
