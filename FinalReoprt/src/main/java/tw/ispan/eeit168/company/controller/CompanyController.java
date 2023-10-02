package tw.ispan.eeit168.company.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.company.domain.CompanyBean;

import tw.ispan.eeit168.company.service.CompanyService;

@RestController
@RequestMapping(path = "/pet_web")
@CrossOrigin
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping(path = "/companys/check")
	public String selectAccount(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		String account = obj.isNull("account") ? null : obj.getString("account");

		if (companyService.exists(account)) {
			responseJson.put("message", "帳號已存在");
			responseJson.put("success", false);
		} else {
			responseJson.put("message", "帳號可使用");
			responseJson.put("success", true);
		}

		return responseJson.toString();
	}

	@PostMapping(path = "/companys")
	public String create(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();

		JSONObject obj = new JSONObject(body);
		String account = obj.isNull("account") ? null : obj.getString("account");

		if (companyService.exists(account)) {
			responseJson.put("message", "帳號已存在");
			responseJson.put("success", false);
		} else {
			CompanyBean company = null;
			try {
				company = companyService.create(body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (company == null) {
				responseJson.put("message", "新增失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "新增成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}

	@PutMapping(path = "/companys/{account}")
	public String modify(@PathVariable("account") String account, @RequestBody String body) {
		JSONObject responseJson = new JSONObject();

		if (!companyService.exists(account)) {
			responseJson.put("message", "帳號不存在");
			responseJson.put("success", false);
		} else {
			CompanyBean company = null;
			Integer id = companyService.existsAccount(account).getId();
			try {
				company = companyService.modify(id, body);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (company == null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}

}
