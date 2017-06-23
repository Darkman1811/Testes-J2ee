/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testEntity.managers;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import testEntity.Beans.Human;

/**
 *
 * @author Super
 */
@Stateless
@WebService
public class manager1 {
 //@PersistenceContext(unitName ="EntityTest-ejbPU")
 @PersistenceContext(unitName ="tpEntity-ejbPU")   
 EntityManager em2;
 
 
 public void ajouter(@WebParam(name ="prenom") String prenom){
     Human pers=new Human();
     pers.setPrenom(prenom);
     pers.setNom("Diaw");
     pers.setAge(30);
     em2.persist(pers);
     em2.flush();
     List<Human> lstpers=em2.createQuery("Select P from Human P", Human.class).getResultList();
     int id=em2.find(Human.class, 1).getId();
     int taille=lstpers.size();
     System.out.println("bobo:"+taille);
 }
 
  public List<Human> getAll(){
     
     List<Human> lstpers=em2.createQuery("Select P from Human P", Human.class).getResultList();
     
     System.out.println("List:"+lstpers.size());
     return lstpers;
 }
  
  public int getSize(){
     
     List<Human> lstpers=em2.createQuery("Select P from Human P", Human.class).getResultList();
     
     System.out.println("List:"+lstpers.size());
     return lstpers.size();
 }
}
