package tw.ispan.eeit168.member.dao;

import java.util.List;

import tw.ispan.eeit168.member.domain.PetPhotoBean;

public interface PetPhotoDAO {

	public abstract PetPhotoBean select(Integer id);
	
	public abstract List<PetPhotoBean> selectOnePet(Integer fkPetId);
	
	public abstract List<PetPhotoBean> select();

	public abstract PetPhotoBean insert(PetPhotoBean bean);
	
	public abstract PetPhotoBean update(PetPhotoBean bean);

	public abstract boolean delete(Integer id);
}
