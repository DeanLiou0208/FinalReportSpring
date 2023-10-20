package tw.ispan.eeit168.forum.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tw.ispan.eeit168.forum.domain.PetArticleOrderView;

@Repository
public class PetArticleOrderViewDaoHibernate implements PetArticleOrderViewDao {
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<PetArticleOrderView> select (){
		return this.getSession().createQuery("from PetArticleOrderView", PetArticleOrderView.class).list();
	}
	@Override
	public List<PetArticleOrderView> selectShrech(String srt){
		String hql = "from PetArticleOrderView where title like :srt";
		// hql 內的表格  欄位 都需要使用bean裏面的變數 模糊搜尋的hql不需要加% %
		if(srt != null) {
			return
			this.getSession()
			.createQuery(hql, PetArticleOrderView.class)
			.setParameter("srt", "%"+srt+"%")
			//第一個""是hql裡面的代稱 第二個是傳入參數的名稱
			.list();
		}
		return null;
	}
	@Override
	public Long count (List<Integer> petArticleIdRecord,JSONObject obj){
//		模糊查詢title
		String title = obj.isNull("title") ? null : obj.getString("title");
//		挑選文章類型
		String type = obj.isNull("type") ? null : obj.getString("type");
		

//		SELECT count(*)FROM pet_article_order WHERE type =('寵物用品')
//		AND petArticleId in ('1','3')
//		AND title like '%貓%'
		
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

//		FROM pet_article_order
		Root<PetArticleOrderView> root = criteria.from(PetArticleOrderView.class);
//		select count(*)
		criteria = criteria.select(builder.count(root));
//		WHERE
		List<Predicate> predicates = new ArrayList<>();
//		type = ('寵物用品')
		if(type!=null) {
			predicates.add(builder.equal(root.get("type"), type));
		}
//		species in ('狗狗家族','貓貓家族')
//		System.out.println("petArticleIdRecord="+petArticleIdRecord);
		if(!petArticleIdRecord.isEmpty()) {
			In<Object> in = builder.in(root.get("id"));
			for(Integer item : petArticleIdRecord) {
				in.value(item);
			}
			predicates.add(in);
		}
//		title like '%狗%'
		if(title != null && title.length()!=0) {
			predicates.add(builder.like(root.get("title"), "%"+title+"%"));
		}
//	WHERE type in ('寵萌搞笑','寵物用品')AND title like '%狗%'	
		if(predicates!=null && !predicates.isEmpty()) {
			Predicate[] array = predicates.toArray(new Predicate[1]);
			criteria = criteria.where(array);
		}
		TypedQuery<Long> typedQuery = this.getSession().createQuery(criteria);
		return typedQuery.getSingleResult();
		
		
	}
	
	@Override
	public List<PetArticleOrderView> find (List<Integer> petArticleIdRecord,JSONObject obj){

//		模糊查詢title
		String title = obj.isNull("title") ? null : obj.getString("title");
//		挑選文章類型
		String type = obj.isNull("type") ? null : obj.getString("type");
		
//		List<String> typeList = null;
//		if(type!=null) {
//			String delimiter = ",";
//			String[] split = type.split(delimiter);
//			typeList = Arrays.asList(split);	
//		}
		String sort = obj.isNull("sort") ? "likeCount" : obj.getString("sort");
		String order = obj.isNull("order") ? "desc" : obj.getString("order");
		Integer start = obj.isNull("start") ? 0 : obj.getInt("start");
		Integer rows = obj.isNull("rows") ? null : obj.getInt("rows");
		
//		SELECT * FROM pet_article_order WHERE type =('寵物用品')
//		AND petArticleId in ('1','3')
//		AND title like '%貓%'
//		ORDER BY like_count desc
//	    ORDER BY unlike_count desc
//		ORDER BY createAt desc
		
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<PetArticleOrderView> criteria = builder.createQuery(PetArticleOrderView.class);
		
//		FROM pet_article_order
		Root<PetArticleOrderView> root = criteria.from(PetArticleOrderView.class);
//		WHERE
		List<Predicate> predicates = new ArrayList<>();
//		type = ('寵物用品')
		if(type!=null) {
			predicates.add(builder.equal(root.get("type"), type));
		}
//		species in ('狗狗家族','貓貓家族')
//		System.out.println("petArticleIdRecord="+petArticleIdRecord);
		if(!petArticleIdRecord.isEmpty()) {
			In<Object> in = builder.in(root.get("id"));
			for(Integer item : petArticleIdRecord) {
				in.value(item);
			}
			predicates.add(in);
		}
//		title like '%狗%'
		if(title != null && title.length()!=0) {
			predicates.add(builder.like(root.get("title"), "%"+title+"%"));
		}
//	WHERE type in ('寵萌搞笑','寵物用品')AND title like '%狗%'	
		if(predicates!=null && !predicates.isEmpty()) {
			Predicate[] array = predicates.toArray(new Predicate[1]);
			criteria = criteria.where(array);
		}
//		ORDER BY like_count desc
//	    ORDER BY unlike_count desc
//		ORDER BY createAt desc
	
		if("desc".equals(order)) {
			criteria.orderBy(builder.desc(root.get(sort)));
		}else {
			criteria.orderBy(builder.asc(root.get(sort)));
		}
		
		TypedQuery<PetArticleOrderView> typedQuery = this.getSession().createQuery(criteria);
		if(rows!=null) {
			typedQuery.setFirstResult(start)
			          .setMaxResults(rows);
		}
		List<PetArticleOrderView> resultList = typedQuery.getResultList();
		if(resultList!=null && !resultList.isEmpty()) {
			return resultList;
		}else {
			return null;
		}
	}
	@Override
	public List<PetArticleOrderView> findByMemberId (JSONObject obj){

		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		
		String sort = obj.isNull("sort") ? "lasttime" : obj.getString("sort");
		String order = obj.isNull("order") ? "desc" : obj.getString("order");
		Integer start = obj.isNull("start") ? 0 : obj.getInt("start");
		Integer rows = obj.isNull("rows") ? null : obj.getInt("rows");
		
//		SELECT * FROM pet_article_order WHERE fk_member_id = 5　ORDER BY lasttime desc
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<PetArticleOrderView> criteria = builder.createQuery(PetArticleOrderView.class);
//		FROM pet_article_order
		Root<PetArticleOrderView> root = criteria.from(PetArticleOrderView.class);
//		WHERE
		List<Predicate> predicates  = new ArrayList<>();
//		fk_member_id = 5
		if(fkMemberId!=null) {
			predicates.add(builder.equal(root.get("fkMemberId"), fkMemberId));
		}
//		WHERE fk_member_id =
		if(predicates!=null && !predicates.isEmpty()) {
			Predicate[] array = predicates.toArray(new Predicate[1]);
			criteria= criteria.where(array);
		}
	
//		ORDER BY lasttime desc
		if("desc".equals(order)) {
			Order desc = builder.desc(root.get(sort));
			CriteriaQuery<PetArticleOrderView> orderBy = criteria.orderBy(desc);
		}else {
			criteria = criteria.orderBy(builder.desc(root.get(sort)));
		}
		TypedQuery<PetArticleOrderView> typedQuery = this.getSession().createQuery(criteria);
		if(rows!=null) {
			typedQuery = typedQuery.setFirstResult(start)
					               .setMaxResults(rows);
		}
		
		List<PetArticleOrderView> resultList = typedQuery.getResultList();
		if(resultList!= null && !resultList.isEmpty()) {
			return resultList;
		}else {
			return null;
		}
	}
} 
