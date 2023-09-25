package tw.ispan.eeit168.shop.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.shop.domain.ArticleLikesBean;

@Repository
public class ArticleLikesBeanDaoHibernate implements ArticleLikesBeanDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession(){
		return session;
	}
	
	@Override
	public List<ArticleLikesBean> select(){
		 return this.getSession().createQuery("from ArticleLikesBean", ArticleLikesBean.class).list();
	}
}
