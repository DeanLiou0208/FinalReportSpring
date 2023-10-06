package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.CommentsDao;
import tw.ispan.eeit168.forum.dao.PetArticleDao;
import tw.ispan.eeit168.forum.domain.CommentsBean;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.member.domain.MemberBean;

@Service
@Transactional(rollbackFor = {Exception.class})
public class CommentsAjaxService {
	@Autowired
	private CommentsDao commentsDao;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private PetArticleDao petArticleDao;
	
	public List<CommentsBean> findAll(){
		List<CommentsBean> findAll = commentsDao.select();
		return findAll;
	}
	public Boolean exists (Integer id) {
		return commentsDao.select(id)!=null;
	}
	
	public CommentsBean create(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null : obj.getInt("fkPetArticleId");
			String commentsText = obj.isNull("commentsText") ? null : obj.getString("commentsText");
		
			MemberBean memberId = memberDAO.select(fkMemberId);
			PetArticleBean petArticleId = petArticleDao.select(fkPetArticleId);
			
			if(memberId!= null && petArticleId!= null) {
				CommentsBean insert = new CommentsBean();
				insert.setFkMemberId(fkMemberId);
				insert.setFkPetArticleId(fkPetArticleId);
				insert.setCommentsText(commentsText);
				return commentsDao.insert(insert);			
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	public CommentsBean modify (String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
//		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
//		Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null : obj.getInt("fkPetArticleId");
			String commentsText = obj.isNull("commentsText") ? null : obj.getString("commentsText");
			CommentsBean commentsId = commentsDao.select(id);
			if(commentsId != null) {
				CommentsBean update = commentsDao.select(id);
				update.setCommentsText(commentsText);
				
				return commentsDao.update(update);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean remove(Integer id) {
		try {
			if(id!= null) {
				return commentsDao.delete(id);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
