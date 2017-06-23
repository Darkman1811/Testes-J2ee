/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavaee1;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Super
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            System.out.println("bobo");
           WebSocketContainer container= ContainerProvider.getWebSocketContainer();
            
//            String uri="http://localhost:8080/TEST1-war/chat";
  //          container.connectToServer(testWebsocketClient.class, URI.create(uri));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
