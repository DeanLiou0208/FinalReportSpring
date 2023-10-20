package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.CommentsLikePostViewDao;
import tw.ispan.eeit168.forum.dao.CommentsLikesDao;
import tw.ispan.eeit168.forum.domain.CommentsLikePostView;

@Service
@Transactional(rollbackFor = {Exception.class})
public class CommentsLikePostViewAjaxService {
	@Autowired
	private CommentsLikePostViewDao commentsLikePostViewDao;
	@Autowired
	private CommentsLikesDao commentsLikesDao;
	
	public List<CommentsLikePostView> findByPetArticleId(String json){
		try {
			JSONObject obj = new JSONObject(json);
			return commentsLikePostViewDao.selectByPetArticleId(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Integer> likeCommentRecord(String json){
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");

			return commentsLikesDao.commentLike(fkMemberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Integer> unlikeCommentRecord(String json){
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			
			return commentsLikesDao.commentUnlike(fkMemberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 
 
}
