package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.OrderListBean;

@Repository
public class OrderListBeanDaoImpl implements OrderListBeanDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<OrderListBean> select(){
		return this.getSession().createQuery("from OrderListBean", OrderListBean.class).list();
	}
}
