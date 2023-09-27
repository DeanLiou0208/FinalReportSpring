package tw.ispan.eeit168.company.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.company.domain.MyShopView;

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
	
	@Override
	public List<MyShopView> selectByShopName(String shopName){
		String hql = "from MyShopView where shopName = :shopName ";
		return this.getSession()
					.createQuery(hql, MyShopView.class)
					.setParameter("shopName", shopName)
					////第一個""是hql裡面的代稱 第二個是傳入參數的名稱
					.list();
	}

}
