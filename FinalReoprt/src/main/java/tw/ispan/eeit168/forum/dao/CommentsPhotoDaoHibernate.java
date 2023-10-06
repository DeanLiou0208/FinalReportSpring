package tw.ispan.eeit168.forum.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;

@Repository
@Transactional
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
	@Override
	public CommentsPhotoBean selectById(Integer id) {
		
		return this.getSession().get(CommentsPhotoBean.class,id);
	}
	@Override
	public List<CommentsPhotoBean> select(Integer fkCommentsId) {
		if(fkCommentsId!= null) {
			List<CommentsPhotoBean> list = this.getSession().createQuery("FROM CommentsPhotoBean WHERE fkCommentsId = :fkCommentsId", CommentsPhotoBean.class)
					.setParameter("fkCommentsId", fkCommentsId)
					.list();
			return list;
		}
		return null;
	}
	@Override
	public CommentsPhotoBean insert(CommentsPhotoBean bean) {
		if(bean!=null && bean.getFkCommentsId()!= null) {
			Integer fkCommentsId = bean.getFkCommentsId();
			         List<CommentsPhotoBean> list = this.getSession().createQuery("FROM CommentsBean WHERE id = :fkCommentsId", CommentsPhotoBean.class)
			        .setParameter("fkCommentsId", fkCommentsId)
			        .list();			         
		if(!list.isEmpty()) {
			this.getSession().persist(bean);
			return bean;
		}	  			         
		}
		return null;
	}
	@Override
	public CommentsPhotoBean update(CommentsPhotoBean bean) {
		Integer fkCommentsId = bean.getFkCommentsId();
        List<CommentsPhotoBean> list = this.getSession().createQuery("FROM CommentsBean WHERE id = :fkCommentsId", CommentsPhotoBean.class)
       .setParameter("fkCommentsId", fkCommentsId)
       .list();			         
        if(!list.isEmpty()) {
				return this.getSession().merge(bean);
			}
        return null;
		}
	
	@Override
	public boolean delete(Integer id) {
		if(id != null) {
			CommentsPhotoBean temp = this.getSession().get(CommentsPhotoBean.class, id);
			if(temp!=null) {
			this.getSession().remove(temp);
			return true;
		}
		}
		return false;
	}

}
