package tw.ispan.eeit168.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.domain.ProductBean;

@Repository
public class ProductDaoHibernate implements ProductDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductBean> select() {
		return this.getSession().createQuery("from ProductBean", ProductBean.class).list();
	}

}
