package tw.ispan.eeit168.chatroom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import tw.ispan.eeit168.member.dao.MemberDAO;
import tw.ispan.eeit168.member.service.MemberService;

@Component
@ServerEndpoint("/websocket/{ConnectId}")
@CrossOrigin(origins = "http://192.168.34.74:8081",allowCredentials = "true")
//此注解相当于设置访问URL
public class WebSocket {
	@Autowired
	private MemberDAO memberDAO ;
    
    private Session session;
    
    private static CopyOnWriteArraySet<WebSocket> webSockets =new CopyOnWriteArraySet<>();
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();
    
    @OnOpen
    public void onOpen(Session session, @PathParam(value="ConnectId")String ConnectId) {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(ConnectId, session);
        System.out.println("建立連線id"+ ConnectId);
        System.out.println("【websocket消息】有新的连接，总数为:"+webSockets.size());
    }
    
    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }
    
    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
    }
    
    // 此为广播消息
//    public void sendAllMessage(String message) {
//        for(WebSocket webSocket : webSockets) {
//            System.out.println("【websocket消息】广播消息:"+message);
//            try {
//                webSocket.session.getAsyncRemote().sendText(message);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
    
    // 此为单点消息
    public void sendOneMessage(String fromIdentity, String fromUserName,String ConnectId, String message) {
        Session session = sessionPool.get(ConnectId);
//        System.out.println(session);
        if (session != null) {
        	JSONObject responseJson = new JSONObject();    

        	responseJson.put("fromConnectId", fromUserName);
        	responseJson.put("message", message);     	
            try {
                session.getAsyncRemote().sendText(responseJson.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
