package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.ShoppingCartBean;

@Repository
public class ShoppingCartBeanDaoHibernate implements ShoppingCartBeanDao {
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<ShoppingCartBean> select(){
		return this.getSession().createQuery("from ShoppingCartBean", ShoppingCartBean.class).list();
	}
}
