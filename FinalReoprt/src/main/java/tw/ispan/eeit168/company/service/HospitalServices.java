package tw.ispan.eeit168.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.company.dao.HospitalDao;
import tw.ispan.eeit168.company.domain.HospitalBean;

@Service
@Transactional(rollbackFor = { Exception.class })
public class HospitalServices {
	@Autowired
	private HospitalDao hospitaldao;
	
	
	
	public List<HospitalBean> hospotal(){
		
		
			
			return	hospitaldao.select();
		
		
	}
}
