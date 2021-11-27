/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author illum
 */
public class Bloques {
    private int id_blo;
    private String nom_blo, nom_act, dif_dif;
    
    public Bloques (){
        
    }

    public int getId_blo() {
        return id_blo;
    }

    public void setId_blo(int id_blo) {
        this.id_blo = id_blo;
    }

    public String getNom_blo() {
        return nom_blo;
    }

    public void setNom_blo(String nom_blo) {
        this.nom_blo = nom_blo;
    }

    public String getNom_act() {
        return nom_act;
    }

    public void setNom_act(String nom_act) {
        this.nom_act = nom_act;
    }

    public String getDif_dif() {
        return dif_dif;
    }

    public void setDif_dif(String dif_dif) {
        this.dif_dif = dif_dif;
    }
    
    
}
