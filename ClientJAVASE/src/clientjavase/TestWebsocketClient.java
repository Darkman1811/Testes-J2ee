/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase;

import java.io.IOException;
import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Super
 */

@ClientEndpoint
public class TestWebsocketClient {
    Session session=null;
    
   public TestWebsocketClient(){
        try {
            System.out.println("Lancement de la conneciton au serveur...");
            WebSocketContainer container= ContainerProvider.getWebSocketContainer();            
            URI uri=new URI("ws://localhost:8080/TEST1-war/chat2"); 
            container.connectToServer(this,uri);
       
        } catch (Exception ex) {
           ex.printStackTrace();
        }
   }
   @OnMessage
    public void traiterMessage(String message){
        System.out.println(message);
    }
    
    @OnOpen()
    public void open(Session s){
       this.session=s;
    }
    
    @OnClose
    public void fermer(){
        System.out.println("Fermeture de la connection");
    }
     
    public void sendMessage(String message) throws IOException{
        session.getBasicRemote().sendText(message);
    }
}
