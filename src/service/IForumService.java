/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.sql.SQLException;
import entites.Forum ;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public interface IForumService {
          public ArrayList<Forum> Affiches() throws SQLException;
    public  boolean insererForum(Forum f) throws SQLException;
     public  boolean modifierForum(Forum f) throws SQLException;
       public  boolean supprimerForum(Forum f) throws SQLException ;
        public void AfficherForum() throws SQLException;
       
    
}
