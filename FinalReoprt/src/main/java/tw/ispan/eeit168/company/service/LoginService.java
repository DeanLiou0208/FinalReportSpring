package tw.ispan.eeit168.company.service;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.company.dao.CompanyDao;
import tw.ispan.eeit168.company.domain.CompanyBean;
import tw.ispan.eeit168.company.util.SecurityProperties;

@Service
@Transactional(rollbackFor = { Exception.class })
public class LoginService {
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private SecurityProperties securityProperties;

	public boolean exists(String account) {
		return companyDao.selectByAccount(account) != null;
	}

	public Object login(String username, String password) {
		if (password != null && password.length() != 0) {
			CompanyBean bean = companyDao.selectByAccount(username);
			CompanyBean update = companyDao.select(bean.getId());
			if (bean != null) {
				if (bean.getIsLock()) {
					// 帳號已經被凍結
					Timestamp lockoutTime = bean.getLockTime();
					Timestamp now = new Timestamp(System.currentTimeMillis());
					long lockoutDurationMillis = TimeUnit.MINUTES
							.toMillis(securityProperties.getLockoutDurationMinutes());

					if (now.getTime() - lockoutTime.getTime() >= lockoutDurationMillis) {
						// 如果已經過了凍結時間，可以解除帳號的凍結
						bean.setIsLock(false);
						bean.setLoginCount(0); // 重置登入錯誤次數
						companyDao.update(bean);
						System.out.println(bean);
						if (password.equals(bean.getPassword())) {
							update.setLoginCount(0);
							companyDao.update(bean);
							return bean;
						} else if (!password.equals(bean.getPassword())) {
							int loginCount = bean.getLoginCount() + 1;
							update.setLoginCount(loginCount);
						}
					} else {
						// 帳號仍然凍結中
						return true;
					}
				} else if (password.equals(bean.getPassword())) {
					// 登入成功，重置錯誤次數
					update.setLoginCount(0);
					companyDao.update(bean);
					return bean;
				} else if (!password.equals(bean.getPassword())) {
					int loginCount = bean.getLoginCount() + 1;
					update.setLoginCount(loginCount);

					if (loginCount >= securityProperties.getMaxLoginAttempts()) {
						// 超過最大嘗試次數，設定帳號的凍結標誌為 true
						bean.setIsLock(true);
						// 記錄凍結時間
						bean.setLockTime(new Timestamp(System.currentTimeMillis()));
						companyDao.update(bean);
						return true;
					}
				}
			}
		}
		return null;
	}

}
