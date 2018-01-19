/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

/**
 *
 * @author hp
 */
public class Commentaire {
    
    private  int id_comment;
    private int id_user;
    private String commentaire;
    private String titre ;
    private String date_env ;
    private String user_name ;
    private String signals ;

    public Commentaire(String commentaire, String titre, String user_name) {
        this.commentaire = commentaire;
        this.titre = titre;
        this.user_name = user_name;
    }

    public Commentaire(String commentaire, String titre, String date_env, String user_name, String signals) {
        this.commentaire = commentaire;
        this.titre = titre;
        this.date_env = date_env;
        this.user_name = user_name;
        this.signals = signals;
    }

   
   
  
    public int getId_comment() {
        return id_comment;
    }

    public int getId_user() {
        return id_user;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public Commentaire(String commentaire, String titre) {
        this.commentaire = commentaire;
        this.titre = titre;
    }

  

    public String getTitre() {
        return titre;
    }

    public String getDate_env() {
        return date_env;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getSignals() {
        return signals;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

  
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate_env(String date_env) {
        this.date_env = date_env;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setSignals(String signals) {
        this.signals = signals;
    }

    public Commentaire(int id_comment, int id_user, String commentaire, String titre, String date_env, String user_name, String signals) {
        this.id_comment = id_comment;
        this.id_user = id_user;
        this.commentaire = commentaire;
        this.titre = titre;
        this.date_env = date_env;
        this.user_name = user_name;
        this.signals = signals;
    }

    public Commentaire(int id_user, String commentaire, String titre, String date_env, String user_name, String signals) {
        this.id_user = id_user;
        this.commentaire = commentaire;
        this.titre = titre;
        this.date_env = date_env;
        this.user_name = user_name;
        this.signals = signals;
    }

   
    
        
    
    public Commentaire(String commentaire, String titre, String date_env, String user_name) {
        this.commentaire = commentaire;
        this.titre = titre;
        this.date_env = date_env;
        this.user_name = user_name;
    }

    public Commentaire(int id_user, String commentaire, String titre, String date_env, String user_name) {
        this.id_user = id_user;
        this.commentaire = commentaire;
        this.titre = titre;
        this.date_env = date_env;
        this.user_name = user_name;
    }

 

//    public Commentaire(int id_comment, String commentaire, String titre, String date_env, String user_name, String signals) {
//        this.id_comment = id_comment;
//        this.commentaire = commentaire;
//      
//        this.titre = titre;
//        this.date_env = date_env;
//        this.user_name = user_name;
//        this.signals = signals;
//    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_comment=" + id_comment + ", id_user=" + id_user + ", commentaire=" + commentaire +  ", titre=" + titre + ", date_env=" + date_env + ", user_name=" + user_name + ", signals=" + signals + '}';
    }

    public Commentaire() {
    }

    
 
   

  
    

    
    
    
    
}
