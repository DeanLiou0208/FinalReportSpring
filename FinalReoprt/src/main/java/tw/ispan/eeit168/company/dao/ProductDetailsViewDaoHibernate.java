package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductDetailsView;

@Repository
public class ProductDetailsViewDaoHibernate implements ProductDetailsViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductDetailsView> select() {
		return this.getSession().createQuery("from ProductDetailsView", ProductDetailsView.class).list();
	}

}
