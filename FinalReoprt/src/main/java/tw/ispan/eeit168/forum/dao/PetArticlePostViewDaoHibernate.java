package tw.ispan.eeit168.forum.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tw.ispan.eeit168.forum.domain.PetArticleOrderView;
import tw.ispan.eeit168.forum.domain.PetArticlePostView;

@Repository
public class PetArticlePostViewDaoHibernate implements PetArticlePostViewDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	@Override
	public List<PetArticlePostView> select(){
		return this.getSession().createQuery("from PetArticlePostView", PetArticlePostView.class).list();
	}
	
	@Override
	public PetArticlePostView selectById(Integer id) {
		if(id != null) {
			PetArticlePostView petArticlePostView = this.getSession().get(PetArticlePostView.class, id);
			return petArticlePostView;
		}
		return null;
	}
	@Override
	public Long count (Integer memberId) {
		String hql = "SELECT count(*) FROM PetArticlePostView WHERE memberId = :memberId";
		if(memberId!=null) {
			Long count = this.getSession().createQuery(hql,Long.class)
			.setParameter("memberId", memberId)
			.uniqueResult();
			System.out.println(count);
			return count;
		}
		return null;
	}
	
	@Override
	public List<PetArticlePostView> selectByMemberId(JSONObject obj){
//			SELECT *FROM pet_article_order WHERE memberId =?
//			ORDER BY like_count desc
//		    ORDER BY unlike_count desc
//			ORDER BY createAt desc
			Integer memberId = obj.isNull("memberId") ? null : obj.getInt("memberId");
			String sort = obj.isNull("sort") ? "likeCount" : obj.getString("sort");
			String order = obj.isNull("order") ? "desc" : obj.getString("order");
			Integer start = obj.isNull("start") ? 0 : obj.getInt("start");
			Integer rows = obj.isNull("rows") ? null : obj.getInt("rows");
			
				CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
				CriteriaQuery<PetArticlePostView> criteria = builder.createQuery(PetArticlePostView.class);
//				FROM pet_article_post
				Root<PetArticlePostView> root = criteria.from(PetArticlePostView.class);
//				WHERE
				List<Predicate> predicates = new ArrayList<>();
//				memberId=?
				if(memberId!=null) {
					predicates.add(builder.equal(root.get("memberId"), memberId));
				}
//				WHERE memberId =?
				if(predicates!=null && !predicates.isEmpty()) {
					Predicate[] array = predicates.toArray(new Predicate[1]);
					criteria = criteria.where(array);
				}
//				ORDER BY createAt desc
				if("desc".equals(order)) {
					criteria.orderBy(builder.desc(root.get(sort)));
				}else {
					criteria.orderBy(builder.asc(root.get(sort)));
				}
				TypedQuery<PetArticlePostView> typedQuery = this.getSession().createQuery(criteria);
				if(rows!=null) {
					typedQuery.setFirstResult(start)
					          .setMaxResults(rows);
				}
				List<PetArticlePostView> resultList = typedQuery.getResultList();
				if(resultList!=null && !resultList.isEmpty()) {
					return resultList;
				}else {
					return null;
				}
			
		
	}
}
	
