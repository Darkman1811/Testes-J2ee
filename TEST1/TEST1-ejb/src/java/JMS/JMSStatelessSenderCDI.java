/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JMS;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;


/**
 *
 * @author Super
 */
@Stateful
@LocalBean
public class JMSStatelessSenderCDI {
    @Inject
    @JMSConnectionFactory("jms/javaee7/connectionFactory")
    private JMSContext context;
    
     @Resource(lookup = "jms/javaee7/Queue")
    private Queue queue;
    
    @Resource(lookup = "jms/javaee7/Topic")
    private Topic topic;
    
    public void publishQueue(String mess){
        
        JMSProducer producer=context.createProducer();
        producer.send(queue, mess);
    }
    
    public void publishTopic(String mess){
        
        JMSProducer producer=context.createProducer();
        producer.send(topic, mess);
    }
}
