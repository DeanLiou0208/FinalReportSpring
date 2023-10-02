package tw.ispan.eeit168.member.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.ispan.eeit168.member.domain.MemberBean;
import tw.ispan.eeit168.member.service.MemberService;

@RestController
@RequestMapping(path = "/pages/member")
@CrossOrigin
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//登入
	@PostMapping(path = "/login")
	public String login(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		
		if(memberService.accountVerification(json) != null) {
			responseJson.put("message", "登入成功");
			responseJson.put("success", true);
		} else {
			responseJson.put("message", "登入失敗，帳號或密碼錯誤");
			responseJson.put("success", false);
		}
		return responseJson.toString();
	}
	
	//建立帳號
	@PostMapping(path = "/register")
	public String register(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(json);
		String account = obj.isNull("account") ? null : obj.getString("account");
		
		if(memberService.exists(account) != null) {
			responseJson.put("message", "帳號重複");
			responseJson.put("success", false);
		} else {
			MemberBean member = null;
			try {
				member = memberService.createMember(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(member==null) {
				responseJson.put("message", "新增失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "新增成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
	
	//撈出個資
	@GetMapping(path="/information/exists/{account}")
	public String exist(@PathVariable(name = "account") String account) {
		JSONObject responseJson = new JSONObject();
		MemberBean member = memberService.exists(account);
		if(member != null) {			
			responseJson.put("account", member.getAccount());
			responseJson.put("first_name", member.getFirstName());
			responseJson.put("last_name", member.getLastName());
			responseJson.put("user_name", member.getUserName());
			responseJson.put("gender", member.getGender());
			responseJson.put("birth", member.getBirth());
			responseJson.put("phone", member.getPhone());
			responseJson.put("address", member.getAddress());
			responseJson.put("email", member.getEmail());
			responseJson.put("update_at", member.getUpdateAt());
			responseJson.put("img", member.getImg());
		} else {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	
	//修改個資
	@PutMapping(path = "/information/{account}")
	public String modifyInformation(@PathVariable("account") String account, @RequestBody String json){
		JSONObject responseJson = new JSONObject();
		
		if(memberService.exists(account) == null) {
			responseJson.put("message", "帳號不存在");
			responseJson.put("success", false);
		} else {
			MemberBean member = null;
			Integer id=memberService.exists(account).getId();
			try {
				member = memberService.modify(id, json);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(member==null) {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
	
	//修改密碼
//	@PutMapping(path = "/information/{account}")
//	public String modifyPassword(@PathVariable("account") String account, @RequestBody String json) {		
//		JSONObject responseJson = new JSONObject();
//		
//		if(memberService.exists(account) == null) {
//			responseJson.put("message", "帳號不存在");
//			responseJson.put("success", false);
//		} else {
//			MemberBean member = null;
//			Integer id=memberService.exists(account).getId();
//			try {
//				member = memberService.modify(id, json);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			if(member==null) {
//				responseJson.put("message", "修改失敗");
//				responseJson.put("success", false);
//			} else {
//				responseJson.put("message", "修改成功");
//				responseJson.put("success", true);
//			}
//		}
//		return responseJson.toString();
//	}
	
	
	
	
}
