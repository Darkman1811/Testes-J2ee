/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author Super
 */
@Stateless
@Local(TestEJBLocal.class)
@Remote(TestEJBLocal2.class)
@LocalBean
public class TestEJB implements TestEJBLocal,TestEJBLocal2{
 int compte=0; 
    public String tester(){
        return "bobo:"+compte;
    } 
    
    public String tester2(){
        return "baba";
    }
    
   
      
      @PostConstruct
   public void testpostconstruct(){
       /*compte=compte+5; 
       System.out.println("PostConstruct");*/
   }
   
   @PreDestroy
   public void testPreDestroy(){
      compte=compte+10; 
       System.out.println("AroundConstruct"); 
        
   }
}
