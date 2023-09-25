package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.MyShopView;

@Repository
public class MyShopViewDaoHibernate implements MyShopViewDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	@Override
	public List<MyShopView> select(){
		return this.getSession().createQuery("from MyShopView", MyShopView.class).list();
	}
	

}
