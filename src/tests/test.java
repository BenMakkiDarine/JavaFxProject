/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import service.CommentaireService;
import entites.Forum;
import service.ForumService;
import utils.MyBdConnection;       
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class test {

   static Connection mycon;
    public static void main(String[] args) {
     try {
         mycon = MyBdConnection.getInstanceBD().getConnection();
//          connectionMysql();
//          connectionMysql()
        Forum f = new Forum();
                   //Randonnee r1 = new Randonnee(4,5,"foret",20,120.5f,"velo");
       
          ForumService forumservice = new ForumService();
          
        //forumservice.insererForum(f);
         //forumservice.insererForum(f);
         // forumservice.supprimerForum(f);
     //forumservice.AfficherForum();
    forumservice.modifierForum(f);
             ArrayList<Forum> suj = new ArrayList<Forum>();
           suj=forumservice.Affiches();
             for (int i = 0; i < suj.size(); i++) {
            System.out.println(suj.get(i)+"\n");
             }
          
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    
    
    
    
    
    }
    }
    

