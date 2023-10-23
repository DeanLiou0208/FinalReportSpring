package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.ArticleLikesDao;
import tw.ispan.eeit168.forum.dao.PetArticleDao;
import tw.ispan.eeit168.forum.domain.ArticleLikesBean;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.member.domain.MemberBean;
import tw.ispan.eeit168.shop.util.DoublePrimaryKey;

@Service
@Transactional(rollbackFor = {Exception.class})
public class ArticleLikesAjaxService {
	@Autowired
	private ArticleLikesDao articleLikesBeanDao;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private PetArticleDao petArticleDao;
	
	public  List<ArticleLikesBean> findByMemberId (Integer fkMemberId){
		return articleLikesBeanDao.selectLikeByMemberId(fkMemberId);
	}
	
	public  List<ArticleLikesBean> findByFkPetArticleId (Integer fkPetArticleId){
		return articleLikesBeanDao.selectLikeByFkPetArticleId(fkPetArticleId);
	}
	
	public ArticleLikesBean createLike(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			Integer fkPetArticleId = obj.isNull("petArticleId") ? null : obj.getInt("petArticleId");
			Boolean likeOrUnlike = obj.isNull("likeOrUnlike") ? null : obj.getBoolean("likeOrUnlike");
//			System.out.println("1="+fkMemberId);
			
			if(fkMemberId!= null && fkPetArticleId!= null) {
				ArticleLikesBean insert = new ArticleLikesBean();
				insert.setFkPetArticleId(fkPetArticleId);
				insert.setFkMemberId(fkMemberId);
				insert.setLikeOrUnlike(likeOrUnlike);
				
				return articleLikesBeanDao.insert(insert);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArticleLikesBean modifyLike(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			Integer fkPetArticleId = obj.isNull("petArticleId") ? null : obj.getInt("petArticleId");
			Boolean likeOrUnlike = obj.isNull("likeOrUnlike") ? null : obj.getBoolean("likeOrUnlike");
//			System.out.println("1="+fkMemberId);
			
			if(fkMemberId!= null && fkPetArticleId!= null) {
				ArticleLikesBean update = new ArticleLikesBean();
				update.setFkPetArticleId(fkPetArticleId);
				update.setFkMemberId(fkMemberId);
				update.setLikeOrUnlike(likeOrUnlike);
				
				return articleLikesBeanDao.update(update);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean remove(Integer id ) {
       
		try {
			if(id!=null) {
				
				return articleLikesBeanDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean removeLike(Integer fkMemberId, Integer petArticleId) {
		try {
			if(fkMemberId!=null && petArticleId!=null) {
				return articleLikesBeanDao.deleteLike(fkMemberId, petArticleId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

