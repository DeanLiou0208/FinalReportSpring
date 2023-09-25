package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.company.domain.ShopCartView;

@Repository
public class ShopCartViewDaoHibernate implements ShopCartViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ShopCartView> select() {
		return this.getSession().createQuery("from ShopCartView", ShopCartView.class).list();
	}
	@Override
	public ShopCartView select(Integer id) {
		if (id != null) {
			return this.getSession().get(ShopCartView.class, id);
		}
		return null;
	}
}
