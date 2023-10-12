package tw.ispan.eeit168.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import tw.ispan.eeit168.shop.dao.ProductSelectTypeBeanDao;
import tw.ispan.eeit168.shop.domain.ProductSelectTypeBean;


@Service
@Transactional(rollbackFor = {Exception.class})
public class ProductSelectTypeService {
	
	@Autowired
	private ProductSelectTypeBeanDao productSelectTypeBeanDao;
	
	public String findAll() {
		
		List<ProductSelectTypeBean> select = productSelectTypeBeanDao.select();
		
		String json = new Gson().toJson(select);
		
		return json;
	}
	
}
