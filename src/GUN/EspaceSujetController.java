/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUN;

import entites.Forum;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import entites.Sujet;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import service.SujetService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class EspaceSujetController implements Initializable {

    @FXML
    private AnchorPane espacesujet;
    @FXML
    private Button com;
    @FXML
    private Button suj;
    @FXML
    private TextField recherche;
    @FXML
    private TableView<Sujet> tableview;
    @FXML
    private TableColumn<Sujet, String> titrC;
    @FXML
    private TableColumn<Sujet, String> desC;
    @FXML
    private TableColumn<Sujet, String> creeC;
    @FXML
    private TableColumn<Sujet, String> DesCss;
    @FXML
    private Button act;
    @FXML
    private Button retou;
    @FXML
    private Button cons;
    @FXML
    private TextField rechf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ShowItem();

    }

    @FXML
    private void commenter(ActionEvent event) {
          try {
                Parent votreComentaire = FXMLLoader.load(getClass().getResource("/GUN/VotreCommentaire.fxml"));
                Scene scene = new Scene(votreComentaire);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceSujetController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
        
        
    }

    @FXML
    private void sujet(ActionEvent event) {
        
     try {
                Parent VotreSujet = FXMLLoader.load(getClass().getResource("/GUN/VotreSujet.fxml"));
                Scene scene = new Scene(VotreSujet);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EspaceSujetController.class.getName()).log(Level.SEVERE, null, ex);
            }    
        
    }

    public void ShowItem() {
        Task<List<Sujet>> task = new Task() {
            SujetService sc = new SujetService();
            //Forum f2 =new Forum();

           
            @Override
            protected Object call() throws SQLException {
                List<Sujet> suj = sc.Affiches();
           
                return suj;
            }
        };
        task.setOnSucceeded(e -> {
            titrC.setCellValueFactory(new PropertyValueFactory<>("titre"));
            desC.setCellValueFactory(new PropertyValueFactory<>("theme"));
            creeC.setCellValueFactory(new PropertyValueFactory<>("name_user"));
           DesCss.setCellValueFactory(new PropertyValueFactory<>("texte"));

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
    private void rech(KeyEvent event) throws SQLException {
        
          SujetService R = new SujetService();
        String m=recherche.getText();
        ObservableList<Sujet> data=FXCollections.observableArrayList(R.RechercheSu(m));
			 titrC.setCellValueFactory(new PropertyValueFactory<>("titre"));
            desC.setCellValueFactory(new PropertyValueFactory<>("theme"));
            creeC.setCellValueFactory(new PropertyValueFactory<>("name_user"));
            DesCss.setCellValueFactory(new PropertyValueFactory<>("texte"));

        tableview.setItems(data);
    }



    @FXML
    private void Actualiser(ActionEvent event) {
       ShowItem();
    }

    @FXML
    private void retour(ActionEvent event) {
        
        try {
            Stage stage = new Stage();
            Stage currentStage = (Stage) retou.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Formsirine.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            currentStage.close();
        } catch (IOException ex) {
            Logger.getLogger(FormsirineController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void counsulter(ActionEvent event) {
        
        try {
                Parent consulterCom = FXMLLoader.load(getClass().getResource("/GUN/Consulter les commentaires.fxml"));
                Scene scene = new Scene(consulterCom);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ConsulterLesCommentairesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
    }

    @FXML
    private void rechrf(KeyEvent event) throws SQLException {
        
         SujetService R = new SujetService();
        String s=rechf.getText();
        ObservableList<Sujet> data=FXCollections.observableArrayList(R.Rechercheform(s));
			 titrC.setCellValueFactory(new PropertyValueFactory<>("titre"));
            desC.setCellValueFactory(new PropertyValueFactory<>("theme"));
            creeC.setCellValueFactory(new PropertyValueFactory<>("name_user"));
            DesCss.setCellValueFactory(new PropertyValueFactory<>("texte"));

        tableview.setItems(data);
        
        
    }
        
        
    }

