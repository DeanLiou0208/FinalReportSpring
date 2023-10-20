package tw.ispan.eeit168.company.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.Base64Utils;
import tw.ispan.eeit168.company.dao.CompanyDao;
import tw.ispan.eeit168.company.domain.CompanyBean;

@Service
@Transactional(rollbackFor = { Exception.class })
public class CompanyService {
	@Autowired
	private CompanyDao companyDao;
	
	public boolean existsid(Integer id) {
		return companyDao.select(id) != null;
	}
	public CompanyBean selectById(Integer id) {
		return companyDao.select(id) ;
	}
	public boolean exists(String account) {
		return companyDao.selectByAccount(account) != null;
	}

	public CompanyBean existsAccount(String account) {
		return companyDao.selectByAccount(account);
	}

	public boolean existsShopName(String ShopName) {
		return companyDao.selectByShopName(ShopName);
	}

	public CompanyBean create(String json) {
		try {
			JSONObject obj = new JSONObject(json);

			String account = obj.isNull("account") ? null : obj.getString("account");
			String password = obj.isNull("password") ? null : obj.getString("password");
			String shopName = obj.isNull("shopName") ? null : obj.getString("shopName");

			CompanyBean insert = new CompanyBean();
			if (account != null && password != null && shopName != null) {
				insert.setAccount(account);
				insert.setPassword(password);
				insert.setShopName(shopName);
				return companyDao.insert(insert);
			}else {
				return null;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	public CompanyBean modify(Integer accountId, String json, MultipartFile file) {
		try {
			JSONObject obj = new JSONObject(json);
			Integer id = accountId != null ? accountId : null;
			String phone = obj.isNull("phone") ? null : obj.getString("phone");
			Integer texIdNumber = obj.isNull("texIdNumber") ? null : obj.getInt("texIdNumber");
			String address = obj.isNull("address") ? null : obj.getString("address");
			String email = obj.isNull("email") ? null : obj.getString("email");
			// 之後再改照片傳送
			String photo = null;
			if (file != null && !file.isEmpty()) {
				photo = Base64Utils.convertToBase64(file);
			}
			CompanyBean update = companyDao.select(id);
			update.setPhone(phone);
			update.setTaxIdNumber(texIdNumber);
			update.setAddress(address);
			update.setEmail(email);
			update.setImg(photo);

			return companyDao.update(update);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
