package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleBean;

@Repository
@Transactional
public class PetArticleDaoHibernate implements PetArticleDao {
	
	 @PersistenceContext
		private Session session;

		public Session getSession() {
			return session;
		}

	@Override
	public List<PetArticleBean> select() {
		
		return this.getSession().createQuery("From PetArticleBean", PetArticleBean.class).list();
	}
	@Override
	public PetArticleBean select(Integer id) {
		if(id != null) {
			return this.getSession().get(PetArticleBean.class, id);
		}
		return null;
	}
	@Override
	public PetArticleBean insert(PetArticleBean bean) {
		if(bean != null) {
			this.getSession().persist(bean);
			return bean;
		}
		return null;
	}
	@Override
	public PetArticleBean update(PetArticleBean bean) {
		if(bean != null && bean.getId()!= null) {
			 PetArticleBean temp = this.getSession().get(PetArticleBean.class, bean.getId());
			 if(temp!=null) {
				 return this.getSession().merge(bean); 
			 }
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id != null) {
			PetArticleBean temp = this.getSession().get(PetArticleBean.class,id);
			if(temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
