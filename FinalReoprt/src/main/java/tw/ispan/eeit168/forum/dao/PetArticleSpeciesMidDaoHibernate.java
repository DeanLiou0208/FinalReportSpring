package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleSpeciesMidBean;

@Repository
public class PetArticleSpeciesMidDaoHibernate implements PetArticleSpeciesMidDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<PetArticleSpeciesMidBean> select() {
		return this.getSession().createQuery
				("From PetArticleSpeciesMidBean", PetArticleSpeciesMidBean.class).list();
	}

}
