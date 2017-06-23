/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.interceptor.AroundConstruct;

/**
 *
 * @author Super
 */
@Singleton
//@LocalBean
@Startup 
public class testSingleton {
   public static int compte;  

   @Resource TimerService timerservice;
   @PostConstruct
   public void testpostconstruct(){
       compte=compte+5; 
    
       System.out.println("PostConstruct"); 
   }
   

   
   
   @PreDestroy
   public void testPreDestroy(){
      compte=compte+10; 
       System.out.println("AroundConstruct"); 
       compterSingleton(); 
   }
   
  //  @Schedule(second = "*/3", minute = "*", hour = "*")    
    private void testerTimer(){
        compte=compte+1;
         System.out.println("Timer:"+compte);  
    } 
    
   public int compterSingleton(){
       compte=compte+1;
        System.out.println("compterSingleton");  
       return compte;
   }
   
   @Remove
    public String DeconnecterSingleton(){
    return "Suppression Singleton";
}
}
