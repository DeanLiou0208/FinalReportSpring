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
import tw.ispan.eeit168.forum.domain.CommentsLikePostView;

@Repository
public class CommentsLikePostViewDaoHibernate implements CommentsLikePostViewDao {
	
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
//      SELECT * FROM comments_like_post WHERE　fk_pet_article_id = 2 ORDER BY create_at DESC
	@Override
	public List<CommentsLikePostView> selectByPetArticleId(JSONObject obj){
		Integer fkPetArticleId = obj.isNull("petArticleId")? null: obj.getInt("petArticleId");
		
		String sort = obj.isNull("sort") ? "createAt" : obj.getString("sort");
		String order = obj.isNull("order")? "desc" : obj.getString("order");
//		Integer start = obj.isNull("start")? 0 : obj.getInt("start");
//		Integer rows = obj.isNull("rows")? 0 : obj.getInt("rows");
		
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<CommentsLikePostView> criteria = builder.createQuery(CommentsLikePostView.class);
//	    FROM comments_like_post
		Root<CommentsLikePostView> root = criteria.from(CommentsLikePostView.class);
//		WHERE
		List<Predicate> predicates = new ArrayList<>();
//		fk_pet_article_id = ?
		predicates.add(builder.equal(root.get("fkPetArticleId"), fkPetArticleId));
//		WHERE　fk_pet_article_id = ?
		if(predicates!=null && !predicates.isEmpty()) {
			Predicate[] array = predicates.toArray(new Predicate[1]);
			criteria = criteria.where(array);
//		ORDER BY create_at DESC
		if("desc".equals(order)) {
			criteria.orderBy(builder.desc(root.get(sort)));
		}else {
			criteria.orderBy(builder.asc(root.get(sort)));
		}
		}
		TypedQuery<CommentsLikePostView> typedQuery = this.getSession().createQuery(criteria);	
		List<CommentsLikePostView> resultList = typedQuery.getResultList();
		if(resultList!=null && !resultList.isEmpty()) {
			return resultList;
		}else {
			return null;
		}
		
	}
}
