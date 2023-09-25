package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.OrderDetailsBean;

@Repository
public class OrderDetailsBeanDaoHibernate implements OrderDetailsBeanDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<OrderDetailsBean> select(){
		return this.getSession().createQuery("from OrderDetailsBean", OrderDetailsBean.class).list();
	}
 
}
