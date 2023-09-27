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
	public String create(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();

		JSONObject obj = new JSONObject(body);
		String account = obj.isNull("account") ? null : obj.getString("account");
		String password = obj.isNull("password") ? null : obj.getString("password");
		
		if (!loginService.exists(account)) {
			responseJson.put("message", "帳號或密碼錯誤");
			responseJson.put("success", false);
		} else {
			CompanyBean company = null;
			try {
				company = loginService.login(account,password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (company == null) {
				responseJson.put("message", "登入失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "登入成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}

}
