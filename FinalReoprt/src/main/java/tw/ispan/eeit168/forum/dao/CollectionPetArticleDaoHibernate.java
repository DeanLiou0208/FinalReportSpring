package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CollectionPetArticleView;

@Repository
public class CollectionPetArticleDaoHibernate implements CollectionPetArticleDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<CollectionPetArticleView> select() {
		return this.getSession().createQuery
				("From CollectionPetArticleView", CollectionPetArticleView.class).list();
	}

}
