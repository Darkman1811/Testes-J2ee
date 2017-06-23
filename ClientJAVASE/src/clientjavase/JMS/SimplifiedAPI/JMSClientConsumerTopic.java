/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase.JMS.SimplifiedAPI;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Super
 */
public class JMSClientConsumerTopic {
    public static void main(String [] args){

        try{
            //Get the JNDI context
            Context jndiContext= new InitialContext();
            
            //LookUp for Administrated Objects
            ConnectionFactory connectionFactory=(ConnectionFactory)jndiContext.lookup("jms/javaee7/connectionFactory");
            Destination topic=(Destination) jndiContext.lookup("jms/javaee7/Topic");
            JMSContext context=connectionFactory.createContext();
            JMSConsumer consumer=context.createConsumer(topic);
            System.out.println("Simplified API - Listening for: jms/javaee7/Topic");
            int loops=0;
            while(true){
                loops+=1;
                System.out.println("Waiting for topic message: "+loops);
                TextMessage message=(TextMessage)consumer.receive();
                System.out.println("Topic Message received: "+message.getText());
            }
        } catch (NamingException|JMSException e){
            e.printStackTrace();
        }
    }
}
