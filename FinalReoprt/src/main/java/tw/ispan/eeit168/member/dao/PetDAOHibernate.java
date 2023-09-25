package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.PetBean;

@Repository
public class PetDAOHibernate implements PetDAO {
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public PetBean select(Integer id) {
		if(id != null) {
			return this.getSession().get(PetBean.class, id);
		}
		return null;
	}

	@Override
	public List<PetBean> select() {
		return this.getSession().createQuery(
				"from PetBean", PetBean.class).list();
	}

}
