package tw.ispan.eeit168.company.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.company.domain.CompanyBean;

import tw.ispan.eeit168.company.service.CompanyService;

@RestController
@RequestMapping(path = "/pet_web")
@CrossOrigin
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping(path = "/companys/check-account")
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

	@PostMapping(path = "/companys/check-shopname")
	public String selectShopNAme(@RequestBody String body) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		String shopName = obj.isNull("shopName") ? null : obj.getString("shopName");
//System.out.println(shopName);
		if (companyService.existsShopName(shopName)) {
			responseJson.put("message", "店名已被註冊");
			responseJson.put("success", false);
		} else {
			responseJson.put("message", "可使用");
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
				responseJson.put("registershopname", company.getShopName());
				responseJson.put("registerid", company.getId());
			}
		}
		return responseJson.toString();
	}

	@PutMapping(path = "/companys/information")
	public String modify(@RequestParam(value="file",required = false) MultipartFile file, String body) {
	
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
	
		Integer id = obj.isNull("id") ? null : obj.getInt("id");
		if (!companyService.existsid(id)) {
			responseJson.put("message", "帳號不存在");
			responseJson.put("success", false);
		} else {
			CompanyBean company = null;
			try {
				company = companyService.modify(id, body, file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (company == null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
				responseJson.put("message2", "註冊成功");
				responseJson.put("img", company.getImg());
			}
		}
		return responseJson.toString();
	}
@GetMapping(path = "/companys/information/{id}")
public CompanyBean select(@PathVariable Integer id) {
	
//	JSONObject responseJson = new JSONObject();
//	JSONArray arrayBreeds = new JSONArray();
	CompanyBean company =null;
	try {
		if(companyService.existsid(id)) {
			company=companyService.selectById(id);
		}else {
			return null;
		}
		if(company!=null) {
			return company;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
	return null;
}
}
