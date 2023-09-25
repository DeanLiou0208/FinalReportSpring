package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CollectionProductView;

@Repository
public class CollectionProductDaoHibernate implements CollectionProductDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<CollectionProductView> select() {
		return this.getSession().createQuery
				("From CollectionProductView", CollectionProductView.class).list();
	}

}
