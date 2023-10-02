package tw.ispan.eeit168.member.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.dao.MyPetDAO;
import tw.ispan.eeit168.member.dao.PetDAO;
import tw.ispan.eeit168.member.dao.PetLikesDAO;
import tw.ispan.eeit168.member.dao.PetPhotoOrderViewDao;
import tw.ispan.eeit168.member.domain.MyPetView;
import tw.ispan.eeit168.member.domain.PetBean;
import tw.ispan.eeit168.member.domain.PetPhotoOrderView;

@Service
@Transactional(rollbackFor = { Exception.class })
public class PetService {
	@Autowired
	private PetDAO petDAO = null;
	@Autowired
	private MyPetDAO myPetDAO = null;
	@Autowired
	private PetLikesDAO petLikesDAO = null;
	@Autowired
	private PetPhotoOrderViewDao petPhotoOrderViewDao = null;

	public Boolean exists(Integer id) {
		return myPetDAO.selectId(id) != null;
	}

	public MyPetView findById(Integer id) {
		return myPetDAO.selectId(id);
	}

	public List<MyPetView> findMyPet(Integer fkMemberId) {
		return myPetDAO.select(fkMemberId);
	}

	public PetBean createPet(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String name = obj.isNull("name") ? null : obj.getString("name");
			Integer categroyId = obj.isNull("categroyId") ? null : obj.getInt("categroyId");
			Integer age = obj.isNull("age") ? null : obj.getInt("age");
			Boolean gender = obj.isNull("gender") ? null : obj.getBoolean("gender");

			if (fkMemberId != null && name != null && categroyId != null && name.length() != 0) {
				PetBean insert = new PetBean();
				insert.setFkMemberId(fkMemberId);
				insert.setName(name);
				insert.setCategroyId(categroyId);
				insert.setAge(age);
				insert.setGender(gender);
				return petDAO.insert(insert);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public PetBean modify(Integer id, String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String name = obj.isNull("name") ? null : obj.getString("name");
			Integer categroyId = obj.isNull("categroyId") ? null : obj.getInt("categroyId");
			Integer age = obj.isNull("age") ? null : obj.getInt("age");
			Boolean gender = obj.isNull("gender") ? null : obj.getBoolean("gender");

			PetBean update = petDAO.select(id);
			System.out.println(update);
			update.setFkMemberId(fkMemberId);
			update.setName(name);
			update.setCategroyId(categroyId);
			update.setAge(age);
			update.setGender(gender);

			return petDAO.update(update);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean remove(Integer id) {
		try {
			return petDAO.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<PetPhotoOrderView> find(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			// 確認是否要找按讚紀錄 還是顯示全部
			String record = obj.isNull("record") ? "全部" : obj.getString("record");
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			// 藉由使用者id找出按讚紀錄
			List<Integer> likeRecord = new ArrayList<Integer>();
			if (record.equals("我的最愛")) {
				likeRecord = petLikesDAO.select(fkMemberId);
			}
			//依據各種條件找出對應寵物
			return petPhotoOrderViewDao.find(likeRecord, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
