/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testEntity.Beans;

import javax.persistence.EmbeddedId;

/**
 *
 * @author Super
 * Test des Id composite avec @embeddedId
 */
public class Human2 {
   @EmbeddedId
   private NewIdType id;
  private String prenom;
  private String nom;
  private int age;

    public NewIdType getId() {
        return id;
    }

    public void setId(NewIdType id) {
        this.id = id;
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
  
}
