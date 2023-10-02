package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.json.JSONObject;

import tw.ispan.eeit168.member.domain.PetPhotoOrderView;

public interface PetPhotoOrderViewDao {

	public abstract List<PetPhotoOrderView> select();
	
	public abstract PetPhotoOrderView selectById(Integer id);
	
	public abstract List<PetPhotoOrderView> selectByMemberLike(List<Integer> list);

	public abstract List<PetPhotoOrderView> find(List<Integer> list, JSONObject obj);
}
