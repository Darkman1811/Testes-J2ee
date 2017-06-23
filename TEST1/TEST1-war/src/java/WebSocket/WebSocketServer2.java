/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Super
 */
@ServerEndpoint("/chat2")
public class WebSocketServer2 {
  static Set<Session> chatRoomUsers=Collections.synchronizedSet(new HashSet<Session>());
    @OnMessage
    public void traiterMessage(String message,Session s) throws IOException{  
        System.out.println("Message: "+message);
       String username=(String)s.getUserProperties().get("username");
       if(username==null){
           s.getUserProperties().put("username", message);
           s.getBasicRemote().sendText("Connecté en tant que: "+message +"\n"); 
       } else{
           Iterator<Session> iterator=chatRoomUsers.iterator();
           while(iterator.hasNext()){iterator.next().getBasicRemote().sendText(username+":"+message+"\n");}
       }
    }
      
    @OnOpen
    public void open(Session s){
        System.out.println("Connecté...");
        chatRoomUsers.add(s);
           
    } 
    
    @OnClose
    public void fermer(Session s){
         chatRoomUsers.remove(s);
    }
    
}
