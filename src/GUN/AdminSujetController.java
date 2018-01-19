/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUN;

import service.SujetService;
import entites.Sujet;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.SujetService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AdminSujetController implements Initializable {

    @FXML
    private TableView<Sujet> tableview;
    @FXML
    private TableColumn<Sujet, String> titrec;
    @FXML
    private TableColumn<Sujet, String> themec;
    @FXML
    private TableColumn<Sujet, String> ouvertc;
    @FXML
    private TableColumn<Sujet, String> textc;
    @FXML
    private TableColumn<Sujet, String> datec;
    @FXML
    private Button supprime;
    @FXML
    private Button consulter;
    @FXML
    private AnchorPane Admin;
    private TextField rech;
    @FXML
    private TextField recht;

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

            if (!tableview.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                user current= StaticVars.currentUser;
                alert.setTitle("suppression");
                alert.setHeaderText("etes-vous sur que vous voulez supprimer :  "
                        + tableview.getSelectionModel().getSelectedItem().getId_sujet());
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    SujetService abc = new SujetService();
                    abc.supprimersujet(tableview.getSelectionModel().getSelectedItem().getId_sujet());
                    ShowItem();
                }

            }
        } catch (Exception ex) {
            System.out.println("erreur lors du chargement des forums " + ex.getMessage());

        }
        
    }

    @FXML
    private void consulter(ActionEvent event) {
 try {
                Parent consulterCom = FXMLLoader.load(getClass().getResource("/GUN/AdminCommentaire.fxml"));
                Scene scene = new Scene(consulterCom);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ConsulterLesCommentairesController.class.getName()).log(Level.SEVERE, null, ex);
            }    
    }

   
    
    
      public void ShowItem() {
        Task<List<Sujet>> task = new Task() {
            SujetService sc = new SujetService();

            @Override
            protected Object call() throws SQLException {
                List<Sujet> suj = sc.Affiches();
                return suj;
            }
        };
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
                titrec.setCellValueFactory(new PropertyValueFactory<>("titre"));
                themec.setCellValueFactory(new PropertyValueFactory<>("theme"));
                ouvertc.setCellValueFactory(new PropertyValueFactory<>("name_user"));
                textc.setCellValueFactory(new PropertyValueFactory<>("texte"));
                datec.setCellValueFactory(new PropertyValueFactory<>("date"));
                
                tableview.setItems(FXCollections.observableArrayList(task.getValue()));
            }
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
    private void recherch(KeyEvent event) throws SQLException {
        SujetService R = new SujetService();
        String m=recht.getText();
        ObservableList<Sujet> data=FXCollections.observableArrayList(R.RechercheSu(m));
			 titrec.setCellValueFactory(new PropertyValueFactory<>("titre"));
            themec.setCellValueFactory(new PropertyValueFactory<>("theme"));
            ouvertc.setCellValueFactory(new PropertyValueFactory<>("user_name"));
            textc.setCellValueFactory(new PropertyValueFactory<>("texte"));
            datec.setCellValueFactory(new PropertyValueFactory<>("texte"));

        tableview.setItems(data);
        
    }

    @FXML
    private void actualise1(ActionEvent event) {
        
        ShowItem();
    }

    
}
