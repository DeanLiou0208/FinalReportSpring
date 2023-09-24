package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductTypeMidBean;

@Repository
public class ProductTypeMidBeanDaoHibernate implements ProductTypeMidBeanDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductTypeMidBean> select() {
		return this.getSession().createQuery("from ProductTypeMidBean", ProductTypeMidBean.class).list();
	}

}
