package tw.ispan.eeit168.forum.dao;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.PetArticleBean;

@Repository
@Transactional
public class PetArticleDaoHibernate implements PetArticleDao {
	
	 @PersistenceContext
		private Session session;

		public Session getSession() {
			return session;
		}

	@Override
	public List<PetArticleBean> select() {
		
		return this.getSession().createQuery("From PetArticleBean", PetArticleBean.class).list();
	}
	@Override
	public PetArticleBean select(Integer id) {
		if(id != null) {
			return this.getSession().get(PetArticleBean.class, id);
		}
		return null;
	}
	@Override
	public PetArticleBean insert(PetArticleBean bean) {
		if(bean != null) {
			this.getSession().persist(bean);
			return bean;
		}
		return null;
	}
	@Override
	public List<PetArticleBean> selectByMemberId(Integer memberId) {
		if(memberId!=null) {
			Session session = this.getSession();
			Query<PetArticleBean> query = session.createQuery("FROM PetArticleBean WHERE fkMemberId = : memberId", PetArticleBean.class);
			query.setParameter("memberId", memberId);
			List<PetArticleBean> list = query.getResultList();
			return list;
		}
		return null;
	}
	public List<PetArticleBean> orderByTime(){
//		SELECT TOP (5)*
//		FROM [pet_web].[dbo].[pet_article]
//		WHERE CONVERT(DATE, [create_at]) = CONVERT(DATE, GETDATE())
//		ORDER BY [create_at] DESC;
//		Date currentDate = new Date(); 
		LocalDate now = LocalDate.now();
		
//		System.out.println(currentDate);
//		Session session = this.getSession();
		List<PetArticleBean> resultList = this.getSession().createQuery("FROM PetArticleBean WHERE CONVERT(varchar(100), createAt,120) like :currentDate ORDER BY createAt DESC", PetArticleBean.class)
		.setParameter("currentDate", now+"%")
		.setMaxResults(10)
		.getResultList();
		System.out.println(resultList);
		return resultList;
		
	}
		
	
	@Override
	public PetArticleBean update(PetArticleBean bean) {
		if(bean != null && bean.getId()!= null) {
			 PetArticleBean temp = this.getSession().get(PetArticleBean.class, bean.getId());
			 if(temp!=null) {
				 return this.getSession().merge(bean); 
			 }
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id != null) {
			PetArticleBean temp = this.getSession().get(PetArticleBean.class,id);
			if(temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
