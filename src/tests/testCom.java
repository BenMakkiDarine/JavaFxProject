/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import service.CommentaireService;
import service.ForumService;

import entites.Commentaire;
import entites.Forum;
import entites.Sujet;
import entites.user;
import  utils.MyBdConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class testCom {

    static Connection mycon;
    public static void main(String[] args) {
         try {
         mycon = MyBdConnection.getInstanceBD().getConnection();
//          connectionMysql();zzz
//          connectionMysql()
         //Commentaire com = new Commentaire();
                   //Randonnee r1 = new Randonnee(4,5,"foret",20,120.5f,"velo");
//             Sujet s=new Sujet(7, "jjjjj");
//             user u=new user(5,5,"jjjjj");
             
        CommentaireService commentaireservice = new CommentaireService();
        CommentaireService com = new CommentaireService();
     Commentaire com1= new Commentaire(5,"marwyta","ssmmmss","marwyta","mm");


     // commentaireservice.SignalCom(42);
      //commentaireservice.RechercheCommentaire("sss");
      //    
        //commentaireservice.supprimercommentaire(com1);
        commentaireservice.insererCommentaire(com1);
     //commentaireservice.update(42,5,"mm","mm","mù","po","hg");
      //commentaireservice.listeRech2("jjjjj") ;
////        ArrayList<Commentaire> suj = new ArrayList<Commentaire>();
////           suj=com.listeRech2("llll") ;
////             for (int i = 0; i < suj.size(); i++) {
////            System.out.println(suj.get(i)+"\n");
////             }
      //   commentaireservice.Affiches();
//////        ArrayList<Commentaire> suj = new ArrayList<Commentaire>();
//////               suj=com.listeRech2("espace santés sirine");
//////          System.out.println(suj);

            
       } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    
 
    
    
    
    }
    }
    

