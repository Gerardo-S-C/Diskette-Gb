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
public class Act_Blo {
    private int id_act_blo, id_act_dif, id_blo;
    private String nom_act;
    public Act_Blo(){
        
    }

    public int getId_act_blo() {
        return id_act_blo;
    }

    public void setId_act_blo(int id_act_blo) {
        this.id_act_blo = id_act_blo;
    }

    public int getId_act_dif() {
        return id_act_dif;
    }

    public void setId_act_dif(int id_act_dif) {
        this.id_act_dif = id_act_dif;
    }

    public int getId_blo() {
        return id_blo;
    }

    public void setId_blo(int id_blo) {
        this.id_blo = id_blo;
    }

    public String getNom_act() {
        return nom_act;
    }

    public void setNom_act(String nom_act) {
        this.nom_act = nom_act;
    }
    
}
