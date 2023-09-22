package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductDetailsRateView;

@Repository
public class ProductDetailsRateViewHibernate implements ProductDetailsRateViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductDetailsRateView> select() {
		return this.getSession().createQuery("from ProductDetailsRateView", ProductDetailsRateView.class).list();
	}

}
