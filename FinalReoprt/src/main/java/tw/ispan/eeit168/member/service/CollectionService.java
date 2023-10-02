package tw.ispan.eeit168.member.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.dao.CollectionDAO;
import tw.ispan.eeit168.member.dao.CollectionPetArticleDao;
import tw.ispan.eeit168.member.dao.CollectionProductDao;
import tw.ispan.eeit168.member.domain.CollectionBean;
import tw.ispan.eeit168.member.domain.CollectionPetArticleView;
import tw.ispan.eeit168.member.domain.CollectionProductView;

@Service
@Transactional(rollbackFor={Exception.class})
public class CollectionService {
	@Autowired
	private CollectionDAO collectionDAO;
	@Autowired
	private CollectionPetArticleDao collectionPetArticleDao;
	@Autowired
	private CollectionProductDao collectionProductDao;
	
	//確認存在
	public CollectionBean exists(Integer fkMemberId,String fkUid) {		
		return collectionDAO.select(fkMemberId, fkUid);
	}
	
	//新增收藏
	public CollectionBean createCollect(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String fkUid = obj.isNull("fk_uid") ? null : obj.getString("fk_uid");
			CollectionBean insert = new CollectionBean();
			insert.setFkMemberId(fkMemberId);
			insert.setFkUid(fkUid);
			return collectionDAO.insert(insert);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null; 
	}
	
	//刪除收藏
	public boolean removeCollect(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
			String fkUid = obj.isNull("fkUid") ? null : obj.getString("fkUid");
			return collectionDAO.delete(fkMemberId,fkUid);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}

	
	//找出個人文章收藏
	public List<CollectionPetArticleView> findCollectArticle(Integer id) {
		return collectionPetArticleDao.select(); 
	}
	//找出個人產品收藏
	public List<CollectionProductView> findCollectProduct(Integer id) {
		return collectionProductDao.select(); 
	}




}
