package tw.ispan.eeit168.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.company.dao.MyShopViewDao;
import tw.ispan.eeit168.company.domain.MyShopView;

@Service
@Transactional(rollbackFor = { Exception.class })
public class MyShopViewService {
	@Autowired
	private MyShopViewDao myShopViewDao;
	
	public List<MyShopView> myShopProduct(String shopName){
		
		if(shopName!=null&&shopName.length()!=0) {
			
			return	myShopViewDao.selectByShopName(shopName);
		}
		return null;		
	}
	
	
}
