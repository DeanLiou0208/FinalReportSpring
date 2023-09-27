package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import tw.ispan.eeit168.forum.domain.PetArticleSpeciesBean;
@Repository
@Transactional
public class PetArticleSpeciesDaoHibernate implements PetArticleSpeciesDao {
	
	 @PersistenceContext
		private Session session;

		public Session getSession() {
			return session;
		}

	@Override
	public List<PetArticleSpeciesBean> select() {
		return this.getSession().createQuery
				   ("From PetArticleSpeciesBean", PetArticleSpeciesBean.class).list();
	}
	
}
