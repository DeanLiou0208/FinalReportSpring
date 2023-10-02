package tw.ispan.eeit168.member.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import tw.ispan.eeit168.member.domain.PetPhotoOrderView;

@Repository
public class PetPhotoOrderViewDaoHibernate implements PetPhotoOrderViewDao{
	
	@PersistenceContext
	private Session session;
	
	public Session getSession() {
		return session;
	}
	
	@Override
	public List<PetPhotoOrderView> select(){
		return this.getSession().createQuery("from PetPhotoOrderView", PetPhotoOrderView.class).list();
	}
	@Override
	public PetPhotoOrderView selectById(Integer id) {
		if(id != null ) {
			return this.getSession().get(PetPhotoOrderView.class, id);	
		}
		return null;
	}
	//改成criteria
	@Override
	public List<PetPhotoOrderView> selectByMemberLike(List<Integer> list) {
		if(!list.isEmpty()) {
			return this.getSession().createQuery("FROM PetPhotoOrderView WHERE petId in (:petId)", PetPhotoOrderView.class)
					.setParameterList("petId", list)
					.list();}
		return null;
	}
	
	@Override
	public List<PetPhotoOrderView> find(List<Integer> likeRecord,JSONObject obj){	
		//模糊查詢動物名
		String name = obj.isNull("name") ? null : obj.getString("name");
		//挑選物種
		String species = obj.isNull("species") ? null : obj.getString("species");
		List<String> speciesList = null;
		if(species != null) {
			speciesList = Arrays.asList(species.split(","));
		}
		
		//依據xx排序
		String sort = obj.isNull("sort") ? "id" : obj.getString("sort");
		//排序 升冪降冪
		String order = obj.isNull("order") ? "desc" : obj.getString("order");
		//從第幾筆開始
		Integer start = obj.isNull("start") ? 0 : obj.getInt("start");
		//每一分頁筆數
		Integer rows = obj.isNull("rows") ? null : obj.getInt("rows");

		//SELECT * FROM pet_photo_order
		//WHERE species in ('狗狗','貓貓','鳥類','爬蟲') 
		//AND id in ('1','3','5','7','9','11','13','15','17','19')
		//AND name LIKE '%狗%'
		//ORDER BY create_at desc
		//ORDER BY like_count asc		
		
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<PetPhotoOrderView> criteria = builder.createQuery(PetPhotoOrderView.class);
		
		//FROM pet_photo_order
		Root<PetPhotoOrderView> root = criteria.from(PetPhotoOrderView.class);
		
		//where
		List<Predicate> predicates = new ArrayList<>();
		
		//species in ('狗狗','貓貓','鳥類','爬蟲') 
		if(!speciesList.isEmpty()) {
			In<Object> in = builder.in(root.get("species"));
			for(int i = 0; i < speciesList.size(); i++) {
				in.value(speciesList.get(i));
			}
			predicates.add(builder.and(builder.and(in)));
		}
				
		//AND id in ('1','3','5','7','9','11','13','15','17','19')
		//確認按讚紀錄
		System.out.println(likeRecord);
		if(!likeRecord.isEmpty()) {
			In<Object> in = builder.in(root.get("id"));
			for(int i = 0; i < likeRecord.size(); i++) {
				in.value(likeRecord.get(i));
			}
			predicates.add(builder.and(builder.and(in)));
		}
		
		//AND name LIKE '%狗%'
		if(name!=null && name.length()!=0) {
			predicates.add(builder.like(root.get("name"), "%"+name+"%"));
		}
		
		//WHERE......
		if(predicates!=null && !predicates.isEmpty()) {
			Predicate[] array = predicates.toArray(new Predicate[1]);
			criteria = criteria.where(array);
		}
		
		//ORDER BY create_at desc
		//ORDER BY like_count asc	
		if("desc".equals(order)) {
			criteria = criteria.orderBy(builder.desc(root.get(sort)));
		} else {
			criteria = criteria.orderBy(builder.asc(root.get(sort)));
		}
		
		TypedQuery<PetPhotoOrderView> typedQuery = this.getSession().createQuery(criteria);
		if(rows!=null) {
			typedQuery = typedQuery.setFirstResult(start)
					.setMaxResults(rows);
		}
		
		List<PetPhotoOrderView> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}
	
	
}
