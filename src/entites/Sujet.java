/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

import java.io.File;
import java.util.Date;

/**
 *
 * @author hp
 */
public class Sujet {
    
  private  int id_sujet;
  private int id_user; 
  private  String titre; 
  private  String theme;
  private String name_user;
  private  String texte ;
  private String date1;

    public Sujet() {
    }

    public Sujet(String titre, String name_user, String texte) {
        this.titre = titre;
        this.name_user = name_user;
        this.texte = texte;
    }

    public Sujet(String titre, String theme, String name_user, String texte) {
        this.titre = titre;
        this.theme = theme;
        this.name_user = name_user;
        this.texte = texte;
    }

    public Sujet(int id_sujet, int id_user, String titre, String theme, String name_user, String texte, String date1) {
        this.id_sujet = id_sujet;
        this.id_user = id_user;
        this.titre = titre;
        this.theme = theme;
        this.name_user = name_user;
        this.texte = texte;
        this.date1 = date1;
    }

    public Sujet(int id_user, String titre, String theme, String name_user, String texte, String date1) {
        this.id_user = id_user;
        this.titre = titre;
        this.theme = theme;
        this.name_user = name_user;
        this.texte = texte;
        this.date1 = date1;
    }

    public Sujet(int id_user, String titre, String theme, String name_user, String texte) {
        this.id_user = id_user;
        this.titre = titre;
        this.theme = theme;
        this.name_user = name_user;
        this.texte = texte;
    }

    

    public int getId_sujet() {
        return id_sujet;
    }

    public int getId_user() {
        return id_user;
    }

    public String getTitre() {
        return titre;
    }

    public String getTheme() {
        return theme;
    }

    public String getName_user() {
        return name_user;
    }

    public String getTexte() {
        return texte;
    }

    public String getDate1() {
        return date1;
    }

    public void setId_sujet(int id_sujet) {
        this.id_sujet = id_sujet;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    @Override
    public String toString() {
        return titre;
    }
 

   


   
  
     
}
