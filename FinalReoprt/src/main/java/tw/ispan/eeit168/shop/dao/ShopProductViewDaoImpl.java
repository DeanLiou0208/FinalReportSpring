package tw.ispan.eeit168.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tw.ispan.eeit168.shop.domain.ShopProductView;

@Repository
public class ShopProductViewDaoImpl implements ShopProductViewDao {
	@PersistenceContext
	private Session session;
	

	public Session getSession() {
		return session;
	}

	@Override
	public List<ShopProductView> select() {
		return this.getSession().createQuery("from ShopProductView", ShopProductView.class).list();
	}
	@Override
	public ShopProductView select(Integer id) {
		if (id != null) {
			return this.getSession().get(ShopProductView.class, id);
		}
		return null;
	}
	
	@Override
	public List<ShopProductView> find(JSONObject obj){
		Integer productId = obj.isNull("productId") ? null : obj.getInt("productId");
		Integer id = obj.isNull("id") ? null : obj.getInt("id");
		String img = obj.isNull("img") ? null : obj.getString("img");
		String companyShopName = obj.isNull("companyShopName") ? null : obj.getString("companyShopName");
		String memberShopName = obj.isNull("memberShopName") ? null : obj.getString("memberShopName");
//		Integer price =obj.isNull("price") ? null : obj.getInt("price");
		Integer maxPrice =obj.isNull("maxPrice") ? null : obj.getInt("maxPrice");
		Integer minPrice =obj.isNull("minPrice") ? null : obj.getInt("minPrice");
		String name = obj.isNull("name") ? null : obj.getString("name");
		String description = obj.isNull("description") ? null : obj.getString("description");
		Double avgRateScore = obj.isNull("avgRateScore") ? null : obj.getDouble("avgRateScore");
		
		
		String sort = obj.isNull("sort") ? "productId" : obj.getString("sort");
		String order = obj.isNull("order") ? "desc" : obj.getString("order");
		Integer start = obj.isNull("start") ? 0 : obj.getInt("start");
		Integer rows = obj.isNull("rows") ? null : obj.getInt("rows");
		
//		select * from ShopProductView
//		where id=? and name like ? and price > ? and make < ? and expire >= ?
//		order by id desc
			
		HibernateCriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<ShopProductView> criteria = builder.createQuery(ShopProductView.class);
		
//		from ShopProductView
		Root<ShopProductView> root = criteria.from(ShopProductView.class);
		
//		where		
		List<Predicate> predicate = new ArrayList<>();
		
//		productId = ?
		if(productId != null) {
			predicate.add(builder.equal(root.get("productId"), productId));
			System.out.println(predicate);
		}
		
//		id = ?
		if(id != null) {
			predicate.add(builder.equal(root.get("id"), id));
		}

//		img = ?
//		if(img != null) {
//			predicate.add(builder.equal(root.get("img"), img));
//		}
		
//		companyShopName = ?
		if(companyShopName != null && companyShopName.length() != 0) {
			predicate.add(builder.equal(root.get("companyShopName"), companyShopName));
		}

//		memberShopName = ?
		if(memberShopName != null && memberShopName.length() !=0) {
			predicate.add(builder.equal(root.get("memberShopName"), memberShopName));		
		}
		
//		price = ? 
//		if(price != null) {
//			predicate.add(builder.between(root.get("price"), minPrice,maxPrice));
//		}
//		price between A and B
		if(minPrice != null && maxPrice != null) {
			predicate.add(builder.between(root.get("price"), minPrice, maxPrice));
		}else if(minPrice != null) {
			predicate.add(builder.greaterThanOrEqualTo(root.get("price"), minPrice));
		}else if(maxPrice != null) {
			predicate.add(builder.lessThanOrEqualTo(root.get("price"), maxPrice));
		}
				
		if (name != null && name.length() != 0) {
			predicate.add(builder.like(root.get("name"), "%" + name + "%"));
		}
		
		if (description != null && description.length() != 0) {
			predicate.add(builder.like(root.get("description"), "%" + description + "%"));
			
		}
		
		if(avgRateScore != null) {
			predicate.add(builder.equal(root.get("avgRateScore"), avgRateScore));
		}
		
		if (predicate != null && !predicate.isEmpty()) {
			Predicate[] array = predicate.toArray(new Predicate[1]);
			criteria = criteria.where(array);
		}
		
		if ("desc".equals(order)) {
			criteria = criteria.orderBy(builder.desc(root.get(sort)));
		} else {
			criteria = criteria.orderBy(builder.asc(root.get(sort)));
		}
		
		TypedQuery<ShopProductView> typedQuery = this.getSession().createQuery(criteria);
		if(rows != null) {
			typedQuery = typedQuery.setFirstResult(start).setMaxResults(rows);
		}
		
		List<ShopProductView> result = typedQuery.getResultList();
		if(result != null && !result.isEmpty()) {
			return result;
		}else {
			return null;
		}
		
	}
	
