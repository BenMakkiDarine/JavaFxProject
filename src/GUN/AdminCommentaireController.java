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
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.CommentaireService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AdminCommentaireController implements Initializable {

    @FXML
    private TableView<Commentaire> tablev;
    @FXML
    private TableColumn<Commentaire, String> name;
    @FXML
    private TableColumn<Commentaire, String> coment;
    @FXML
    private TableColumn<Commentaire, String> titre;
    @FXML
    private TableColumn<Commentaire, String> signalec;
    @FXML
    private AnchorPane admincom;
    @FXML
    private Button sup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ShowItem();
    }    

    @FXML
    private void supprimer(ActionEvent event) {
        
               
               try {

            if (!tablev.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                
                alert.setTitle("suppression");
                alert.setHeaderText("etes-vous sur que vous voulez supprimer :  "
                        + tablev.getSelectionModel().getSelectedItem().getId_comment());
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    CommentaireService abc = new CommentaireService ();
                    abc.supprimercommentaire(tablev.getSelectionModel().getSelectedItem().getId_comment());
                    ShowItem();
                }

            }
        } catch (Exception ex) {
            System.out.println("erreur lors du chargement des forums " + ex.getMessage());

        }
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
			
			 name.setCellValueFactory(new PropertyValueFactory<>("user_name"));
			coment.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
                        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
                       
                        signalec.setCellValueFactory(new PropertyValueFactory<>("signals"));
			
			tablev.setItems(FXCollections.observableArrayList(task.getValue()));
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
    private void retour(ActionEvent event) {
         try {
            Stage stage = new Stage();
            Stage currentStage = (Stage) sup.getScene().getWindow();
            Parent Admin = FXMLLoader.load(getClass().getResource("AdminSujet.fxml"));

            Scene scene = new Scene(Admin);

            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            currentStage.close();
        } catch (IOException ex) {
            Logger.getLogger(EspaceSujetController.class.getName()).log(Level.SEVERE, null, ex);
        
        
        
        
    }
    }}
