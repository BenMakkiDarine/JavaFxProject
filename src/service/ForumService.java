/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entites.Forum;
import utils.MyBdConnection;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class ForumService {

    Connection mycon;

    public ForumService() {
        mycon = MyBdConnection.getInstanceBD().getConnection();

    }

    public boolean insererForum(Forum f) throws SQLException {

        String req1 = "INSERT INTO `forum` "
                + "(`idF`,`nomF`,`topicF`)"
                + " VALUES ('" + f.getId_forum() + "', '" + f.getForum_owner() + "', '" + f.getForum_topic() + "'); ";

        Statement ste = mycon.createStatement();
        int x = ste.executeUpdate(req1);
        return true;
    }

    public boolean modifierForum(Forum f) throws SQLException {

        String requete = "UPDATE forum SET  "
                + "nomF=?, topicF=? WHERE id_forum=" + f.getId_forum();

        try {

            PreparedStatement ps = mycon.prepareStatement(requete);
            ps.setString (1, f.getForum_owner());
            ps.setString(2, f.getForum_topic());
            ps.executeUpdate();
            System.out.println("forum modifiÃ©e");

        } catch (SQLException ex) {
            // System.out.println(f.getId_forum());
            System.out.println("erreur lors de modification " + ex.getMessage());
        }

        return false;
    }

    public boolean supprimerForum(Forum f) throws SQLException {

        String req = "delete from forum where "
                + "idF= ? ";

        PreparedStatement ps = mycon.prepareStatement(req);
        ps.setInt(1, f.getId_forum());
        ps.executeUpdate();
        return true;

    }

    public void AfficherForum() throws SQLException {
        String req1 = "select * from forum";

        Statement ste = mycon.createStatement();
        ResultSet res = ste.executeQuery(req1);
        while (res.next()) {

            System.out.println("forum est: " + res.getInt("nomF") + "theme" + " :" + res.getString("topicF"));

        }
    }
    
       public ArrayList<Forum> Affiches()  {
        try {
            String requete = "select * from forum";
            PreparedStatement ps = mycon.prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Forum> suj = new ArrayList<>();
            while (result.next()) {
                Forum com = new Forum();
                //com.setId_forum(result.getInt("idF"));
                com.setForum_owner(result.getString("nomF"));
                com.setForum_topic(result.getString("topicF"));  
                suj.add(com);
            }
            return suj;
        } catch (Exception ee) {
            System.out.println("erreur dan select " + ee.getMessage());
        }
        return null;
    }
    
   
       
       

}