	public Long count(JSONObject obj) {
		
			Integer productId = obj.isNull("productId") ? null : obj.getInt("productId");
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
			String companyShopName = obj.isNull("companyShopName") ? null : obj.getString("companyShopName");
			String memberShopName = obj.isNull("memberShopName") ? null : obj.getString("memberShopName");
			Integer maxPrice =obj.isNull("maxPrice") ? null : obj.getInt("maxPrice");
			Integer minPrice =obj.isNull("minPrice") ? null : obj.getInt("minPrice");
			String name = obj.isNull("name") ? null : obj.getString("name");
			String description = obj.isNull("description") ? null : obj.getString("description");
			Double avgRateScore = obj.isNull("avgRateScore") ? null : obj.getDouble("avgRateScore");
							
			HibernateCriteriaBuilder builder = this.getSession().getCriteriaBuilder();
			CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
			
//			from ShopProductView
			Root<ShopProductView> root = criteria.from(ShopProductView.class);

//			select count(*)
			criteria = criteria.select(builder.count(root));
			
//			where		
			List<Predicate> predicate = new ArrayList<>();
			
//			productId = ?
			if(productId != null) {
				predicate.add(builder.equal(root.get("productId"), productId));
				System.out.println(predicate);
			}
			
//			id = ?
			if(id != null) {
				predicate.add(builder.equal(root.get("id"), id));
			}
			
//			companyShopName = ?
			if(companyShopName != null && companyShopName.length() != 0) {
				predicate.add(builder.equal(root.get("companyShopName"), companyShopName));
			}

//			memberShopName = ?
			if(memberShopName != null && memberShopName.length() !=0) {
				predicate.add(builder.equal(root.get("memberShopName"), memberShopName));		
			}
			
//			price between max and min
			if(minPrice != null && maxPrice != null) {
				predicate.add(builder.between(root.get("price"), minPrice, maxPrice));
			}else if(minPrice != null) {
				predicate.add(builder.greaterThanOrEqualTo(root.get("price"), minPrice));
			}else if(maxPrice != null) {
				predicate.add(builder.lessThanOrEqualTo(root.get("price"), maxPrice));
			}
			
//			name like =?					
			if (name != null && name.length() != 0) {
				predicate.add(builder.like(root.get("name"), "%" + name + "%"));
			}
			
//			description like =?			
			if (description != null && description.length() != 0) {
				predicate.add(builder.like(root.get("description"), "%" + description + "%"));
				
			}
//			avgRateScore =?
			if(avgRateScore != null) {
				predicate.add(builder.equal(root.get("avgRateScore"), avgRateScore));
			}
			
			if (predicate != null && !predicate.isEmpty()) {
				Predicate[] array = predicate.toArray(new Predicate[1]);
				criteria = criteria.where(array);
			}
			
			TypedQuery<Long> typedQuery = this.getSession().createQuery(criteria);
			return typedQuery.getSingleResult();
		}
}
