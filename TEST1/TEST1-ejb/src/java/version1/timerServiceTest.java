/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.TimedObject;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import static version1.testSingleton.compte;

/**
 *
 * @author Super
 */
@Singleton
@Startup
@LocalBean
public class timerServiceTest implements TimedObject{

  @Resource TimerService timerservice;
   @PostConstruct
   public void testpostconstruct(){
      
       ScheduleExpression sche= new ScheduleExpression();
       sche.year("*");
       sche.month("*");
       sche.hour("*");   
       sche.minute("*");
       sche.second("*/2");
       //Timer timer=timerservice.createCalendarTimer(sche);
   //   Timer timer2=timerservice.createCalendarTimer(sche, new TimerConfig("myTimer",true));
       System.out.println("PostConstruct"); 
   }

    @Override  
    public void ejbTimeout(Timer timer) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("timer");
         System.out.println("Nom timer:"+timer.getInfo().toString());   
         System.out.println("Temps restant:"+timer.getTimeRemaining());
         System.out.println("Delais:"+timer.getNextTimeout().toString());
         System.out.println("-------------------------------------------");
    }
     
    
   //@Timeout  
    public void testTimeOut(Timer timer){
         System.out.println("timer2");  
         System.out.println(timer.getInfo().toString());  
    }
  
   
}
