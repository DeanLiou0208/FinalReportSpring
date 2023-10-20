package tw.ispan.eeit168.forum.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tw.ispan.eeit168.company.domain.ProductBean;
import tw.ispan.eeit168.forum.domain.SpeciesViewsView;

@Repository
public class SpeciesViewsViewDaoHibernate implements SpeciesViewsViewDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public List<SpeciesViewsView> select() {
		return this.getSession().createQuery("from SpeciesViewsView", SpeciesViewsView.class).list();
	}
	@Override
	public  List<Integer> selectBySpeciesIds(String fkPetArticleSpeciesId) {
		
		List<String> speciesIdList = null;
		if(fkPetArticleSpeciesId!=null) {
		 speciesIdList = Arrays.asList(fkPetArticleSpeciesId.split(","));
		}	
//		SELECT　[fk_pet_article_id],[species]　FROM [species_views] WHERE [fk_pet_article_species_id] in (1,3)
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
//		創建CriteriaQuery對象,並指定返回的結果類型
		CriteriaQuery<Integer> criteria = builder.createQuery(Integer.class);
//		FROM [species_views]
//		<>放入實體類名稱
		Root<SpeciesViewsView> root = criteria.from(SpeciesViewsView.class);
//		SELECT　[fk_pet_article_id]
		criteria = criteria.select(root.get("fkPetArticleId"));
//		WHERE
		List<Predicate> predicates = new ArrayList<>();	
//		[fk_pet_article_species_id] in (1,3)
		System.out.println(speciesIdList);
		if(speciesIdList!=null) {
			In<Object> in = builder.in(root.get("fkPetArticleSpeciesId"));
			for(String speciesId : speciesIdList) {
			  in.value(speciesId);
			}
			predicates.add(in);
		}
//		WHERE [fk_pet_article_species_id] in (1,3)
		if(predicates!=null && !predicates.isEmpty()) {
			Predicate[] array = predicates.toArray(new Predicate[1]);
			criteria = criteria.where(array);
		}
		
		TypedQuery<Integer> typedQuery = this.getSession().createQuery(criteria);
		List<Integer> resultList = typedQuery.getResultList();
		if(resultList!=null && !resultList.isEmpty()) {
			return resultList;
		}else {
			return null;
		}
	}
	@Override
	public List<SpeciesViewsView> selectByArticleIds(Integer fkPetArticleId){
		if(fkPetArticleId!= null) {
			List<SpeciesViewsView> list = this.getSession().createQuery("FROM SpeciesViewsView WHERE fkPetArticleId= :fkPetArticleId", SpeciesViewsView.class)
			.setParameter("fkPetArticleId", fkPetArticleId)
			.list();
			return list;
		}
		return null;
	}
}
