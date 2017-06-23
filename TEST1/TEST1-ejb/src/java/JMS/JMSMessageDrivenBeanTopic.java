/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Super
 */
@MessageDriven(mappedName = "jms/javaee7/Topic")
public class JMSMessageDrivenBeanTopic implements MessageListener{
    public void onMessage(Message message){
        try {
            System.out.println("From Message Driven Bean Topic: "+message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
