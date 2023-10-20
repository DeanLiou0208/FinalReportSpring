package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CommentsBean;
import tw.ispan.eeit168.forum.domain.CommentsLikesBean;

@Repository
@Transactional
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
	@Override
	public List<CommentsLikesBean> select(Integer fkMemberId) {
		if(fkMemberId!= null) {
			 Session session = this.getSession();
			 Query<CommentsLikesBean> query = session.createQuery("FROM CommentsLikesBean WHERE fkMemberId = :fkMemberId", CommentsLikesBean.class);
			 query.setParameter("fkMemberId", fkMemberId);
			 List<CommentsLikesBean> resultList = query.getResultList();
			 return resultList;
		}
		return null;
	}
	@Override
	public List<CommentsLikesBean> selectByCommentId(Integer fkCommentId) {
		if(fkCommentId!=null) {
			List<CommentsBean> list = this.getSession().createQuery("FROM CommentsBean WHERE id= :fkCommentId", CommentsBean.class)
			.setParameter("fkCommentId", fkCommentId)
			.list();
			if(!list.isEmpty()) {
				List<CommentsLikesBean> result = this.getSession().createQuery("FROM CommentsLikesBean WHERE fkCommentId= :fkCommentId", CommentsLikesBean.class)
				.setParameter("fkCommentId", fkCommentId)
				.list();
				return result;
			}
		}
		return null;
	}
	
	@Override
	public List<Integer> commentLike(Integer fkMemberId) {
	
		if(fkMemberId != null) {
		String hql = "select fkCommentId from CommentsLikesBean where fkMemberId = :fkMemberId and likeOrUnlike = true";
		 List<Integer> list = this.getSession()
					.createQuery(hql, Integer.class)
					.setParameter("fkMemberId", fkMemberId)
					.list();

		 return list;
		}
		return null;
	}
// 查詢完該留言按讚跟按倒讚數寫CommentsLikePostViewAjaxService
	@Override
	public List<Integer> commentUnlike(Integer fkMemberId) {
	
		if(fkMemberId != null) {
		String hql = "select fkCommentId from CommentsLikesBean where fkMemberId = :fkMemberId and likeOrUnlike = false";
		 List<Integer> list = this.getSession()
					.createQuery(hql, Integer.class)
					.setParameter("fkMemberId", fkMemberId)
					.list();

		 return list;
		}
		return null;
	}
	@Override
	public CommentsLikesBean insert(CommentsLikesBean bean) {
		if(bean!=null) {
			Integer fkMemberId =bean.getFkMemberId();
			Integer fkCommentId =bean.getFkCommentId();
			List<CommentsLikesBean> list = this.getSession().createQuery("from CommentsLikesBean WHERE fkMemberId = :fkMemberId AND fkCommentId = :fkCommentId", CommentsLikesBean.class)
			.setParameter("fkMemberId", fkMemberId)
			.setParameter("fkCommentId", fkCommentId)
			.list();
			if(list.isEmpty()) {
				this.getSession().persist(bean);
				return bean;	
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer fkMemberId, Integer fkCommentId) {
		if(fkMemberId!= null && fkCommentId!=null) {
		
			List<CommentsLikesBean> list = this.getSession().createQuery("FROM CommentsLikesBean WHERE fkMemberId = :fkMemberId AND fkCommentId= :fkCommentId", CommentsLikesBean.class)
			.setParameter("fkMemberId", fkMemberId)
			.setParameter("fkCommentId", fkCommentId)
			.list();
			
			if(!list.isEmpty()) {
				this.getSession().remove(list.get(0));
				return true;
			}
		}
		return false;
	}
	
	
  
}
