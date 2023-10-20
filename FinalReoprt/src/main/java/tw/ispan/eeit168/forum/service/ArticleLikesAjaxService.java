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
	
	public ArticleLikesBean create(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			Integer fkPetArticleId = obj.isNull("fkPetArticleId") ? null : obj.getInt("fkPetArticleId");
			Boolean likeOrUnlike = obj.isNull("likeOrUnlike") ? null : obj.getBoolean("likeOrUnlike");
//			System.out.println("1="+fkMemberId);
			MemberBean memberId = memberDAO.select(fkMemberId);
			PetArticleBean petArticleId = petArticleDao.select(fkPetArticleId);
			if(memberId!= null && petArticleId!= null) {
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
	
	public Boolean remove(Integer id) {
       
		try {
			if(id!=null) {
				
				return articleLikesBeanDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}