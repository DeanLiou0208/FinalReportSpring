package tw.ispan.eeit168.member.service;

import java.sql.Timestamp;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.member.domain.MemberBean;
import tw.ispan.eeit168.member.util.DatetimeConverter;

@Service
@Transactional(rollbackFor={Exception.class})
public class MemberService {
	@Autowired
	private MemberDAO memberDAO = null; 
	
	public MemberBean exists(String account) {		
		return memberDAO.select(account);
	}
	
	public Integer accountVerification(String json) {
		try {
			//取出帳號密碼 確認是否與資料庫吻合
			JSONObject obj = new JSONObject(json);
			String account = obj.isNull("account") ? null : obj.getString("account");
			String password = obj.isNull("password") ? null : obj.getString("password");	
			//吻合回傳primary key 否則回傳null
			Integer id = memberDAO.select(account,password);
			return id; 
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
	
	public MemberBean modify(Integer memberid, String json) {
		try {
			Integer id = memberid!=null ? memberid : null;
			JSONObject obj = new JSONObject(json);
			
			String firstName = obj.isNull("firstName") ? null : obj.getString("firstName");
			String lastName = obj.isNull("lastName") ? null : obj.getString("lastName");
			String userName = obj.isNull("userName") ? null : obj.getString("userName");
//			String shopName = obj.isNull("shopName") ? null : obj.getString("shopName");
			
			Boolean gender = obj.isNull("gender") ? null : obj.getBoolean("gender");
			String birth = obj.isNull("birth") ? null : obj.getString("birth");
			String phone = obj.isNull("phone") ? null : obj.getString("phone");
			String address = obj.isNull("address") ? null : obj.getString("address");
			String email = obj.isNull("email") ? null : obj.getString("email");
			
			String img = obj.isNull("img") ? null : obj.getString("img");

			MemberBean update = memberDAO.select(id);
			update.setFirstName(firstName);
			update.setLastName(lastName);
			update.setUserName(userName);
			update.setGender(gender);
			update.setBirth(DatetimeConverter.parse(birth, "yyyy-MM-dd"));
			update.setPhone(phone);
			update.setAddress(address);
			update.setEmail(email);
			update.setUpdateAt(new Timestamp(System.currentTimeMillis()));
			update.setImg(img);
			
			return memberDAO.update(update);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
}
