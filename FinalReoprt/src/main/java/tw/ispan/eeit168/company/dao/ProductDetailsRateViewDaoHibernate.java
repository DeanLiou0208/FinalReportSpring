package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ProductDetailsRateView;

@Repository
public class ProductDetailsRateViewDaoHibernate implements ProductDetailsRateViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductDetailsRateView> select() {
		return this.getSession().createQuery("from ProductDetailsRateView", ProductDetailsRateView.class).list();
	}

	@Override
	public ProductDetailsRateView select(Integer id) {
		if (id != null) {
			return this.getSession().get(ProductDetailsRateView.class, id);
		}
		return null;
	}
}
