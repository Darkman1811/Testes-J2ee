/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase.JMS.ClassicAPI;

import java.util.Date;
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
public class JmsClientConsumerTopic {
    public static void main(String [] args){
      
        try{
            //Gets the JNDI  Context
            Context jndiContext= new InitialContext();
            
            //LookUp the administred Objects
            ConnectionFactory connectoinFactory= (ConnectionFactory) jndiContext.lookup("jms/javaee7/connectionFactory");
            Destination topic=(Destination) jndiContext.lookup("jms/javaee7/Topic");
            
            //Creates the needed artifacts to connect to the Queue
            Connection connection=connectoinFactory.createConnection();
            Session session=connection.createSession();
            MessageConsumer consumer=session.createConsumer(topic);
            connection.start();
            
            //Loops to receive message
            System.out.println("Classic API - Listening for: jms/javaee7/Topic");
            int loops=0;
            while (true){
                loops+=1;
                System.out.println("Waiting for Topic message: "+loops);
                TextMessage message=(TextMessage)consumer.receive();
                System.out.println("Topic Message received: "+message.getText());
            }
            
            
        }catch(NamingException | JMSException e){
            e.printStackTrace();
        }
    }
}
