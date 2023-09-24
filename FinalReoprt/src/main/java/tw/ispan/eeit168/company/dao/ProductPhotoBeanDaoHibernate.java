package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductPhotoBean;

@Repository
public class ProductPhotoBeanDaoHibernate implements ProductPhotoBeanDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ProductPhotoBean> select() {
		return this.getSession().createQuery("from ProductPhotoBean", ProductPhotoBean.class).list();
	}

}
