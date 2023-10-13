package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.PetCategroyBean;

public interface PetCategroyDAO {
	
	public abstract PetCategroyBean select(Integer id);
	
	public abstract List<PetCategroyBean> select();
	
	public abstract List<String> selectSpecies();
	
	public abstract List<String> selectBreed(String species);	
	
	public abstract PetCategroyBean insert(PetCategroyBean bean);

	public abstract PetCategroyBean update(PetCategroyBean bean);

	public abstract boolean delete(Integer id);
}
