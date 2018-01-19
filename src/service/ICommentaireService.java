/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entites.Commentaire;
import entites.Sujet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public interface ICommentaireService {
    
     public  boolean insererCommentaire(Commentaire com) throws SQLException;
     public  boolean modifierCommentaire(Commentaire com) throws SQLException;
       public  boolean supprimerCommentaire(Commentaire com) throws SQLException ;
        public void AfficherCommentaire() throws SQLException;
         public ArrayList<Commentaire> listeRech2(int nom_forum)throws SQLException;
         public ArrayList<Commentaire> Affiches()throws SQLException;
           public  boolean update(Commentaire com) throws SQLException;
         
         public Commentaire findById(Integer r) throws SQLException;
         
      
          
          public List<Commentaire> RechercherV(String titre1) throws SQLException;
          
          public List<Commentaire> RechercheCommentaire(String poste) throws SQLException; 
          
           public ArrayList<Commentaire> AffichesUser(int dd) throws SQLException;
    
         
}
