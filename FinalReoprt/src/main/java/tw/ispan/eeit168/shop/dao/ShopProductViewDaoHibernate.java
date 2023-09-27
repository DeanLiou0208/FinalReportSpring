package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.shop.domain.ShopProductView;

@Repository
public class ShopProductViewDaoHibernate implements ShopProductViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ShopProductView> select() {
		return this.getSession().createQuery("from ShopProductView", ShopProductView.class).list();
	}
	@Override
	public ShopProductView select(Integer id) {
		if (id != null) {
			return this.getSession().get(ShopProductView.class, id);
		}
		return null;
	}
}
