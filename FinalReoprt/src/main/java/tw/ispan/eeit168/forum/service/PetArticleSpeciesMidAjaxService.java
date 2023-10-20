package tw.ispan.eeit168.forum.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.PetArticleDao;
import tw.ispan.eeit168.forum.dao.PetArticleSpeciesDao;
import tw.ispan.eeit168.forum.dao.PetArticleSpeciesMidDao;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.domain.PetArticleSpeciesBean;
import tw.ispan.eeit168.forum.domain.PetArticleSpeciesMidBean;

@Service
@Transactional(rollbackFor = {Exception.class})
public class PetArticleSpeciesMidAjaxService {
	@Autowired
	private PetArticleSpeciesMidDao petArticleSpeciesMidDao;
	@Autowired
	private PetArticleDao petArticleDao;
	@Autowired
	private PetArticleSpeciesDao petArticleSpeciesDao;
	
	public List<PetArticleSpeciesMidBean>findByPetArticleId(Integer fkPetArticleId) {
		List<PetArticleSpeciesMidBean> byPetArticleId = petArticleSpeciesMidDao.select(fkPetArticleId);
		return byPetArticleId;
	}
	public PetArticleSpeciesMidBean create(String json) {
		try {
			JSONObject obj = new JSONObject();
			Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null :obj.getInt("fkPetArticleId");
			Integer fkPetArticleSpeciesId = obj.isNull("fkPetArticleSpeciesId") ? null :obj.getInt("fkPetArticleSpeciesId");
			
			PetArticleBean petArticleId = petArticleDao.select(fkPetArticleId);
			PetArticleSpeciesBean petArticleSpeciesId = petArticleSpeciesDao.select(fkPetArticleSpeciesId);
			if(petArticleId!=null && petArticleSpeciesId!=null) {
				PetArticleSpeciesMidBean insert = new PetArticleSpeciesMidBean();
				insert.setFkPetArticleId(fkPetArticleId);
				insert.setFkPetArticleSpeciesId(fkPetArticleSpeciesId);
				
				return petArticleSpeciesMidDao.insert(insert);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean modify(String json) {
		JSONObject obj = new JSONObject(json);
//		Integer id = obj.isNull("id") ? null :obj.getInt("id");
		Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null :obj.getInt("fkPetArticleId");
		String fkPetArticleSpeciesId = obj.isNull("fkPetArticleSpeciesId") ? null : obj.getString("fkPetArticleSpeciesId");
		
		if(fkPetArticleId!=null && fkPetArticleSpeciesId!=null) {
			
			petArticleSpeciesMidDao.deleteByArticleId(fkPetArticleId);
			
			 // Define the delimiter based on which you want to split the string
			String delimiter = ","; 
			// Split the string into an array of substrings
			String[] splitValues = fkPetArticleSpeciesId.split(delimiter);
			// Create a list to hold the Integer values
			ArrayList<Integer> integerValues = new ArrayList<>();
			// Convert each substring to an Integer and add it to the list
			for(String value : splitValues) {
				try {
					Integer intValue = Integer.parseInt(value.trim());
					
					integerValues.add(intValue);
				} catch (NumberFormatException e) {
					e.printStackTrace();
//					System.err.println("Invalid integer value: " + value);
				}
			}
			
			for(Integer intval : integerValues) {
				PetArticleSpeciesMidBean insert = new PetArticleSpeciesMidBean();
//				insert.setId(id);
				insert.setFkPetArticleId(fkPetArticleId);
				insert.setFkPetArticleSpeciesId(intval);
				petArticleSpeciesMidDao.insert(insert);
				
				}return true;
		}else {
			// Handle the case when 'fkPetArticleSpeciesId' is null
			System.out.println("fkPetArticleSpeciesId is null");
		}
		return false;	
	}
		
	public Boolean existsByPetArticleId (Integer fkPetArticleId) {
		return petArticleSpeciesMidDao.select(fkPetArticleId)!=null;
	}
	public Boolean existsByPetArticleSpeciesId (Integer fkPetArticleSpeciesId) {
		return petArticleSpeciesMidDao.selectBySpeciesId(fkPetArticleSpeciesId)!=null;
	}
	
	public Boolean remove(Integer id) {
		try {
			if(id!=null) {
				return petArticleSpeciesMidDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Boolean exists(Integer Id) {
		return petArticleSpeciesMidDao.selectById(Id)!= null;
	}
}
