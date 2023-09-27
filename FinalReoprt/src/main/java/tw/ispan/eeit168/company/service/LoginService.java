package tw.ispan.eeit168.company.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.company.dao.CompanyDao;
import tw.ispan.eeit168.company.domain.CompanyBean;
@Service
@Transactional(rollbackFor = { Exception.class })
public class LoginService {
	@Autowired
	private CompanyDao companyDao;
	
	public boolean exists(String account) {
		return companyDao.selectByAccount(account) != null;
	}
	
	public CompanyBean login(String username, String password) {
		if(password!=null && password.length()!=0) {
			CompanyBean bean = companyDao.selectByAccount(username);
			if(bean!=null) {
			
				if(password.equals(bean.getPassword())) {
					return bean;
				}
			}
		}
		return null;
	}
	
	
}
