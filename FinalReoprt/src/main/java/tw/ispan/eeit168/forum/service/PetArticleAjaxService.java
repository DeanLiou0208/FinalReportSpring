package tw.ispan.eeit168.forum.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.Base64Utils;
import tw.ispan.eeit168.forum.dao.ArticleLikesDao;
import tw.ispan.eeit168.forum.dao.CommentsDao;
import tw.ispan.eeit168.forum.dao.CommentsLikesDao;
import tw.ispan.eeit168.forum.dao.PetArticleDao;
import tw.ispan.eeit168.forum.dao.PetArticlePhotoDao;
import tw.ispan.eeit168.forum.dao.PetArticleSpeciesMidDao;
import tw.ispan.eeit168.forum.dao.SpeciesViewsViewDao;
import tw.ispan.eeit168.forum.domain.CommentsBean;
import tw.ispan.eeit168.forum.domain.PetArticleBean;
import tw.ispan.eeit168.forum.domain.PetArticlePhotoBean;
import tw.ispan.eeit168.forum.domain.PetArticleSpeciesMidBean;
import tw.ispan.eeit168.forum.domain.SpeciesViewsView;
import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.member.domain.MemberBean;

@Service
@Transactional(rollbackFor = { Exception.class })
public class PetArticleAjaxService {
	@Autowired
	private PetArticleDao petArticleDao;
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private PetArticleSpeciesMidDao petArticleSpeciesMidDao; 
	@Autowired
	private PetArticlePhotoDao petArticlePhotoDao;
	@Autowired
	private SpeciesViewsViewDao speciesViewsViewDao;
	@Autowired
	private CommentsLikesDao commentsLikesDao;
	@Autowired
	private ArticleLikesDao articleLikesDao;
	@Autowired
	private CommentsDao commentsDao;
	

	
	public List<PetArticleBean> findAll() {
		List<PetArticleBean> finaAll = petArticleDao.select();
		return finaAll;
	}
	public PetArticleBean findById(Integer id) {
		return petArticleDao.select(id);
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
//		System.out.println(byTime);
		return byTime;
	}
	//找出寵物文章照片
		public List<PetArticlePhotoBean> findMyPetArticlePhoto(Integer fkPetArticleId) {
//			System.out.println(fkPetArticleId);
			return petArticlePhotoDao.selectByPetArticleId(fkPetArticleId);
		}
		//找出寵物文章寵物物種
		public List<SpeciesViewsView> findPetArticleSpecies(Integer fkPetArticleId){
			return speciesViewsViewDao.selectByArticleIds(fkPetArticleId);
		}
	
	public PetArticleBean create(String json,MultipartFile[] files) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String type = obj.isNull("type") ? null : obj.getString("type");
			String title = obj.isNull("title") ? null : obj.getString("title");
			String petArticleText = obj.isNull("petArticleText") ? null : obj.getString("petArticleText");
			
			PetArticleBean newpetArticle = null;
			Map<Integer, String> photos = new HashMap<Integer, String>();
			if(fkMemberId!=null && type!=null && title!=null && petArticleText!=null ) {
				PetArticleBean insert = new PetArticleBean();
				insert.setFkMemberId(fkMemberId);
				insert.setType(type);
				insert.setTitle(title);
				insert.setPetArticleText(petArticleText);
				
				newpetArticle = petArticleDao.insert(insert);
			}
//			新增多筆寵物物種
			Integer fkPetArticleId = newpetArticle.getId();
			JSONArray speciesIdArray = obj.optJSONArray("speciesId");
			if (speciesIdArray != null) {
	            // 如果存在，将其转换为一个 List<Integer>
	            List<Integer> speciesIds = new ArrayList<>();
	            for (int i = 0; i < speciesIdArray.length(); i++) {
	                speciesIds.add(speciesIdArray.getInt(i));
	            }
	            if(speciesIds!=null) {
	            	for(Integer speciesId:speciesIds) {
	            		PetArticleSpeciesMidBean insert = new PetArticleSpeciesMidBean();
	            		insert.setFkPetArticleId(fkPetArticleId);
	            		insert.setFkPetArticleSpeciesId(speciesId);
	            		petArticleSpeciesMidDao.insert(insert);
	            	}
	            }
//	            新增多筆寵物文章照片
	            if(files !=null) {
	            	photos = Base64Utils.convertToBase64(files);
	            	for(Entry<Integer, String> photo : photos.entrySet()) {
	            		PetArticlePhotoBean insert = new PetArticlePhotoBean();
	            		insert.setFkPetArticleId(fkPetArticleId);
	            		if(photo.getKey().equals(1)) {
	            			insert.setMain(true);
	            		}else {
	            			insert.setMain(null);
	            		}
	            		insert.setImg(photo.getValue());
	            		petArticlePhotoDao.insert(insert);
	            	}
	            }
			}
	            return newpetArticle;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PetArticleBean modify(String json,MultipartFile[] files) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
		    Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String type = obj.isNull("type") ? null : obj.getString("type");
			String title = obj.isNull("title") ? null : obj.getString("title");
			String petArticleText = obj.isNull("petArticleText") ? null : obj.getString("petArticleText");
//			先刪除原本的寵物物種再新增多筆寵物物種
			boolean deleteSpecies = petArticleSpeciesMidDao.deleteByArticleId(id);
			JSONArray speciesIdArray = obj.optJSONArray("speciesId");
//			System.out.println(speciesIdArray);
			if (speciesIdArray != null) {
	            // 如果存在，将其转换为一个 List<Integer>
	            List<Integer> speciesIds = new ArrayList<>();
	            for (int i = 0; i < speciesIdArray.length(); i++) {
	                speciesIds.add(speciesIdArray.getInt(i));
	            }
	            if(speciesIds!=null) {
	            	for(Integer speciesId:speciesIds) {
	            		PetArticleSpeciesMidBean insert = new PetArticleSpeciesMidBean();
	            		insert.setFkPetArticleId(id);
	            		insert.setFkPetArticleSpeciesId(speciesId);
	            		petArticleSpeciesMidDao.insert(insert);
	            	}
	            }
			}
			Map<Integer, String> photos = new HashMap<Integer, String>();
//			先刪除原本寵物文章照片
			Boolean deletePhoto = petArticlePhotoDao.deleteByPetArticleId(id);
//          新增多筆寵物文章照片
            if(files !=null) {
            	photos = Base64Utils.convertToBase64(files);
//            	System.out.println(456);
            	for(Entry<Integer, String> photo : photos.entrySet()) {
            		PetArticlePhotoBean insert = new PetArticlePhotoBean();
            		insert.setFkPetArticleId(id);
            		if(photo.getKey().equals(1)) {
            			insert.setMain(true);
            		}else {
            			insert.setMain(null);
            		}
            		insert.setImg(photo.getValue());
            		petArticlePhotoDao.insert(insert);
            	}
            }
			
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
				List<CommentsBean> comments = commentsDao.selectByPetArticleId(id);
//				刪除commentsLike
			    for(CommentsBean comment : comments) {
			    	Integer commentId = comment.getId();
			    	commentsLikesDao.delete(commentId);
			    }
			    commentsDao.deleteByPetArticleId(id);
			    
			    articleLikesDao.delete(id);
				petArticleSpeciesMidDao.deleteByArticleId(id);
				petArticlePhotoDao.deleteByPetArticleId(id);
				petArticleDao.delete(id);
				return true;
							}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
