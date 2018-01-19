/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUN;

import entites.Commentaire;
import entites.Sujet;
import entites.user;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.xml.stream.events.Comment;
import service.CommentaireService;
import service.SujetService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ConsulterLesCommentairesController implements Initializable {

    @FXML
    private AnchorPane consulterCom;
    @FXML
    private TextField rech;
    @FXML
    private TableView<Commentaire> tableview;
    @FXML
    private TableColumn<Commentaire, String> namec;
    @FXML
    private TableColumn<Commentaire, String> sujetc;
    @FXML
    private TableColumn<Commentaire, String> datec;
    @FXML
    private TableColumn<Commentaire, String> reponsesc;
    @FXML
    private Button ret;
    @FXML
    private Button act;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowItem();
        
    }    

 
          public void ShowItem() {
		Task<List<Commentaire>> task = new Task() {
			CommentaireService sc = new CommentaireService();

			@Override
			protected Object call() throws SQLException {
				// Platform.runLater(() -> prog.setVisible(true));

				List<Commentaire> compa = sc.Affiches();
				return compa;
			}
		};
		task.setOnSucceeded(e -> {
			
			 namec.setCellValueFactory(new PropertyValueFactory<>("user_name"));
			sujetc.setCellValueFactory(new PropertyValueFactory<>("titre"));
                        datec.setCellValueFactory(new PropertyValueFactory<>("date_env"));
                       
                        reponsesc.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
			
			tableview.setItems(FXCollections.observableArrayList(task.getValue()));
		});
		task.setOnFailed(e -> {
			try {
				ShowItem();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Thread th = new Thread(task);
		th.start();
	}  

    @FXML
    private void rechercher(ActionEvent event) throws SQLException {
        
        
           CommentaireService R = new CommentaireService();
        String m=rech.getText();
        ObservableList<Commentaire> data=FXCollections.observableArrayList(R.RecherchSujet(m));
	reponsesc.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
			sujetc.setCellValueFactory(new PropertyValueFactory<>("titre"));
                        datec.setCellValueFactory(new PropertyValueFactory<>("date_env"));
                        namec.setCellValueFactory(new PropertyValueFactory<>("user_name"));

        tableview.setItems(data);
        
        
    }

    @FXML
    private void retourner(ActionEvent event) {
          try {
            Stage stage = new Stage();
            Stage currentStage = (Stage) ret.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("EspaceSujet.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            currentStage.close();
        } catch (IOException ex) {
            Logger.getLogger(EspaceSujetController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void actualiser(ActionEvent event) {
        ShowItem();
        
    }

    @FXML
    private void signale(ActionEvent event) throws SQLException {
        
//        String ids=idcomm.getText();
        CommentaireService sc=new CommentaireService();
        sc.SignalCom(tableview.getSelectionModel().getSelectedItem().getId_comment());
        
    }
    //tableview.getSelectionModel().getSelectedItem().getId_comment()
    
}
