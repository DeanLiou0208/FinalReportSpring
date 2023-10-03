package tw.ispan.eeit168.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import jakarta.transaction.Transactional;
import tw.ispan.eeit168.shop.dao.IndexProductsPhotoDAO;
import tw.ispan.eeit168.shop.domain.IndexProductsPhotoView;

@Service
@Transactional(rollbackOn = Exception.class)
public class IndexProductsPhotoService {
	@Autowired
	private IndexProductsPhotoDAO indexProductsPhotoDAO;
	
	public String findTopfive(){
		
		List<IndexProductsPhotoView> findAll = indexProductsPhotoDAO.selectTopFive();
		String json = new Gson().toJson(findAll);
		
		
		
		return json;
	}
	
	
}
