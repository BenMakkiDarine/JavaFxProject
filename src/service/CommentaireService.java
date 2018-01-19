/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;
import entites.user;
import entites.Commentaire;
import utils.MyBdConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entites.Sujet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import static jdk.nashorn.internal.runtime.Debug.id;


/**
 *
 * @author hp
 */
public class CommentaireService {  
     Connection mycon;
//     user u=new user();
//     Sujet s=new Sujet();
     
     user user=new user(5) ;

    public CommentaireService() {
    mycon = MyBdConnection.getInstanceBD().getConnection();

    }

    
    public boolean insererCommentaire(Commentaire com) throws SQLException {

        String req1 = "INSERT INTO `commentaire` "
                + "(`id_user`, `commentaire`, `titre`, `date_env`, `user_name`,`signals`)"
                + " VALUES ('" +com.getId_user()+"','" +com.getCommentaire()+"','" +com.getTitre()+"','" +com.getDate_env()+"','" +com.getUser_name()+"','" +com.getSignals()+"')";
 
        Statement ste = mycon.createStatement();
        int x = ste.executeUpdate(req1);
        return true;
    }
 

     private Statement st;

     
      public void update(int id ,String commentaire) throws SQLException {


     String sql = "UPDATE `commentaire` SET `commentaire`='" + commentaire + "' WHERE id_comment='" + id + "'";
            //UPDATE `offresemplois` SET `poste`=+ poste +,`date_experation`=+ date_experation +,`date_poste`=+ date_poste +,`description`=+ description + WHERE id='" + id + "'";
//"UPDATE offresemplois SET poste='" + poste + "',date_experation='" + date_experation + "',date_poste='" + date_poste +"',description='" + description +"' WHERE id='" + id + "'";
        try {
            st = mycon.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
        try {
            st.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

       } 
   public boolean supprimercommentaire(int id) throws SQLException {

        String req = "delete from commentaire where "
                + "id_comment= ? ";

        PreparedStatement ps = mycon.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
        return true;
    }
    

   public void Affichercommentaire(String dd) throws SQLException {
          String req1 = "select * from commentaire c inner join user u on c.id_user=u.id_user where u.nom='"+dd+"';";
       
       Statement ste = mycon.createStatement();
      ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("forum est "+res.getString("commentaire"));
            
        }
    }

  
    public ArrayList<Commentaire> Affiches() throws SQLException {
        try {
            String requete = "select * from commentaire";
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Commentaire> suj = new ArrayList<>();
            while (result.next()) {
                Commentaire com = new Commentaire();
                com.setId_comment(result.getInt("id_comment"));
                com.setId_user(result.getInt("id_user"));
                com.setCommentaire(result.getString("commentaire"));
                     com.setTitre(result.getString ("titre"));
                com.setDate_env(result.getString ("date_env"));
                com.setUser_name(result.getString("user_name"));
                com.setSignals(result.getString("signals"));  
                suj.add(com);
            }
            return suj;
        } catch (Exception ee) {
            System.out.println("erreur dan select randonnées " + ee.getMessage());
        }
        return null;
    }

    
    public List<Commentaire> RechercheCommentaire(String titr) throws SQLException{
        List<Commentaire> covs = new ArrayList<>();
        ResultSet result = null;
        Commentaire c = null;
        try {
            String req3 = "select * from commentaire where user_name=? "; // AND arrivee=? AND date=?
             PreparedStatement stee = mycon.prepareStatement(req3);
            stee.setString(1,titr);
           /* ste.setString(2, arrivee);
            ste.setDate(3, date);*/

            result = stee.executeQuery();

            while (result.next()) {

               /* c = new Offre(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5),
                        result.getString(6), result.getString(7), result.getString(8), result.getString(9), result.getInt(10), result.getInt(11), result.getFloat(12), result.getString(13), result.getString(14), result.getString(15));
                */
                   c = new Commentaire (result.getInt(1),result.getInt(2), result.getString(3), result.getString(4), result.getString(5) , result.getString(6), result.getString(7));
                      

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }
        
           public ArrayList<Commentaire> AffichesUser(int dd) throws SQLException{
           
           try {
            String requete = "select * from commentaire where id_user="+dd;
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Commentaire> suj = new ArrayList<>();
            while (result.next()) {
                Commentaire com = new Commentaire();
                com.setId_comment(result.getInt("id_comment"));
                com.setId_user(result.getInt("id_user"));
                com.setCommentaire(result.getString("commentaire"));
                 com.setTitre(result.getString ("titre"));
                com.setDate_env(result.getString ("date_env"));
                com.setUser_name(result.getString("user_name"));
                com.setSignals(result.getString("signals"));  
                suj.add(com);
            }
            return suj;
        } catch (Exception ee) {
            System.out.println("erreur dan select randonnées " + ee.getMessage());
        }
        return null; 
           
           
           
           
           
           }
           
       
                 public ArrayList<Commentaire> RecherchSujet(String titre) throws SQLException{
           
           try {
            String requete = "select * from commentaire where titre='"+titre+"';";
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Commentaire> suj = new ArrayList<>();
            while (result.next()) {
                Commentaire com = new Commentaire();
                com.setId_comment(result.getInt("id_comment"));
                com.setId_user(result.getInt("id_user"));
                com.setCommentaire(result.getString("commentaire"));
                 com.setTitre(result.getString ("titre"));
                com.setDate_env(result.getString ("date_env"));
                com.setUser_name(result.getString("user_name"));
                com.setSignals(result.getString("signals"));  
                suj.add(com);
            }
            return suj;
        } catch (Exception ee) {
            System.out.println("erreur dan select randonnées " + ee.getMessage());
        }
        return null; 
           
           
           
           
           
           }
           
           
      public void SignalCom(int id) throws SQLException {
        String requete = "UPDATE commentaire SET signals=2 WHERE id_comment=?";
        try {
            PreparedStatement ps =mycon.prepareStatement(requete); 
           
            ps.setInt(1,id);    
            ps.executeUpdate();
            System.out.println("Commentaire signalé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification  Commentaire" + ex.getMessage());
        } }      
           


     public ArrayList<Commentaire> getcomment_for_annonce() throws SQLException {
        try {
            String a="annonces";
            String requete = "SELECT * FROM `commentaire` WHERE `titre`='"+a+"' "   ;
            
      
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Commentaire> suj = new ArrayList<>();
            while (result.next()) {
                Commentaire com = new Commentaire();
                com.setId_comment(result.getInt("id_comment"));
                com.setId_user(result.getInt("id_user"));
                com.setCommentaire(result.getString("commentaire"));
                
                com.setDate_env(result.getString ("date_env"));
                com.setUser_name(result.getString("user_name"));
                com.setSignals(result.getString("signals"));  
                suj.add(com);
            }
            return suj;
        } catch (Exception ee) {
            System.out.println("erreur dan select commentaire  " + ee.getMessage());
        }
        return null;
    }
           
                      
           public ArrayList<Commentaire> getcomment_for_conseils() throws SQLException {
        try {
            String a="conseils";
            String requete = "SELECT * FROM `commentaire` WHERE `titre`='"+a+"' "   ;
            
      
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Commentaire> suj = new ArrayList<>();
            while (result.next()) {
                Commentaire com = new Commentaire();
                com.setId_comment(result.getInt("id_comment"));
                com.setId_user(result.getInt("id_user"));
                com.setCommentaire(result.getString("commentaire"));
                
                com.setDate_env(result.getString ("date_env"));
                com.setUser_name(result.getString("user_name"));
                com.setSignals(result.getString("signals"));  
                suj.add(com);
            }
            return suj;
        } catch (Exception ee) {
            System.out.println("erreur dan select commentaire  " + ee.getMessage());
        }
        return null;
    }
                 
           public ArrayList<Commentaire> getcomment_for_newest() throws SQLException {
        try {
            String a="nouveautés";
            String requete = "SELECT * FROM `commentaire` WHERE `titre`='"+a+"' "   ;
            
      
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Commentaire> suj = new ArrayList<>();
            while (result.next()) {
                Commentaire com = new Commentaire();
                com.setId_comment(result.getInt("id_comment"));
                com.setId_user(result.getInt("id_user"));
                com.setCommentaire(result.getString("commentaire"));
                
                com.setDate_env(result.getString ("date_env"));
                com.setUser_name(result.getString("user_name"));
                com.setSignals(result.getString("signals"));  
                suj.add(com);
            }
            return suj;
        } catch (Exception ee) {
            System.out.println("erreur dan select commentaire  " + ee.getMessage());
        }
        return null;
    }
      
                      
           public ArrayList<Commentaire> getcomment_for_randonn() throws SQLException {
        try {
            String a="randonnées";
            String requete = "SELECT * FROM `commentaire` WHERE `titre`='"+a+"' "   ;
            
      
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Commentaire> suj = new ArrayList<>();
            while (result.next()) {
                Commentaire com = new Commentaire();
                com.setId_comment(result.getInt("id_comment"));
                com.setId_user(result.getInt("id_user"));
                com.setCommentaire(result.getString("commentaire"));
                
                com.setDate_env(result.getString ("date_env"));
                com.setUser_name(result.getString("user_name"));
                com.setSignals(result.getString("signals"));  
                suj.add(com);
            }
            return suj;
        } catch (Exception ee) {
            System.out.println("erreur dan select commentaire  " + ee.getMessage());
        }
        return null;
    }           
           
}
