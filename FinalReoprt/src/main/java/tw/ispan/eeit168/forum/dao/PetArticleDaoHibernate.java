package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleBean;

@Repository
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

}
