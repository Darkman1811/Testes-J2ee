/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase.JMS.SimplifiedAPI;

import java.beans.DesignMode;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Super
 */
public class JmsClientDestinationCreator {
    
    public static void main(String args[]){
        try{
             //Parametring JNDI
            System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            System.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            new JmsClientDestinationCreator().createQueue("Queue1","Simplified API: Message to Queue");
            new JmsClientDestinationCreator().createTopic("Topic1","Simplified API: Message to Topic");
        } catch(NamingException e){
            e.printStackTrace();
        }
    }
    
    public void createQueue(String subject,String mess) throws NamingException{
        Context jndiContext=new InitialContext();
        ConnectionFactory connectionFactory=(ConnectionFactory)jndiContext.lookup("jms/javaee7/connectionFactory");
        JMSContext context=connectionFactory.createContext();
        context.createQueue(subject);
       /* JMSProducer producer=context.createProducer();
        Destination queue=(Destination)jndiContext.lookup("jms/javaee7/"+subject);
        producer.send(queue, mess);*/
          System.out.println("Queue created...");        
    }
    
      public void createTopic(String subject,String mess) throws NamingException{
        Context jndiContext=new InitialContext();
        ConnectionFactory connectionFactory=(ConnectionFactory)jndiContext.lookup("jms/javaee7/connectionFactory");
        JMSContext context=connectionFactory.createContext();
        context.createTopic(subject);
       /* JMSProducer producer=context.createProducer();
        Destination topic=(Destination)jndiContext.lookup("jms/javaee7/"+subject);
        producer.send(topic, mess);*/
          System.out.println("Topic created...");        
    }
}
