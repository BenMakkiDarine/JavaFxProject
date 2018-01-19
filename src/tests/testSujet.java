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
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import service.SujetService;
import entites.Sujet;

/**
 *
 * @author hp
 */
public class testSujet {
 static Connection mycon;
    public static void main(String[] args) {
        try {
         mycon = MyBdConnection.getInstanceBD().getConnection();

         //Forum fom = new Forum();
//                   //Randonnee r1 = new Randonnee(4,5,"foret",20,120.5f,"velo");
//             Forum fom =new Forum(5,"espace santés sirine");
//            
//              user u=new user(5,5555,"marwa");
//              
//             
//        Sujet suj2= new Sujet(9);   
           
        
             
       SujetService sujetservice= new SujetService();
     
       SujetService s= new SujetService();  
      //Sujet saj=new Sujet();
//     Sujet suj1= new Sujet(9,8,8,"sirine","lop","mlk","mmm","mpo","mm","zzz");
//      Sujet suj8=new Sujet(9);
   //sujetservice.insererSujet(suj1) ;
        //  sujetservice.insererSujet(suj)
         // sujetservice.sujetservice(suj1);
////   sujetservice.Affichessujet("randonnées");
     //sujetservice.modifierSujet(suj1);
     //sujetservice.supprimersujet(suj1);
   
        ArrayList<Sujet> suj = new ArrayList<Sujet>();
           suj= sujetservice.Affichessujet("randonnées") ;
             for (int i = 0; i < suj.size(); i++) {
            System.out.println(suj.get(i)+"\n");
             }
//          //
//        ArrayList<Sujet> suj = new ArrayList<Sujet>();
//               suj=s.listeRech2("espace santés sirine");
//          System.out.println(suj);
// sujetservice.Affichersujet("marwa") ;
            
       } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    
 
    
    
    
    }
    }
    

