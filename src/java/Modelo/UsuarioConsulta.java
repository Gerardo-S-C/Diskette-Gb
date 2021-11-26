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
public class UsuarioConsulta {
    private int id, id_asig, id_act_blo;
    private String nom_usu, nom_blo, nom_act, dif_dif, pro_dif, pro_dif_dif1, pro_dif_dif2;
    
    public UsuarioConsulta(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_asig() {
        return id_asig;
    }

    public void setId_asig(int id_asig) {
        this.id_asig = id_asig;
    }

    public int getId_act_blo() {
        return id_act_blo;
    }

    public void setId_act_blo(int id_act_blo) {
        this.id_act_blo = id_act_blo;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
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

    public String getPro_dif() {
        return pro_dif;
    }

    public void setPro_dif(String pro_dif) {
        this.pro_dif = pro_dif;
    }

    public String getPro_dif_dif1() {
        return pro_dif_dif1;
    }

    public void setPro_dif_dif1(String pro_dif_dif1) {
        this.pro_dif_dif1 = pro_dif_dif1;
    }

    public String getPro_dif_dif2() {
        return pro_dif_dif2;
    }

    public void setPro_dif_dif2(String pro_dif_dif2) {
        this.pro_dif_dif2 = pro_dif_dif2;
    }
    
}
