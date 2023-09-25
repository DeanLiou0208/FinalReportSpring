package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;

@Repository
public class PetArticlePhotoDaoHibernate implements PetArticlePhotoDao {
	
	 @PersistenceContext
		private Session session;

		public Session getSession() {
			return session;
		}

	@Override
	public List<PetArticlePhotoBean> select() {
		
		return this.getSession().createQuery("From PetArticlePhotoBean", PetArticlePhotoBean.class).list();
	}

}
