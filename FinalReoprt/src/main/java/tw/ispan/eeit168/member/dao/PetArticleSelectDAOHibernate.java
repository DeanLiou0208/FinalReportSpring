package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.CollectionBean;
import tw.ispan.eeit168.member.domain.PetArticleSelectBean;

@Repository
@Transactional
public class PetArticleSelectDAOHibernate implements PetArticleSelectDAO{
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public PetArticleSelectBean select(Integer id) {
		if(id != null) {
			return this.getSession().get(PetArticleSelectBean.class, id);
		}
		return null;
	}
	
	@Override
	public List<PetArticleSelectBean> select() {
		return this.getSession().createQuery(
				"from PetArticleSelectBean", PetArticleSelectBean.class).list();
	}
	
	@Override
	public PetArticleSelectBean insert(PetArticleSelectBean bean) {
		if(bean!=null) {
				this.getSession().persist(bean);
				return bean;
		}
		return null;
	}
	
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			PetArticleSelectBean temp = this.getSession().get(PetArticleSelectBean.class, id);
			if(temp!=null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
	
}
