package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.ispan.eeit168.forum.dao.ArticleLikesDao;
import tw.ispan.eeit168.forum.dao.CommentsLikePostViewDao;
import tw.ispan.eeit168.forum.dao.PetArticleDao;
import tw.ispan.eeit168.forum.dao.PetArticlePhotoDao;
import tw.ispan.eeit168.forum.dao.PetArticlePostViewDao;
import tw.ispan.eeit168.forum.dao.SpeciesViewsViewDao;
import tw.ispan.eeit168.forum.domain.ArticleLikesBean;
import tw.ispan.eeit168.forum.domain.CommentsLikePostView;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;
import tw.ispan.eeit168.forum.domain.SpeciesViewsView;
import tw.ispan.eeit168.forum.domain.PetArticlePostView;

@Service
@Transactional(rollbackFor = {Exception.class})
public class PetArticlePostViewAjaxService {
	@Autowired
	private PetArticlePostViewDao petArticlePostViewDao;
	@Autowired
	private PetArticlePhotoDao petArticlePhotoDao;
	@Autowired
	private SpeciesViewsViewDao speciesViewsViewDao; 
	@Autowired
	private CommentsLikePostViewDao commentsLikePostViewDao;
	@Autowired
	private ArticleLikesDao articleLikesDao;
	@Autowired
	private PetArticleDao petArticleDao;
	
	public PetArticlePostView findById(Integer id) {
		PetArticlePostView byId = petArticlePostViewDao.selectById(id);
		return byId;
	}
	
	public long count (Integer memberId) {
		return petArticlePostViewDao.count(memberId);
	}
	
	public List<PetArticlePostView> findByMemberId(String json){
		
			try {
				JSONObject obj = new JSONObject(json);
					return petArticlePostViewDao.selectByMemberId(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}return null;
	}
	//找出寵物文章照片
	public List<PetArticlePhotoBean> findMyPetArticlePhoto(Integer fkPetArticleId) {
//		System.out.println(fkPetArticleId);
		return petArticlePhotoDao.selectByPetArticleId(fkPetArticleId);
	}
	//找出寵物文章寵物物種
	public List<SpeciesViewsView> findPetArticleSpecies(Integer fkPetArticleId){
		return speciesViewsViewDao.selectByArticleIds(fkPetArticleId);
	}
	//找出寵物文章下面的留言
//  SELECT * FROM comments_like_post WHERE　fk_pet_article_id = 2 ORDER BY create_at DESC
	public List<CommentsLikePostView> findPetArticleComments(String json){
		try {
			JSONObject obj = new JSONObject(json);
			return commentsLikePostViewDao.selectByPetArticleId(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Integer> likeRecord(String json){
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");

			return articleLikesDao.petArticleLike(fkMemberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Integer> unlikeRecord(String json){
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			
			return articleLikesDao.petArticleUnlike(fkMemberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

 
	
}
 