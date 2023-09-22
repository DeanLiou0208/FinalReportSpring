package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.MyShopView;

@Repository
public class MyShopViewDao implements MyShopViewDaoInterface{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	public List<MyShopView> select(){
		return this.getSession().createQuery("from MyShopView", MyShopView.class).list();
	}

}
