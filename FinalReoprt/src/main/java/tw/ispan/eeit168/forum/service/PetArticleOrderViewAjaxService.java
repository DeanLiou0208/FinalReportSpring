package tw.ispan.eeit168.forum.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.PetArticleOrderViewDao;
import tw.ispan.eeit168.forum.dao.SpeciesViewsViewDao;
import tw.ispan.eeit168.forum.domain.PetArticleOrderView;
import tw.ispan.eeit168.forum.domain.SpeciesViewsView;

@Service
@Transactional(rollbackFor = {Exception.class})
public class PetArticleOrderViewAjaxService {
	@Autowired
	private PetArticleOrderViewDao petArticleOrderViewDao;
	@Autowired
	private SpeciesViewsViewDao speciesViewsViewDao;
	public List<PetArticleOrderView> findAll(){
		List<PetArticleOrderView> list = petArticleOrderViewDao.select();
		return list;
	}
	
	public List<PetArticleOrderView> find (String json){
		
			try {
				JSONObject obj = new JSONObject(json);
//				String speciesId = obj.isNull("speciesId") ? null: obj.getString("speciesId");
//			"species" 跟前端一樣
				JSONArray speciesIdArray = obj.optJSONArray("speciesId");
				System.out.println("speciesIdArray:"+ 111);
				String speciesIdString=null;
				if (speciesIdArray != null) {
		            // 如果存在，将其转换为一个 List<Integer>
		            List<Integer> speciesIds = new ArrayList<>();
		            for (int i = 0; i < speciesIdArray.length(); i++) {
		                speciesIds.add(speciesIdArray.getInt(i));
		            }
//		            使用Java 8引入的串流（Stream）操作，將speciesIds中的整數轉換為字符串
		            speciesIdString = speciesIds.stream()
		            		.map(Object::toString)
		            		.collect(Collectors.joining(","));
		            System.out.println(speciesIdString); 
		            }

				
//			藉由species找出寵物fkPetArticleId
				List<Integer> petArticleIdRecord = speciesViewsViewDao.selectBySpeciesIds(speciesIdString);
//			Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null : obj.getInt("fkPetArticleId");
				
				return petArticleOrderViewDao.find(petArticleIdRecord,obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		
		return null;
	}
	public  List<PetArticleOrderView> findByMemberId(String json){
			try {
				JSONObject obj = new JSONObject(json);
				return petArticleOrderViewDao.findByMemberId(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
	}
	
}
