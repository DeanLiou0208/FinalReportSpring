package tw.ispan.eeit168.member.service;

import java.sql.Timestamp;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.ispan.eeit168.Base64Utils;
import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.member.domain.MemberBean;
import tw.ispan.eeit168.member.util.DatetimeConverter;

@Service
@Transactional(rollbackFor={Exception.class})
public class MemberService {
	@Autowired
	private MemberDAO memberDAO = null; 
	
	public Boolean exists(Integer id) {
		return memberDAO.select(id) != null;
	}
	
	public Boolean exists(String account) {
		return memberDAO.select(account) != null;
	}
	
	public MemberBean find(String account) {		
		return memberDAO.select(account);
	}
	
	public Integer findId(String account) {		
		return memberDAO.selectById(account);
	}

//	public JSONObject doLogin(String account, String password, HttpServletRequest request, HttpServletResponse response) {
//		// 最終返回的對象
//	    JSONObject res = new JSONObject();
//	    res.put("success", false);
//	    if (account == null || password == null) {
//	        res.put("message", "請輸入帳號或密碼");
//	        return res;
//	    }
//	    MemberBean dbUser = memberDAO.select(account);
//	    if (null == dbUser) {
//	        res.put("message", "該賬號不存在，請檢查後重試");
//	        return res;
//	    }
//	    
//	    // 驗證密碼是否正確
//	    if (!dbUser.getPassword().equals(password)) {
//	        res.put("message", "手機號或密碼錯誤，請檢查後重試");
//	        return res;
//	    }
//	    // 判斷賬戶狀態
//	    // 將登錄用戶信息保存到session中
//	    request.getSession().setAttribute("account", dbUser.getAccount());
//	    request.getSession().setAttribute("password", dbUser.getPassword());
//	    // 保存cookie，實現自動登錄
//	    Cookie cookie_username = new Cookie("cookie_username", account);
//	    // 設置cookie的持久化時間，30天
//	    cookie_username.setMaxAge(30 * 24 * 60 * 60);
//	    // 設置爲當前項目下都攜帶這個cookie
//	    cookie_username.setPath("/");
////	    cookie_username.setPath(request.getContextPath());
//	    // 向客戶端發送cookie
//	    response.addCookie(cookie_username);
////	    response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
////	    response.setHeader("Access-Control-Allow-Credentials", "true");
////	    response.setHeader("Access-Control-Expose-Headers", "Set-Cookie");
//	    res.put("success", true);
//	    res.put("message", "登錄成功");
//	    return res;
//	}
	
	public MemberBean accountVerification(String account,String password) {
		try {
			//吻合回傳primary key 否則回傳null
			MemberBean member = memberDAO.select(account);
			if(member != null) {
				if(member.getPassword().equals(password)) {		
					return member; 
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public MemberBean createMember(String json) {
		try {
			JSONObject obj = new JSONObject(json);
			String account = obj.isNull("account") ? null : obj.getString("account");
			String password = obj.isNull("password") ? null : obj.getString("password");
			if(account != null && password != null && account.length()!=0 && password.length()!=0) {				
				MemberBean insert = new MemberBean();
				insert.setAccount(account);
				insert.setPassword(password);
				return memberDAO.insert(insert);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public MemberBean modify(Integer memberid, String json, MultipartFile file) {
		try {
			Integer id = memberid!=null ? memberid : null;
			JSONObject obj = new JSONObject(json);
			
			String firstName = obj.isNull("firstName") ? null : obj.getString("firstName");
			String lastName = obj.isNull("lastName") ? null : obj.getString("lastName");
			String userName = obj.isNull("userName") ? null : obj.getString("userName");
//			String shopName = obj.isNull("shopName") ? null : obj.getString("shopName");
			
			Boolean gender = obj.isNull("gender") ? null : obj.getBoolean("gender");
			String birth = obj.isNull("birth") ? null : obj.getString("birth");
			String phone1 = obj.isNull("phone1") ? null : obj.getString("phone1");
			String phone2 = obj.isNull("phone2") ? null : obj.getString("phone2");
			String phone3 = obj.isNull("phone3") ? null : obj.getString("phone3");
			String address = obj.isNull("address") ? null : obj.getString("address");
			String email = obj.isNull("email") ? null : obj.getString("email");

			String photo = null;
			if(file != null && !file.isEmpty()) {
				photo = Base64Utils.convertToBase64(file);
			}
			MemberBean update = memberDAO.select(id);
			update.setFirstName(firstName);
			update.setLastName(lastName);
			update.setUserName(userName);
			update.setGender(gender);
			if(birth != null) {				
				update.setBirth(DatetimeConverter.parse(birth, "yyyy-MM-dd"));
			}else {
				update.setBirth(null);
			}
			if(phone1 != null && phone2 != null && phone3 != null) {
				String phone = phone1 + "-" + phone2 + "-" + phone3;
				update.setPhone(phone);
			}else {
				update.setPhone(null);
			}		
			update.setAddress(address);
			update.setEmail(email);
			update.setUpdateAt(new Timestamp(System.currentTimeMillis()));
			update.setImg(photo);
			
			return memberDAO.update(update);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public Boolean modifyPassword(String account, String password) {
		if(account!=null && password!=null && account.length()!=0 && password.length()!=0) {	
			System.out.println(password);
			Boolean a = memberDAO.updatePassword(account, password);
			System.out.println(a);
			return a;
		}
		return null;
	}
	
	
}
