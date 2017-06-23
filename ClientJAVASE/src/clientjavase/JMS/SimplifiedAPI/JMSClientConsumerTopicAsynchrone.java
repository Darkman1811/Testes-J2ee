/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase.JMS.SimplifiedAPI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Super
 */
public class JMSClientConsumerTopicAsynchrone implements MessageListener{
    public static void main(String [] args){

        try{
            //Get the JNDI context
            Context jndiContext= new InitialContext();
            
            //LookUp for Administrated Objects
            ConnectionFactory connectionFactory=(ConnectionFactory)jndiContext.lookup("jms/javaee7/connectionFactory");
            Destination queue=(Destination) jndiContext.lookup("jms/javaee7/Queue");
            JMSContext context=connectionFactory.createContext();
            JMSConsumer consumer=context.createConsumer(queue);
            consumer.setMessageListener(new JMSClientConsumerTopicAsynchrone());
            System.out.println("Simplified API - Listening for: jms/javaee7/Queue");
            
        } catch (NamingException e){
            e.printStackTrace();
        }
    }
    
    public void onMessage(Message message) {
                       
        try {
            System.out.println("Queue Message received Asynchrone: "+message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
                
    }
}
