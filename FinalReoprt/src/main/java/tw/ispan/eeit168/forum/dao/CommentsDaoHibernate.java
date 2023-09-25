package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CommentsBean;

@Repository
public class CommentsDaoHibernate implements CommentsDao {
    @PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}
	@Override
	public List<CommentsBean> select(){
		
		return this.getSession().createQuery("From CommentsBean", CommentsBean.class).list();
	}
	
	
}
