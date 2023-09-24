package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductTypeBean;

@Repository
public class ProductTypeBeanDaoHibernate implements ProductTypeBeanDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductTypeBean> select() {
		return this.getSession().createQuery("from ProductTypeBean", ProductTypeBean.class).list();
	}

}
