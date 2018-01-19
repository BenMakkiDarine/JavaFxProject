/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUN;



import entites.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.CommentaireService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class StatistiqueController implements Initializable {

     ObservableList<Data> pieChartData=FXCollections.
            observableArrayList();
    @FXML
    private PieChart piechart;
    @FXML
    private AnchorPane stat;
    @FXML
    private Button ret;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
            
              CommentaireService com = new CommentaireService();
       ArrayList<Commentaire> comm_ron = null;
       ArrayList<Commentaire> comm_new = null;
       ArrayList<Commentaire> comm_conseil = null;
       ArrayList<Commentaire> comm_anonce = null;
       int num_randonee=0;
       int num_of_newest=0;
       int num_of_conseil=0;
       int num_of_annonce=0;
        try {
            comm_ron = com.getcomment_for_randonn();
            comm_new = com.getcomment_for_newest();
            comm_conseil = com.getcomment_for_conseils();
            comm_anonce = com.getcomment_for_annonce();
            
        } catch (SQLException ex) {
            Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
        }

       for(Commentaire l : comm_ron){
          num_randonee=num_randonee+1;
                }
        System.out.println(num_randonee);

       
       for(Commentaire l2 : comm_new){
          num_of_newest=num_of_newest+1;
           
       }
       System.out.println(num_of_newest);
       
       for(Commentaire l3 : comm_conseil){
          num_of_conseil=num_of_conseil+1;
       }
       
       
       for(Commentaire l4 : comm_anonce){
          num_of_annonce=num_of_annonce+1;
       }
            
            
            ObservableList<PieChart.Data> pieChartData
            = FXCollections.observableArrayList(
        
        
        
new PieChart.Data("randonnées", num_randonee),
new PieChart.Data("nouveautés", num_of_newest),
new PieChart.Data("conseils", num_of_conseil),
new PieChart.Data("annonces", num_of_annonce));
piechart.setData(pieChartData);




/*
             CommentaireService sc = new CommentaireService();
 
        try {
            List<Commentaire> compa = sc.Affiches();
        } catch (SQLException ex) {
            Logger.getLogger(PieChartController.class.getName()).log(Level.SEVERE, null, ex);
        }

		ObservableList<PieChart.Data> lis =FXCollections.observableArrayList();
        try {
            sc.Affiches().stream().collect(Collectors.groupingBy
                (f->f.getTitre() , Collectors.counting())).forEach((t,count)->lis.add(new PieChart.Data(t, count)));
        } catch (SQLException ex) {
            Logger.getLogger(PieChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
			piechart.setData(lis);      
		piechart.setAnimated(true);
			
			
			
	
		
		
	



		
		piechart.setData(pieChartData);
		
		piechart.setStartAngle(90);
		
            
            */
              }

    @FXML
    private void retou(ActionEvent event) {
          try {
            Stage stage = new Stage();
            Stage currentStage = (Stage) ret.getScene().getWindow();
            Parent forum = FXMLLoader.load(getClass().getResource("Formsirine.fxml"));

            Scene scene = new Scene(forum);

            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            currentStage.close();
        } catch (IOException ex) {
            Logger.getLogger(EspaceSujetController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
         
    
}
