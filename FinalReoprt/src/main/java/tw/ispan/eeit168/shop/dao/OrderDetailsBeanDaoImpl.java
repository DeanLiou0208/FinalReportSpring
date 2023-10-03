package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.OrderDetailsBean;

@Repository
public class OrderDetailsBeanDaoImpl implements OrderDetailsBeanDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<OrderDetailsBean> select(){
		return this.getSession().createQuery("from OrderDetailsBean", OrderDetailsBean.class).list();
	}
	@Override
	public OrderDetailsBean selectById(Integer id) {
		if(id != null) {
			return this.getSession().get(OrderDetailsBean.class, id);
		}
		return null;
	}
 
}
