package tw.ispan.eeit168.chatroom;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173",allowCredentials = "true")
public class TestController {
    @Autowired
    private WebSocket webSocket;

//    @RequestMapping("/sendAllWebSocket")
//    public String test() {    
//        webSocket.sendAllMessage("清晨起来打开窗，心情美美哒~");
//        return "websocket群体发送！";        
//    }
    
    @PostMapping("/sendOneWebSocket")
    public String sendOneWebSocket(@RequestBody String body) {
    	JSONObject obj = new JSONObject(body);
//		Integer fkMemberId = obj.isNull("fkMemberId") ? null : obj.getInt("fkMemberId");
		String toConnectId = obj.isNull("toConnectId") ? null : obj.getString("toConnectId");
		String fromIdentity = obj.isNull("fromIdentity") ? null : obj.getString("fromIdentity");
		String fromUserName = obj.isNull("fromUserName") ? null : obj.getString("fromUserName");
		String text = obj.isNull("text") ? null : obj.getString("text");
//		System.out.println("發送給"+toConnectId);
        webSocket.sendOneMessage(fromIdentity, fromUserName, toConnectId, text);
        return "websocket单人发送";
    }
}
