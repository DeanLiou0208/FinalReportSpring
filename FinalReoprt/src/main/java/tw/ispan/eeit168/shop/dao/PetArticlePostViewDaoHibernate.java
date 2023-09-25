package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.PetArticlePostView;

@Repository
public class PetArticlePostViewDaoHibernate implements PetArticlePostViewDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	@Override
	public List<PetArticlePostView> select(){
		return this.getSession().createQuery("from PetArticlePostView", PetArticlePostView.class).list();
	}
}
