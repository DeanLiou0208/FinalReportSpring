package tw.ispan.eeit168.forum.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.forum.dao.CommentsDao;
import tw.ispan.eeit168.forum.dao.CommentsPhotoDao;
import tw.ispan.eeit168.forum.domain.CommentsBean;
import tw.ispan.eeit168.forum.domain.CommentsPhotoBean;

@Service
@Transactional(rollbackFor = {Exception.class})
public class CommentsPhotoAjaxService {
	@Autowired
	private CommentsPhotoDao commentsPhotoDao;
	@Autowired
	private CommentsDao commentsDao;
	
	public List<CommentsPhotoBean> findAll(){
		List<CommentsPhotoBean> findAll = commentsPhotoDao.select();
		return findAll;
	}
	public Boolean exists (Integer id) {
		return commentsPhotoDao.selectById(id)!= null;
	}
	public List<CommentsPhotoBean> findByCommentsId(Integer fkCommentsId){
		return commentsPhotoDao.select(fkCommentsId);
	}
	
	public CommentsPhotoBean create(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkCommentsId = obj.isNull("fkCommentsId")? null : obj.getInt("fkCommentsId");
			String img = obj.isNull("img")? null : obj.getString("img");
			CommentsBean commentsId = commentsDao.select(fkCommentsId);
			if(commentsId!= null) {
				CommentsPhotoBean insert = new CommentsPhotoBean();
				insert.setFkCommentsId(fkCommentsId);
				insert.setImg(img);
				
				return commentsPhotoDao.insert(insert);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public CommentsPhotoBean modify(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer id = obj.isNull("id") ? null : obj.getInt("id");
			Integer fkCommentsId = obj.isNull("fkCommentsId")? null : obj.getInt("fkCommentsId");
			String img = obj.isNull("img")? null : obj.getString("img");
			CommentsPhotoBean update = commentsPhotoDao.selectById(id);
			update.setFkCommentsId(fkCommentsId);
			update.setImg(img);
			
			return commentsPhotoDao.update(update);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Boolean remove(Integer id) {
		try {
			if(id != null) {
				return commentsPhotoDao.delete(id);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
