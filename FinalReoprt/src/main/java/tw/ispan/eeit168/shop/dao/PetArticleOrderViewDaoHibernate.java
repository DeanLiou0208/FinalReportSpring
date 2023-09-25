package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.PetArticleOrderView;

@Repository
public class PetArticleOrderViewDaoHibernate implements PetArticleOrderViewDao {
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<PetArticleOrderView> select (){
		return this.getSession().createQuery("from PetArticleOrderView", PetArticleOrderView.class).list();
	}
}
