/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingBeans;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import testEntity.Beans.Human;
import testEntity.managers.manager1;

/**
 *
 * @author Super
 */

@ManagedBean
@SessionScoped 
public class StudentBackingBean {
    private String prenom;
    private String nom;
    private int age;
    private java.util.Date dateDebut;
    private String message;
    private List<Human> humain;   
    private int taille;
    private int selectedHuman;
    private List<String> ListselectedHuman;
@EJB
private manager1 mymanager;

    public int getSelectedHuman() {
        return selectedHuman;
    }

    public void setSelectedHuman(int selectedHuman) {
        this.selectedHuman = selectedHuman;
    }

    public List<String> getListselectedHuman() {
        return ListselectedHuman;
    }

    public void setListselectedHuman(List<String> ListselectedHuman) {
        this.ListselectedHuman = ListselectedHuman;
    }

  
  
    
      
    public List<Human> getHumain() {
        this.humain=mymanager.getAll();
        return humain;
    }

    public void setHumain(List<Human> humain) {
        this.humain = humain;
    }

    public int getTaille() {
        this.taille=mymanager.getSize();
          
        return taille;
    }

    

    public void ajouter(){
        this.message="Bonjour Mr "+prenom+" "+nom+".\n Vous etes agés de "+age+" . Vous debutez le "+dateDebut+" ."
                + "Vous avez selectionné: "+selectedHuman+" .Selection multiple: " ;
        for (int i=0;i<ListselectedHuman.size();i++){
            this.message=this.message+" "+ ListselectedHuman.get(i);
        }
    }
    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getMessage() {
        return message;
    }
    
    
}
