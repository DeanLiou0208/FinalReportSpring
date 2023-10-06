package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.CommentsLikesDao;
import tw.ispan.eeit168.forum.domain.CommentsLikesBean;

@Service
@Transactional(rollbackFor = {Exception.class})
public class CommentsLikesAjaxService {
	@Autowired
	private CommentsLikesDao commentsLikesDao;
	
	public List<CommentsLikesBean> select(Integer fkMemberId){
		return commentsLikesDao.select(fkMemberId);
	}
	public List<CommentsLikesBean> selectByCommentId(Integer fkCommentId){
		return commentsLikesDao.selectByCommentId(fkCommentId);
	}
	public CommentsLikesBean create(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId")? null : obj.getInt("fkMemberId");
			Integer fkCommentId = obj.isNull("fkCommentId")? null : obj.getInt("fkCommentId");
			Boolean likeOrUnlike = obj.isNull("likeOrUnlike")? null : obj.getBoolean("likeOrUnlike");
			
			CommentsLikesBean insert = new CommentsLikesBean();
			insert.setFkMemberId(fkMemberId);
			insert.setFkCommentId(fkCommentId);
			insert.setLikeOrUnlike(likeOrUnlike);
			
			return commentsLikesDao.insert(insert);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public boolean remove(Integer fkMemberId, Integer fkCommentId) {
		try {
			return commentsLikesDao.delete(fkMemberId, fkCommentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
