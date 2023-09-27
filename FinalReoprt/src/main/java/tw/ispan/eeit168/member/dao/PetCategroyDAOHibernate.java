package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.PetCategroyBean;

@Repository
@Transactional
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

	@Override
	public PetCategroyBean insert(PetCategroyBean bean) {
		if(bean!=null && bean.getBreed() != null && bean.getSpecies() != null) {		
				this.getSession().persist(bean);
				return bean;
		}
		return null;
	}
	@Override
	public PetCategroyBean update(PetCategroyBean bean) {
		if(bean!=null && bean.getId()!=null && bean.getBreed() != null && bean.getSpecies() != null) {
			PetCategroyBean temp = this.getSession().get(PetCategroyBean.class, bean.getId());
			if(temp!=null) {
				return (PetCategroyBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			PetCategroyBean temp = this.getSession().get(PetCategroyBean.class, id);
			if(temp!=null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
}
