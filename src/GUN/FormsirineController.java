/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUN;

import com.sun.org.glassfish.external.statistics.Statistic;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import entites.Forum;
import entites.Sujet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ForumService;
import entites.Forum;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FormsirineController implements Initializable {


    @FXML
    private AnchorPane forum;
    @FXML
    private Button go;
    @FXML
    private Button statistique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
      
          

    @FXML
    private void goo(ActionEvent event) throws IOException {
        
                Parent consulterCom = FXMLLoader.load(getClass().getResource("/GUN/EspaceSujet.fxml"));
                Scene scene = new Scene(consulterCom);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
           
        
        
    }

    @FXML
    private void satat(ActionEvent event) {
           try {
                Parent piechart = FXMLLoader.load(getClass().getResource("/GUN/Statistique.fxml"));
                Scene scene = new Scene(piechart);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(StatistiqueController.class.getName()).log(Level.SEVERE, null, ex);
            }    
    

        
    }
    
    
}
