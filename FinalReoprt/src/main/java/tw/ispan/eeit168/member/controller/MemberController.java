package tw.ispan.eeit168.member.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.ispan.eeit168.member.domain.MemberBean;
import tw.ispan.eeit168.member.service.MemberService;

@RestController
@RequestMapping(path = "/pages/member")
//@CrossOrigin(origins = "http://localhost:5173",allowCredentials = "true")
@CrossOrigin
public class MemberController {
	@Autowired
	private MemberService memberService;

//	@PostMapping(path = "/login")
//	public String login(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
//		JSONObject obj = new JSONObject(json);
//		String account = obj.isNull("account") ? null : obj.getString("account");
//		String password = obj.isNull("password") ? null : obj.getString("password");
//		System.out.println(request.getSession().getId());//測試用
//		return memberService.doLogin(account.trim(), password.trim(), request, response).toString();
//	}
	
	//登入
	@PostMapping(path = "/login")
	public String login(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		//取出帳號密碼 確認是否與資料庫吻合
		JSONObject obj = new JSONObject(json);
		String account = obj.isNull("account") ? null : obj.getString("account");
		String password = obj.isNull("password") ? null : obj.getString("password");
		if(account == null || password == null || account.length()==0 || password.length()==0) {
			responseJson.put("message", "登入失敗，請輸入帳號");
			responseJson.put("success", false);
		}else {
			MemberBean accountVerification = memberService.accountVerification(account,password);
			if(accountVerification != null) {
				responseJson.put("message", "登入成功");
				responseJson.put("success", true);
				responseJson.put("id", accountVerification.getId());				
				responseJson.put("account", accountVerification.getAccount());
				responseJson.put("identity", "會員");
				responseJson.put("username", accountVerification.getUserName());
			} else {
				responseJson.put("message", "登入失敗，帳號或密碼錯誤");
				responseJson.put("success", false);
			}
		}
		return responseJson.toString();
	}
	
	//建立帳號
	@PostMapping(path = "/register")
	public String register(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(json);
		String account = obj.isNull("account") ? null : obj.getString("account");
		
		if(memberService.exists(account)) {
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
				responseJson.put("message", "註冊失敗");
				responseJson.put("success", false);
			} else {
				responseJson.put("message", "註冊成功");
				responseJson.put("success", true);
			}
		}
		return responseJson.toString();
	}
	//測試用之後刪掉改用下面的
//	@PostMapping(path="/information")
//	public String exist(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
//		JSONObject responseJson = new JSONObject();
//		JSONObject obj = new JSONObject(json);
//		System.out.println(request.getSession().getId());  
//		String account =(String) request.getSession(false).getAttribute("account"); 
//		
//		System.out.println(request.getSession().getAttribute("account"));
//		System.out.println(request.getSession().getAttribute("password"));
////		String account= (String) request.getSession().getAttribute("account");
//		System.out.println(account.equals("firstmember"));
//		System.out.println(account);
//		if(request.getSession(false) != null && request.getSession(false).getAttribute("account") != null && request.getSession(false).getAttribute("password") != null) {			
//			System.out.println("有登入");
//			responseJson.put("message", "資料存在");
//			responseJson.put("success", false);
//		} else {
//			System.out.println("未登入");
//			responseJson.put("message", "資料不存在");
//			responseJson.put("success", true);
//		}
//		return responseJson.toString();
//	}
	
	//撈出個資
	@PostMapping(path="/information")
	public String exist(@RequestBody String json) {
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(json);
		String account = obj.isNull("account") ? null : obj.getString("account");	
		MemberBean member = memberService.find(account);
		if(member != null) {			
			responseJson.put("account", member.getAccount());
			responseJson.put("firstName", member.getFirstName());
			responseJson.put("lastName", member.getLastName());
			responseJson.put("userName", member.getUserName());
			responseJson.put("gender", member.getGender());
			//將資料庫的時間改成字串送給前端
			if(member.getBirth() != null) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				String birth = dateFormat.format(member.getBirth());  
				responseJson.put("birth", birth);
			}
			//將電話號碼拆解成三段送給前端
			if(member.getPhone() != null) {
				String[] number = member.getPhone().split("-");
				responseJson.put("phone1", number[0]);
				responseJson.put("phone2", number[1]);
				responseJson.put("phone3", number[2]);
			}
			responseJson.put("address", member.getAddress());
			responseJson.put("email", member.getEmail());
			responseJson.put("updateAt", member.getUpdateAt());
			responseJson.put("img", member.getImg());
		} else {
			responseJson.put("message", "資料不存在");
			responseJson.put("success", true);
		}
		return responseJson.toString();
	}
	
	//修改個資
//	@PutMapping(path = "/information")
//	public String modifyInformation(@RequestBody String json){
//		JSONObject responseJson = new JSONObject();
//		JSONObject obj = new JSONObject(json);
//		String account = obj.isNull("account") ? null : obj.getString("account");	
//		if(!memberService.exists(account)) {
//			responseJson.put("message", "帳號不存在");
//			responseJson.put("success", false);
//		} else {
//			MemberBean member = null;
//			Integer id=memberService.findId(account);
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
	
	@PutMapping(path = "/information")
	public String modifyInformation(@RequestParam(value = "file", required = false) MultipartFile file, String body){
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(body);
		String account = obj.isNull("account") ? null : obj.getString("account");	
		if(!memberService.exists(account)) {
			responseJson.put("message", "帳號不存在");
			responseJson.put("success", false);
		} else {
			MemberBean member = null;
			Integer id=memberService.findId(account);
			try {
				member = memberService.modify(id, body,file);
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
	@PutMapping(path = "/modifypassword")
	public String modifyPassword(@RequestBody String json) {		
		JSONObject responseJson = new JSONObject();
		JSONObject obj = new JSONObject(json);
		String account = obj.isNull("account") ? null : obj.getString("account");
		String password = obj.isNull("password") ? null : obj.getString("password");
		
		if(!memberService.exists(account)) {
			responseJson.put("message", "帳號不存在");
			responseJson.put("success", false);
		} else {
			Boolean result = false;
			try {
				if(account!=null && password!=null && account.length()!=0 && password.length()!=0) {					
					result = memberService.modifyPassword(account, password);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(result) {
				responseJson.put("message", "修改成功");
				responseJson.put("success", true);
			} else {
				responseJson.put("message", "修改失敗");
				responseJson.put("success", false);
			}
		}
		return responseJson.toString();
	}
	
}
