package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.ProductAnalysisView;

@Repository
public class ProductAnalysisViewDaoHibernate implements ProductAnalysisViewDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session; 
	}
	
	@Override
	public List<ProductAnalysisView> select(){
		return this.getSession().createQuery("from ProductAnalysisView", ProductAnalysisView.class).list();
	}
	
	@Override
	public List<ProductAnalysisView> selectByShopName(String shopName){
		String hql = "from ProductAnalysisView where shopName = :shopName";
		//hql的 where 後面是Bean 裡面的變數名稱 :shopName是傳入的參數名稱
		return this.getSession()
				.createQuery(hql,ProductAnalysisView.class )
				.setParameter("shopName",shopName)//setParameter的兩個變數為(hql裡面宣告的變數=傳入的參數)
				.list();			
	}
}
