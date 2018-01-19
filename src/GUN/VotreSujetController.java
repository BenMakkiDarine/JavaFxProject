/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUN;

import entites.Forum;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import entites.Sujet;
import entites.user;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import service.SujetService;
import javafx.scene.control.Alert;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ForumService;
import java.net.URL;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class VotreSujetController implements Initializable{

    @FXML
    private AnchorPane VotreSujet;
    @FXML
    private TableView<Sujet> tableview;
    @FXML
    private TableColumn<Sujet, String> titrec;
    @FXML
    private TableColumn<Sujet, String> sujetc;
    @FXML
    private TableColumn<Sujet, String> crec;
    @FXML
    private TableColumn<Sujet, String> desc;
    private TextField titreS;
    @FXML
    private TextField creeS;
    @FXML
    private TextArea desS;


     

       private ForumService forum = new ForumService();
  private ObservableList<Forum> forumList = FXCollections.observableArrayList();
    @FXML
    private AnchorPane Votresujet;
    @FXML
    private Button ajouter1;
    @FXML
    private TextField sujs;
    @FXML
    private Button retou;
    @FXML
    private ComboBox<Forum> forumS;
    @FXML
    private TextField dates;
    
      user user= new user(8);  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       forumList = FXCollections.observableArrayList(forum.Affiches());
        
   forumS.getItems().addAll(forumList);
        forumS.setCellFactory(new Callback<ListView<Forum>,ListCell<Forum>>() {

            @Override
            public ListCell<Forum> call(ListView<Forum> p) {

                final ListCell<Forum> cell = new ListCell<Forum>() {

                    @Override
                    protected void updateItem(Forum t, boolean bln) {
                        super.updateItem(t, bln);

                        if (t != null) {

                            setText(t.getForum_owner());
                        } else {

                            setText(null);
                        }
                    }

                };

                return cell;
            }
        });
       ShowItem() ;  
    }    
   
        
   

       

    @FXML
    private void ajouter(ActionEvent event) {
           try {
            boolean showAlerte = false;
            String description = null;
            if (forumS.getValue()==null) {
                
                description = "Nom obligatoire";
             
                showAlerte = true;
            }  
            else if (desS.getText().length() == 0) {
                description = "commentaire bligatoire";
              
               ajouter1.getScene().getStylesheets().add(getClass().getResource("text-field-red-border.css").toExternalForm());
                showAlerte = true;
           
            }  else if (sujs.getText().length() == 0) {
                description = "sujet obligatoire";
                showAlerte = true;
                
                 
            } else if (creeS.getText().length() == 0) {
                description = "obligatoire";
               
               ajouter1.getScene().getStylesheets().add(getClass().getResource("text-field-red-border.css").toExternalForm());
                showAlerte = true;
            } 
             
        SujetService svo=new SujetService();
        Sujet v = new Sujet(user.getId_user(),forumS.getValue().toString(),sujs.getText(),creeS.getText(),desS.getText(),dates.getText()) ;
                   

svo.insererSujet(v);
System.out.println("done!!!!!! ");
 ShowItem();
                      
                
            
        } catch (Exception e) {
            e.printStackTrace();
            showMessageDialoge("Erreur", "Erreur d'insertion");
        }  
        
     
    }
  private void showMessageDialoge(String msg, String description) {
        
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alerte");
        alert.setHeaderText(msg);
        alert.setContentText(description);

        alert.showAndWait();
        
    }  
    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        
        
          SujetService com1 = new  SujetService();
        Sujet p = tableview.getSelectionModel().getSelectedItem();
           com1.modifierSujet(p.getId_sujet(),user.getId_user(),forumS.getValue().toString() ,sujs.getText(),creeS.getText());
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
    private void afficher(ActionEvent event) {
        
         SujetService s1 = new SujetService();
      Sujet p = tableview.getSelectionModel().getSelectedItem();
        int idtemp=p.getId_sujet();
        
       sujs.setText(p.getTheme());
        dates.setText(p.getDate1());
        desS.setText(p.getTexte());
        creeS.setText(p.getName_user());

        
        
    }
    
    
    
    //user//
    
      public void ShowItem() {
        Task<List<Sujet>> task = new Task() {
            SujetService sc = new SujetService();
           
           
            @Override
            protected Object call() throws SQLException {
                List<Sujet> suj = sc.AffichesUser(user.getId_user());
                return suj;
            }
        };
        task.setOnSucceeded(e -> {
            titrec.setCellValueFactory(new PropertyValueFactory<>("theme"));
            sujetc.setCellValueFactory(new PropertyValueFactory<>("titre"));
            crec.setCellValueFactory(new PropertyValueFactory<>("name_user"));
            desc.setCellValueFactory(new PropertyValueFactory<>("texte"));

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
    private void retour(ActionEvent event) {
         try {
            Stage stage = new Stage();
            Stage currentStage = (Stage) retou.getScene().getWindow();
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
}