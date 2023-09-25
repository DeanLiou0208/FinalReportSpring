package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;

@Repository
public class CommentsPhotoDaoHibernate implements CommentsPhotoDao {
	
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<CommentsPhotoBean> select() {
		
		return this.getSession().createQuery("From CommentsPhotoBean", CommentsPhotoBean.class).list();
	}

}
