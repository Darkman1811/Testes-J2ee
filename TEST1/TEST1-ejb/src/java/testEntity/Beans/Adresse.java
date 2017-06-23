/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testEntity.Beans;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Super
 */
@Embeddable
public class Adresse {
    private String pays;
    private String region;
    private String ville;
    private String rue;
    private String numeroVilla;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumeroVilla() {
        return numeroVilla;
    }

    public void setNumeroVilla(String numeroVilla) {
        this.numeroVilla = numeroVilla;
    }
    
}
