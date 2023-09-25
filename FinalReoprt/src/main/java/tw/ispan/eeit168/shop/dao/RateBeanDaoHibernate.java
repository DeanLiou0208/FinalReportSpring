package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.RateBean;

@Repository
public class RateBeanDaoHibernate implements RateBeanDao{
	
	@PersistenceContext
	private Session session; 
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<RateBean> select(){
		return this.getSession().createQuery("from RateBean", RateBean.class).list();
		
	}
}
