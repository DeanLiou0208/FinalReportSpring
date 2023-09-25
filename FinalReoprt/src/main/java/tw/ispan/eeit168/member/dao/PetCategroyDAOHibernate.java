package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.PetCategroyBean;

@Repository
public class PetCategroyDAOHibernate implements PetCategroyDAO {
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public PetCategroyBean select(Integer id) {
		if(id != null) {
			return this.getSession().get(PetCategroyBean.class, id);
		}
		return null;
	}

	@Override
	public List<PetCategroyBean> select() {
		return this.getSession().createQuery(
				"from PetCategroyBean", PetCategroyBean.class).list();
	}

}
