package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.PetPhotoBean;

@Repository
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

}
