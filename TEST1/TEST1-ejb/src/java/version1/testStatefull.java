/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.Remove;

/**
 *
 * @author Super
 */
@Stateful
@LocalBean
public class testStatefull {
private int compte=0;
    public int plus1(){
        compte=compte+1;
        return compte;
    }
    
    @Remove
      public String deconnecter(){
       return "Deconnecter"; 
    }
  
}
