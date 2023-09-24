package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.SpeciesViewsView;

@Repository
public class SpeciesViewsViewDaoHibernate implements SpeciesViewsViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<SpeciesViewsView> select() {
		return this.getSession().createQuery("from SpeciesViewsView", SpeciesViewsView.class).list();
	}

}
