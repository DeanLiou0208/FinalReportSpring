package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.ProductSelectTypeBean;

@Repository
public class ProductSelectTypeBeanDaoHibernate implements ProductSelectTypeBeanDao{
	
	@PersistenceContext
	private Session session; 
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<ProductSelectTypeBean> select(){
		return this.getSession().createQuery("from ProductSelectTypeBean", ProductSelectTypeBean.class).list();
	}
}
