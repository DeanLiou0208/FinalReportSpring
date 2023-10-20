package tw.ispan.eeit168.company.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.company.domain.CompanyBean;
import tw.ispan.eeit168.company.service.LoginService;

@RestController
@RequestMapping(path = "/pet_web/login")
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping(path = "/login")
	public String login(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();

		JSONObject obj = new JSONObject(body);
		String account = obj.isNull("account") ? null : obj.getString("account");
		String password = obj.isNull("password") ? null : obj.getString("password");
		
		if (!loginService.exists(account)) {
			responseJson.put("message", "帳號或密碼錯誤");
			responseJson.put("success", false);
		} else {
			CompanyBean company = null;
			Object object = null;
			boolean isLock=false;
			try {
				 object= loginService.login(account,password);
				 if(object instanceof CompanyBean) {
					 company=(CompanyBean)object;
					 System.out.println(isLock);
					 System.out.println(company);
				 }else if(object instanceof Boolean) {
					 isLock=(boolean)object;
					 System.out.println(isLock);
					 System.out.println(company);
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(isLock) {
				responseJson.put("message", "帳號已被凍結，請稍後再嘗試登入。");
				responseJson.put("success", false);
			}else if (!isLock && company == null) {
				responseJson.put("message", "帳號或密碼錯誤");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "登入成功");
				responseJson.put("success", true);
				responseJson.put("identity", "廠商");
				responseJson.put("account", company.getAccount());
				responseJson.put("username", company.getShopName());
				responseJson.put("id", company.getId());
				responseJson.put("img", company.getImg());
			}
		}
		return responseJson.toString();
	}

}
