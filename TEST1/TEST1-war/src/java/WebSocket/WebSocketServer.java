/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import java.io.IOException;
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
@ServerEndpoint("/chat")
public class WebSocketServer {
  
    @OnMessage
    public String traiterMessage(String message){            
            System.out.println("Message recu:"+message);        
            String reponse="Echo "+message;
            System.out.println(reponse);
            return reponse;
    }
      
    @OnOpen
    public void open(Session s){
              System.out.println("Session ouvert ...");  
    }
    
    @OnClose
    public void fermer(){
        System.out.println("Session fermé ...");  
    }
    
    @OnError
    public void erreur(Throwable t){
        t.printStackTrace();
    }
}
