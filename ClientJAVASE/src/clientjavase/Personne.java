/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase;

/**
 *
 * @author Super
 */
public class Personne {
   private int id;
   private String prenom;
   private String nom;
   private int age;

    public Personne() {
    }

    public Personne(int id, String prenom, String nom, int age) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
