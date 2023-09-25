package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CommentsLikesBean;

@Repository
public class CommentsLikesDaoHibernate implements CommentsLikesDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}
	
	@Override
	public List<CommentsLikesBean> select() {
		Session session = this.getSession();
		Query<CommentsLikesBean> createQuery = session.createQuery("From CommentsLikesBean", CommentsLikesBean.class);
		List<CommentsLikesBean> list = createQuery.list();
		return list;
	}

}
