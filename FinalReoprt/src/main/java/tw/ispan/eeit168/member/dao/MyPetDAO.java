package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.json.JSONObject;

import tw.ispan.eeit168.member.domain.MyPetView;
import tw.ispan.eeit168.member.domain.PetPhotoOrderView;

public interface MyPetDAO {

	public abstract MyPetView selectId(Integer id);
	
	public abstract List<MyPetView> select(Integer fkMemberId);

	public abstract List<MyPetView> select();
	
}
