/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavafx1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Super
 */
public class Personne {

  private StringProperty firstName=new SimpleStringProperty(this,"firstName","");

  
  //Return the stringProperty object
    public StringProperty firstNameProperty(){
        return firstName;
    }  
  
     public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
  
  
  
    
    
    
}
