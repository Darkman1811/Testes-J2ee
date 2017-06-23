/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Super
 */

public class Client {
    public static void main (String [] args) throws IOException{
       TestWebsocketClient testWebsocket=new TestWebsocketClient();
        BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));
        String message=null;
        System.out.println("Entrez votre pseudo");
        while(true){
            message=buff.readLine();
            testWebsocket.sendMessage(message);
        }
        
    }    
  
  
}
