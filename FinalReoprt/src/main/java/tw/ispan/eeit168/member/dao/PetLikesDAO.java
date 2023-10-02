package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.PetLikesBean;

public interface PetLikesDAO {
//	public abstract MemberBean select(Integer id);
	
	public abstract List<PetLikesBean> select();
	
	public abstract List<Integer> select(Integer fkMemberId);

	public abstract PetLikesBean insert(PetLikesBean bean);
	
	public abstract boolean delete(Integer fkMemberId, Integer fkPetId);
}
