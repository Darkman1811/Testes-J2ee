/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase.JMS.ClassicAPI;

import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Super
 */
public class JmsClientProducer {
    public static void main(String [] args){
        System.out.println("Sending: ");
        try{
            //Parametring JNDI
            System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            System.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");

            //Gets the JNDI  Context
            new JmsClientProducer().publishQueue("Classic API - Message to Queue");
            new JmsClientProducer().publishTopic("Classic API - Message to Topic");
            
        }catch(NamingException | JMSException e){
            e.printStackTrace();
        }
    }
    
    public void publishQueue(String mess) throws NamingException, JMSException{
        Context jndiContext= new InitialContext();
           
            
        //LookUp the administred Objects
            ConnectionFactory connectoinFactory= (ConnectionFactory) jndiContext.lookup("jms/javaee7/connectionFactory");
            Destination queue=(Destination) jndiContext.lookup("jms/javaee7/Queue");
            
            //Creates the needed artifacts to connect to the Queue
            Connection connection=connectoinFactory.createConnection();
            Session session=connection.createSession();
            MessageProducer producer=session.createProducer(queue);
            
            //Sends text message to the queue
            TextMessage message=session.createTextMessage(mess);
            producer.send(message);
              System.out.println("Queue Sent...");
            connection.close();
    }
    
    public void publishTopic(String mess) throws NamingException, JMSException{
        Context jndiContext= new InitialContext();
           
            
        //LookUp the administred Objects
            ConnectionFactory connectoinFactory= (ConnectionFactory) jndiContext.lookup("jms/javaee7/connectionFactory");
            Destination topic=(Destination) jndiContext.lookup("jms/javaee7/Topic");
            
            //Creates the needed artifacts to connect to the Queue
            Connection connection=connectoinFactory.createConnection();
            Session session=connection.createSession();
            MessageProducer producer=session.createProducer(topic);
            
            //Sends text message to the queue
            TextMessage message=session.createTextMessage(mess);
            producer.send(message);
              System.out.println("Topic Sent...");
            connection.close();
    }
   
}
