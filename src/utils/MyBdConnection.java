/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class MyBdConnection {
      //String url = "jdbc:mysql:"+ "//localhost:3306/randonnee_pidev";
    String url="jdbc:mysql://localhost:3306/escape3";
   String login ="root";
   String pwd ="";
   Connection mycon;
   static MyBdConnection instanceBD;
  
    private MyBdConnection() {
      try {
          mycon = DriverManager.getConnection(url, login, pwd);
          System.out.println("connexion établie !!");
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
        
    }
    
    public static MyBdConnection  getInstanceBD(){
        if(instanceBD == null)
            instanceBD = new MyBdConnection();
        return instanceBD;
        
    }
    
    public Connection getConnection(){
        return mycon;
    }
    
    
}
