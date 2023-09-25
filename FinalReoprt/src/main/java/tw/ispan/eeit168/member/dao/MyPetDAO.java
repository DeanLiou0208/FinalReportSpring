package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.MyPetView;

public interface MyPetDAO {

	public abstract MyPetView select(Integer id);
	
	public abstract List<MyPetView> select();
}
