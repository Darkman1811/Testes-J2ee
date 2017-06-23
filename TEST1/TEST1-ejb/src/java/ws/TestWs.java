/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author Super
 */
@Stateless
@WebService
public class TestWs {
  public String tester3(){
      return"tester";
  }  
}
