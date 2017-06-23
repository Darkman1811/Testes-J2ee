/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientjavase;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Super
 */
@XmlRootElement
public class Book {
    private int id;
    private String nom;
    private String auteur;
    private int nbPages;

    public Book() {
    }

    public Book(int id, String nom, String auteur, int nbPages) {
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }
    
}
