package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.PetArticleDao;
import tw.ispan.eeit168.forum.dao.PetArticlePhotoDao;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;

@Service
@Transactional(rollbackFor = {Exception.class})
public class PetArticlePhotoAjaxService {
	@Autowired
	private PetArticlePhotoDao petArticlePhotoDao;
	@Autowired
	private PetArticleDao petArticleDao;
	
	public PetArticlePhotoBean selectById(Integer id) {
		return petArticlePhotoDao.select(id);
	}
	public List<PetArticlePhotoBean> selectByPetArticleId(Integer fkPetArticleId) {
//		System.out.println(fkPetArticleId);
		return petArticlePhotoDao.selectByPetArticleId(fkPetArticleId);
	}
	public PetArticlePhotoBean create(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null: obj.getInt("fkPetArticleId");
			Boolean main = obj.isNull("main") ? null: obj.getBoolean("main");
			String img = obj.isNull("img") ? null: obj.getString("img");
			
			PetArticleBean petArticleId = petArticleDao.select(fkPetArticleId);
			if(petArticleId!=null) {
				PetArticlePhotoBean insert = new PetArticlePhotoBean();
				insert.setFkPetArticleId(fkPetArticleId);
				insert.setMain(main);
				insert.setImg(img);
				return petArticlePhotoDao.insert(insert);
			
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	public PetArticlePhotoBean modify(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			
			Integer id = obj.isNull("id") ? null: obj.getInt("id");
			Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null: obj.getInt("fkPetArticleId");
			Boolean main = obj.isNull("main") ? null: obj.getBoolean("main");
			String img = obj.isNull("img") ? null: obj.getString("img");
			PetArticlePhotoBean update = petArticlePhotoDao.select(id);
			if(update!=null) {
				update.setId(id);
				update.setFkPetArticleId(fkPetArticleId);
				update.setMain(main);
				update.setImg(img);
				
				return petArticlePhotoDao.update(update);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean exists (Integer id) {
		return petArticlePhotoDao.select(id)!=null;
	}
	public boolean remove (Integer id) {
		try {
			if(id!= null) {
				return petArticlePhotoDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
