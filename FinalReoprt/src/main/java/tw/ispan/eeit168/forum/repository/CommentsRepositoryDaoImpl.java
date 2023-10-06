package tw.ispan.eeit168.forum.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.CommentsBean;

@Repository
@Transactional
public class CommentsRepositoryDaoImpl implements CommentsRepositoryDao {
    @PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}
	@Override
	public List<CommentsBean> select(){
		
		return this.getSession().createQuery("From CommentsBean", CommentsBean.class).list();
	}
	@Override
	public CommentsBean select(Integer id) {
		if(id != null) {
			Session session = this.getSession();
			CommentsBean commentsBean = session.get(CommentsBean.class, id);
			return commentsBean;
		}
		return null;
		
	}
	@Override
	public CommentsBean insert(CommentsBean bean) {
		if(bean.getFkMemberId()!=null && bean.getFkPetArticleId()!= null) {
			CommentsBean temp1 = this.getSession().get(CommentsBean.class,bean.getFkMemberId());
			CommentsBean temp2 = this.getSession().get(CommentsBean.class,bean.getFkPetArticleId());
		   if(temp1!=null && temp2!=null) {
			   this.getSession().persist(bean);
			   return bean;			   
		   }			
		}
		return null;
	}
	@Override
	public CommentsBean update(CommentsBean bean) {
		if(bean!= null && bean.getId()!=null) {
			CommentsBean temp = this.getSession().get(CommentsBean.class, bean.getId());
			if(temp!= null) {
				return (CommentsBean)this.getSession().merge(bean);
			}
		}
		return null;
	}
	
	public boolean delete(Integer id) {
		if(id!= null) {
			CommentsBean temp = this.getSession().get(CommentsBean.class, id);
			if(temp!= null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
}
