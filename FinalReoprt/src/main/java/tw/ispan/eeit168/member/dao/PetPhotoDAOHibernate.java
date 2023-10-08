package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.PetPhotoBean;

@Repository
//@Transactional
public class PetPhotoDAOHibernate implements PetPhotoDAO {
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public PetPhotoBean select(Integer id) {
		if(id != null) {
			return this.getSession().get(PetPhotoBean.class, id);
		}
		return null;
	}

	@Override
	public List<PetPhotoBean> select() {
		return this.getSession().createQuery(
				"from PetPhotoBean", PetPhotoBean.class).list();
	}

	
	@Override
	public PetPhotoBean insert(PetPhotoBean bean) {
		if(bean!=null && bean.getImg() != null) {		
				this.getSession().persist(bean);
				return bean;
		}
		return null;
	}
	@Override
	public PetPhotoBean update(PetPhotoBean bean) {
		if(bean!=null && bean.getId()!=null && bean.getFkPetId() != null && bean.getImg() != null) {
			
			if(bean.getMain() == true) {
				final String collectionsql = "FROM PetPhotoBean WHERE fkPetId = :fkPetId AND main IS NOT NULL";
				Integer fkPetId = bean.getFkPetId();
				PetPhotoBean mainid = this.getSession().createQuery(collectionsql,PetPhotoBean.class)
					.setParameter("fkPetId", fkPetId)
					.uniqueResult();
				
				final String updatemain = "UPDATE PetPhotoBean SET main = NULL WHERE id = :id AND main IS NOT NULL";
				Integer xxx = mainid.getId();
				System.out.println(xxx);
				this.getSession().createQuery(updatemain)
					.setParameter("id", mainid.getId())
					.executeUpdate();	
//				System.out.println(executeUpdate);
			}
			
			PetPhotoBean temp = this.getSession().get(PetPhotoBean.class, bean.getId());
			if(temp!=null) {
				return (PetPhotoBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			PetPhotoBean temp = this.getSession().get(PetPhotoBean.class, id);
			if(temp!=null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
