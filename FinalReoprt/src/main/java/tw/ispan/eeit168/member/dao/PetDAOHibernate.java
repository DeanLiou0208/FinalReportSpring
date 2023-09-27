package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.PetBean;

@Repository
@Transactional
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

	@Override
	public PetBean insert(PetBean bean) {
		if(bean!=null && bean.getFkMemberId()!=null && bean.getName() != null && bean.getCategroyId() != null) {
				this.getSession().persist(bean);
				return bean;
		}
		return null;
	}
	
	@Override
	public PetBean update(PetBean bean) {
		if(bean!=null && bean.getId()!=null) {
			PetBean temp = this.getSession().get(PetBean.class, bean.getId());
			if(temp!=null) {
				return (PetBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			PetBean temp = this.getSession().get(PetBean.class, id);
			if(temp!=null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
	
}
