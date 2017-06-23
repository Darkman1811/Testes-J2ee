/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase.JMS.Reliability;

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
public class JmsClientProducerTimeToLive {
    public static void main(String args[]){
        try{
             //Parametring JNDI
            System.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            System.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            new JmsClientProducerTimeToLive().publishQueueTimeToLive("Simplified API: Message to Queue");
            new JmsClientProducerTimeToLive().publishTopicTimeToLive("Simplified API: Message to Topic");
        } catch(NamingException e){
            e.printStackTrace();
        }
    }
    
    public void publishQueueTimeToLive(String mess) throws NamingException{
        Context jndiContext=new InitialContext();
        ConnectionFactory connectionFactory=(ConnectionFactory)jndiContext.lookup("jms/javaee7/connectionFactory");
        Destination queue=(Destination)jndiContext.lookup("jms/javaee7/Queue");
        JMSContext context=connectionFactory.createContext();
        JMSProducer producer=context.createProducer();
        producer.setTimeToLive(500);
        producer.send(queue, mess);
          System.out.println("Queue Sent...");        
    }
    
      public void publishTopicTimeToLive(String mess) throws NamingException{
        Context jndiContext=new InitialContext();
        ConnectionFactory connectionFactory=(ConnectionFactory)jndiContext.lookup("jms/javaee7/connectionFactory");
        Destination topic=(Destination)jndiContext.lookup("jms/javaee7/Topic");
        JMSContext context=connectionFactory.createContext();
        JMSProducer producer=context.createProducer();
        producer.setTimeToLive(500);
        producer.send(topic, mess);
          System.out.println("Topic Sent...");        
    }
}
