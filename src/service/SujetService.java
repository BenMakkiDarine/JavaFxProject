/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Commentaire;
import entites.Sujet;
import entites.user;
import utils.MyBdConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entites.Forum;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;
import entites.user;

/**
 *
 * @author hp
 */
public class SujetService {

    Connection mycon;
    user u = new user();

    public SujetService() {
        mycon = MyBdConnection.getInstanceBD().getConnection();

    }

    public boolean insererSujet(Sujet suj) throws SQLException {

        String req1 = "INSERT INTO `sujet` "
                + "(`id_user`, `titre`, `theme`, `name_user`, `texte`, `date`)"
                + " VALUES ('" + suj.getId_user() + "','" + suj.getTitre() + "','" + suj.getTheme() + "','" + suj.getName_user() + "','" + suj.getTexte() + "','" + suj.getDate1()+"')";

        Statement ste = mycon.createStatement();
        int x = ste.executeUpdate(req1);
        return true;
    }
     private Statement st;
   public void modifierSujet(int id ,int id_user,String titre,String theme,String texte ) throws SQLException {

//        String requete = "UPDATE sujet SET  "
//                + " id_user=?, titre=?, theme=, name_user=?, texte=?, date=? WHERE id_sujet=" + suj.getId_sujet();
//        try {
//            PreparedStatement ps = mycon.prepareStatement(requete);
//
//            //ps.setInt(1,com.getId_comment());
//            ps.setInt(2, suj.getId_user());
//            ps.setString(3, suj.getTitre());
//            ps.setString(4, suj.getTheme());
//            ps.setString(5, suj.getName_user());
//            ps.setString(6, suj.getTexte());
//            ps.setString(7, suj.getDate1());
//
//            ps.executeUpdate();
//            System.out.println("forum modifiÃ©e");
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de modification " + ex.getMessage());
//        }
//
//        return false;

    

     String sql = "UPDATE `sujet` SET `id_user`='"+ id_user +"',`titre`='" + titre + "',`theme`='" + theme +"',`texte`='" + texte+"' WHERE id_sujet='" + id + "'";
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

    public boolean supprimersujet(int id ) throws SQLException {

        String req = "delete from sujet where "
                + "id_sujet= ? ";

        PreparedStatement ps = mycon.prepareStatement(req);
        ps.setInt(1, id);
        ps.executeUpdate();
        return true;

    }

    public void Affichersujet(String dd) throws SQLException {
        String req1 = "select * from sujet c inner join user u on c.id_user=u.id_user where u.nom='" + dd + "';";

        Statement ste = mycon.createStatement();
        ResultSet res = ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("sujet des " + res.getString("titre"));

        }
    }

//     public void Affichercommentaire(int dd) throws SQLException {
//          String req1 = "select * from commentaire c inner join user u on c.id_user=u.id_user where u.mdp="+dd;
//       
//       Statement ste = mycon.createStatement();
//      ResultSet res= ste.executeQuery(req1);
//        while (res.next()) {
//            System.out.println("forum est "+res.getString("commentaire"));
//            
//        }
//    }
    public ArrayList<Sujet> listeRech2(String dd) {

        ArrayList<Sujet> list = new ArrayList<Sujet>();
        ResultSet rs; // pour récupérer le résultat de select

        String req = "SELECT * FROM `sujet` WHERE `theme`= '" + dd + "'  ; ";
        try {
            PreparedStatement ps = mycon.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Sujet suj = new Sujet();
                suj.setTitre(result.getString("titre"));
                list.add(suj);
            }
            return list;
        } catch (Exception ee) {
            System.out.println("Erreur dans la recherche" + ee.getMessage());
            return list;
        }

    }

    //done//
    public ArrayList<Sujet> Affiches() {
        try {
            String requete = "select * from sujet";
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Sujet> suje = new ArrayList<>();
            while (result.next()) {
                Sujet suj = new Sujet();
                suj.setId_sujet(result.getInt("id_sujet"));
                suj.setId_user(result.getInt("id_user"));
                suj.setTitre(result.getString("titre"));
                suj.setTheme(result.getString("theme"));
                suj.setName_user(result.getString("name_user"));
                suj.setTexte(result.getString("texte"));
                suj.setDate1(result.getString("date"));
                suje.add(suj);
            }
            return suje;
        } catch (Exception ee) {
            System.out.println("erreur dan select randonnées " + ee.getMessage());
        }
        return null;
    }
 


   
 
    public ArrayList<Sujet> AffichesUser(int dd) {
        try {
            String requete = "select * from sujet where id_user="+dd;
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Sujet> suje = new ArrayList<>();
            while (result.next()) {
         
                Sujet suj = new Sujet();
                suj.setId_sujet(result.getInt("id_sujet"));
                suj.setId_user(result.getInt("id_user"));
                suj.setTitre(result.getString("titre"));
                suj.setTheme(result.getString("theme"));
                suj.setName_user(result.getString("name_user"));
                suj.setTexte(result.getString("texte"));
                suj.setDate1(result.getString("date"));
                suje.add(suj);
            }
            return suje;
        } catch (Exception ee) {
            System.out.println("erreur dan select randonnées " + ee.getMessage());
        }
        return null;
    }

    //done//
    public List<Sujet> RechercheSu(String them) throws SQLException {
        List<Sujet> covs = new ArrayList<>();
        ResultSet result = null;
        Sujet c = null;
        try {
            String req3 = "select * from sujet where theme=? "; // AND arrivee=? AND date=?
            PreparedStatement stee = mycon.prepareStatement(req3);
            stee.setString(1, them);
            /* ste.setString(2, arrivee);
            ste.setDate(3, date);*/

            result = stee.executeQuery();

            while (result.next()) {

                c = new Sujet(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }
    
      public List<Sujet> Rechercheform(String titre) throws SQLException {
        List<Sujet> covs = new ArrayList<>();
        ResultSet result = null;
        Sujet c = null;
        try {
            String req3 = "select * from sujet where titre=? "; // AND arrivee=? AND date=?
            PreparedStatement stee = mycon.prepareStatement(req3);
            stee.setString(1, titre);
            /* ste.setString(2, arrivee);
            ste.setDate(3, date);*/

            result = stee.executeQuery();

            while (result.next()) {

                c = new Sujet(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));

                covs.add(c);

            }
        } catch (SQLException ex) {
        }
        return covs;

    }
        public ArrayList<Sujet> Affichessujet(String dd)throws SQLException{
        try {
            String requete = "select * from sujet where titre='" + dd + "';";
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Sujet> suje = new ArrayList<>();
            while (result.next()) {
         
                Sujet suj = new Sujet();
                suj.setId_sujet(result.getInt("id_sujet"));
                suj.setId_user(result.getInt("id_user"));
                suj.setTitre(result.getString("titre"));
                suj.setTheme(result.getString("theme"));
                suj.setName_user(result.getString("name_user"));
                suj.setTexte(result.getString("texte"));
                suj.setDate1(result.getString("date"));
                suje.add(suj);
            }
            return suje;
        } catch (Exception ee) {
            System.out.println("erreur dan select randonnées " + ee.getMessage());
        }
        return null;
    }

}
