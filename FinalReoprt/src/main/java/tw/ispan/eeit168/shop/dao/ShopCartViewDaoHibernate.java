package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.shop.domain.ShopCartView;

@Repository
public class ShopCartViewDaoHibernate implements ShopCartViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ShopCartView> select() {
		return this.getSession().createQuery("from ShopCartView", ShopCartView.class).list();
	}
	@Override
	public ShopCartView select(Integer id) {
		if (id != null) {
			return this.getSession().get(ShopCartView.class, id);
		}
		return null;
	}
	@Override
	public  List<ShopCartView> selectByFkmember(Integer id) {
		String hql = "FROM ShopCartView WHERE fkMemberId  = :id";
		if(id != null) {
			return this.getSession().createQuery(hql,ShopCartView.class).setParameter("id", id).list();
		}
		return null;
	}
}
