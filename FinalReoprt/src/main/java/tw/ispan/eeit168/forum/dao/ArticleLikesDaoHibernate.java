package tw.ispan.eeit168.forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import tw.ispan.eeit168.forum.domain.ArticleLikesBean;
import tw.ispan.eeit168.member.domain.PetLikesBean;

@Repository
public class ArticleLikesDaoHibernate implements ArticleLikesDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession(){
		return session;
	}
	
	@Override
	public List<ArticleLikesBean> select(){
		 return this.getSession().createQuery("from ArticleLikesBean", ArticleLikesBean.class).list();
	}
	
	@Override
	public List<ArticleLikesBean> selectLikeByMemberId(Integer fkMemberId) {
		if(fkMemberId != null) {
		
		String hql = "from ArticleLikesBean where fkMemberId = :fkMemberId";
		return  this.getSession()
					.createQuery(hql, ArticleLikesBean.class)
					.setParameter("fkMemberId", fkMemberId)
					.list();
		}
		return null;
	}
	
	@Override
	public List<Integer> petArticleLike(Integer fkMemberId) {
	
		if(fkMemberId != null) {
		String hql = "select fkPetArticleId from ArticleLikesBean where fkMemberId = :fkMemberId and likeOrUnlike = true";
		 List<Integer> list = this.getSession()
					.createQuery(hql, Integer.class)
					.setParameter("fkMemberId", fkMemberId)
					.list();

		 return list;
		}
		return null;
	}
	
	@Override
	public List<Integer> petArticleUnlike(Integer fkMemberId) {
		if(fkMemberId != null) {
		
		String hql = "select fkPetArticleId from ArticleLikesBean where fkMemberId = :fkMemberId and likeOrUnlike = false";
		return  this.getSession()
					.createQuery(hql, Integer.class)
					.setParameter("fkMemberId", fkMemberId)
					.list();
		}
		return null;
	}
	
	
	@Override
	public List<ArticleLikesBean> selectLikeByFkPetArticleId(Integer fkPetArticleId){
		if(fkPetArticleId != null) {
			String hql = "from ArticleLikesBean where fkPetArticleId = :fkPetArticleId";
			return this.getSession()
					.createQuery(hql, ArticleLikesBean.class)
					.setParameter("fkPetArticleId", fkPetArticleId)
					.list();
		}
		return null;
	}
	@Override
	public ArticleLikesBean insert(ArticleLikesBean bean) {
		if(bean != null) {
			Integer fkMemberId = bean.getFkMemberId();
//			System.out.println(mid);
			Integer fkPetArticleId = bean.getFkPetArticleId();
//			System.out.println(pAid);
			if(fkMemberId != null && fkPetArticleId != null) {
				String hql = "from ArticleLikesBean where fkMemberId =:fkMemberId and fkPetArticleId = :fkPetArticleId";
				ArticleLikesBean result = this.getSession()
												.createQuery(hql, ArticleLikesBean.class)
												.setParameter("fkMemberId", fkMemberId)
												.setParameter("fkPetArticleId", fkPetArticleId)
												.uniqueResult();
				//.uniqueResult 是回傳單的一的物件,但不能用isEmpity, 只能用==null
//				System.out.println(result);
				if(result == null) {
					this.getSession().persist(bean);
					return bean;
				}
			}
		}
			return null;
	}
	@Override
	public ArticleLikesBean update(ArticleLikesBean bean) {
		if(bean != null) {
		Integer fkMemberId = bean.getFkMemberId();
		Integer fkPetArticleId = bean.getFkPetArticleId();
		if(fkMemberId != null && fkPetArticleId != null) {
			String hql ="from ArticleLikesBean where fkMemberId = :fkMemberId and fkPetArticleId = :fkPetArticleId";
			ArticleLikesBean result = this.getSession()
										.createQuery(hql, ArticleLikesBean.class)
										.setParameter("fkMemberId", fkMemberId)
										.setParameter("fkPetArticleId", fkPetArticleId)
										.uniqueResult();
			if(result != null) {
				this.getSession().merge(bean);
				return bean;
				}
			}			
		}
		return null;
	}
	
	@Override
	public  Boolean delete(Integer fkPetArticleId ) {
		if(fkPetArticleId!=null) {
			String hql = "FROM ArticleLikesBean WHERE fkPetArticleId = :fkPetArticleId ";
			List<ArticleLikesBean> list = this.getSession().createQuery(hql, ArticleLikesBean.class)
			.setParameter("fkPetArticleId", fkPetArticleId)
			
			.list();
//			System.out.println(list);
			if(list != null) {
				for(ArticleLikesBean articleLike : list) {
					
					this.getSession().remove(articleLike);
//					System.out.println(articleLike);
				}
				return true;
				}
		}
		return false;
	}
	@Override
	public  Boolean deleteLike(Integer fkMemberId,Integer petArticleId ) {
		if(petArticleId!=null && fkMemberId!=null) {
			String collectionsql = "FROM ArticleLikesBean WHERE fkMemberId = :fkMemberId AND fkPetArticleId = :fkPetArticleId";
			 ArticleLikesBean likesBean = this.getSession()
	                    .createQuery(collectionsql, ArticleLikesBean.class)
	                    .setParameter("fkMemberId", fkMemberId)
	                    .setParameter("fkPetArticleId", petArticleId)
	                    .uniqueResult();
			if(likesBean!=null) {
				this.getSession().remove(likesBean);
				return true;
			}
			}
		return false;
		}
	}

