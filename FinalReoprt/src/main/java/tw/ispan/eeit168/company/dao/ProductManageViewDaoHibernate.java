package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductManageView;

@Repository
public class ProductManageViewDaoHibernate implements ProductManageViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductManageView> select() {
		return this.getSession().createQuery("from ProductManageView", ProductManageView.class).list();
	}

}
