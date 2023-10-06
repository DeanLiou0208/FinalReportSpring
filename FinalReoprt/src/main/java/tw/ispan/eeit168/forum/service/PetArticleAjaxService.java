package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.PetArticleDao;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.member.domain.MemberBean;

@Service
@Transactional(rollbackFor = { Exception.class })
public class PetArticleAjaxService {
	@Autowired
	private PetArticleDao petArticleDao;
	@Autowired
	private MemberDAO memberDAO;

	public List<PetArticleBean> findAll() {
		List<PetArticleBean> finaAll = petArticleDao.select();
		return finaAll;
	}

	public List<PetArticleBean> findByMemberId(Integer memberId) {
		MemberBean member = memberDAO.select(memberId);
		if (member != null) {
			List<PetArticleBean> selectByMemberId = petArticleDao.selectByMemberId(memberId);
			return selectByMemberId;
		}
		return null;
	}
	public boolean exists(Integer id) {
		return petArticleDao.select(id)!= null;
	}
	public List<PetArticleBean> orderByTime(){
		List<PetArticleBean> byTime = petArticleDao.orderByTime();
		System.out.println(byTime);
		return byTime;
	}
	
	public PetArticleBean create(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String type = obj.isNull("type") ? null : obj.getString("type");
			String title = obj.isNull("title") ? null : obj.getString("title");
			String petArticleText = obj.isNull("petArticleText") ? null : obj.getString("petArticleText");

			PetArticleBean insert = new PetArticleBean();
			insert.setFkMemberId(fkMemberId);
			insert.setType(type);
			insert.setTitle(title);
			insert.setPetArticleText(petArticleText);

			return petArticleDao.insert(insert);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PetArticleBean modify(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
//		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String type = obj.isNull("type") ? null : obj.getString("type");
			String title = obj.isNull("title") ? null : obj.getString("title");
			String petArticleText = obj.isNull("petArticleText") ? null : obj.getString("petArticleText");

			PetArticleBean petArticleId = petArticleDao.select(id);
			if (petArticleId != null) {
				PetArticleBean update = petArticleDao.select(id);
				update.setType(type);
				update.setTitle(title);
				update.setPetArticleText(petArticleText);

				return petArticleDao.update(update);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean remove(Integer id) {
		try {
			if (id != null) {
				return petArticleDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
