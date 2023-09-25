package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CommentsLikePostView;

@Repository
public class CommentsLikePostDaoHibernate implements CommentsLikePostDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<CommentsLikePostView> select() {
		return this.getSession().createQuery
				("From CommentsLikePostView", CommentsLikePostView.class).list();
	}

}
