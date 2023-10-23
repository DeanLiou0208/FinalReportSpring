package tw.ispan.eeit168.forum.service;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.Base64Utils;
import tw.ispan.eeit168.forum.dao.CommentsDao;
import tw.ispan.eeit168.forum.dao.CommentsPhotoDao;
import tw.ispan.eeit168.forum.dao.PetArticleDao;
import tw.ispan.eeit168.forum.domain.CommentsBean;
import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;
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
	@Autowired
	private CommentsPhotoDao commentsPhotoDao;
	
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
//			CommentsBean newComment = null;
			if(memberId!= null && petArticleId!= null ) {
//				if(commentsText!=null && !commentsText.isEmpty()) {
					CommentsBean insert = new CommentsBean();
					insert.setFkMemberId(fkMemberId);
					insert.setFkPetArticleId(fkPetArticleId);
					insert.setCommentsText(commentsText);
					return commentsDao.insert(insert);			
					
				}
//			}
//			Integer commentId = newComment.getId();
//			String photo = null;
//			if(file != null) {
//				photo = Base64Utils.convertToBase64(file);
//				System.out.println(photo);
//				  CommentsPhotoBean insert = new CommentsPhotoBean();
//				  insert.setFkCommentsId(commentId);
//				  insert.setImg(photo);
//				  
//				  commentsPhotoDao.insert(insert);	 
//			}
//			return newComment;
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public CommentsBean modify (String json ,MultipartFile file) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
//		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
//		Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null : obj.getInt("fkPetArticleId");
			String commentsText = obj.isNull("commentsText") ? null : obj.getString("commentsText");
			CommentsBean commentsId = commentsDao.select(id);
//			修改留言照片
			String photo = null;
			if(file != null) {
				photo = Base64Utils.convertToBase64(file);
//				System.out.println(photo);
				CommentsPhotoBean update = new CommentsPhotoBean();
				update.setFkCommentsId(id);
				update.setImg(photo);
				commentsPhotoDao.update(update);	 
			}
//			修改留言
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
				boolean delete = commentsPhotoDao.delete(id);
				boolean deleteComment = commentsDao.delete(id);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean removeByPetArticleId(Integer fkPetArticleId) {
		try {
			if(fkPetArticleId!=null) {
				return commentsDao.deleteByPetArticleId(fkPetArticleId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

}
