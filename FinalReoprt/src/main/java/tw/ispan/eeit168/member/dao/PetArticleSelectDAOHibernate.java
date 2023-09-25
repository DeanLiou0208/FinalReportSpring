package tw.ispan.eeit168.member.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.member.domain.PetArticleSelectBean;

@Repository
public class PetArticleSelectDAOHibernate implements PetArticleSelectDAO{
	@PersistenceContext
	private Session session;
	
	private Session getSession() {
		return session;
	}
	
	@Override
	public PetArticleSelectBean select(Integer id) {
		if(id != null) {
			return this.getSession().get(PetArticleSelectBean.class, id);
		}
		return null;
	}
	
	@Override
	public List<PetArticleSelectBean> select() {
		return this.getSession().createQuery(
				"from PetArticleSelectBean", PetArticleSelectBean.class).list();
	}
	
}
