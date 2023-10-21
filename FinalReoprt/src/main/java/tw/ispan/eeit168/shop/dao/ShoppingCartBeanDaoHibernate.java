package tw.ispan.eeit168.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import tw.ispan.eeit168.shop.domain.ShoppingCartBean;

@Repository
//@Transactional
public class ShoppingCartBeanDaoHibernate implements ShoppingCartBeanDao {

	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<ShoppingCartBean> select() {
		return this.getSession().createQuery("from ShoppingCartBean", ShoppingCartBean.class).list();
	}
	@Override
	public ShoppingCartBean selectById(Integer id) {
		if (id != null) {
			return this.getSession().get(ShoppingCartBean.class, id);
		} else
			return null;
	}
	@Override
	public ShoppingCartBean insert (ShoppingCartBean bean) {
		if (bean != null) {
				this.getSession().persist(bean);
				return bean;
			}
		return null;
	}
	public boolean delect(Integer id) {
		if(id != null) {
			ShoppingCartBean temp = this.getSession().get(ShoppingCartBean.class, id);
			if(temp != null) {
				this.getSession().remove(temp);
				return true;
			}			
		}
		return false;
	}
	
	public ShoppingCartBean update(ShoppingCartBean bean) {
		if(bean != null && bean.getId() != null) {
			ShoppingCartBean temp = this.getSession().get(ShoppingCartBean.class, bean.getId());
			if(temp != null) {
				 return (ShoppingCartBean)this.getSession().merge(temp);
			}
		}
		return null;
	}
	
	
	public boolean CheckShoppingCartExit(Integer id, Integer ids) {
		String hql = "FROM shoppingCart WHERE fkMemberId = :id AND fkProductId = :ids;";
		List<ShoppingCartBean> arrayList = new ArrayList<ShoppingCartBean>();
		if(id != null && ids != null) {
					arrayList = 
					this.getSession()
					.createQuery(hql, ShoppingCartBean.class)
					.setParameter("id", id)
					.setParameter("ids", ids)
					.list();
			if(arrayList != null && !arrayList.isEmpty()) {
				return true; 
			}
			return false;
		}
		return false;
	}
	
	
}
