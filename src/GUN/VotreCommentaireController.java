/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUN;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import service.CommentaireService;
import entites.Commentaire;
import entites.user;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import service.SujetService;
import entites.Sujet;
import java.io.IOException;
import javafx.event.EventType;
import javafx.util.Callback;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class VotreCommentaireController implements Initializable {

    @FXML
    private AnchorPane votreComentaire;
    @FXML
    private TableView<Commentaire> tableview;
    @FXML
    private TableColumn<Commentaire, String> sujc;
    @FXML
    private TableColumn<Commentaire, String> datec;
    @FXML
    private TableColumn<Commentaire, String> comc;
    @FXML
    private TextArea comts;
    
    user user= new user(8); 
     private SujetService suj = new SujetService();
       private ObservableList<Sujet> sujetList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<Sujet> comboS;
    @FXML
    private Button valide;
    @FXML
    private Button retou;
    @FXML
    private TextField pseudo;
    @FXML
    private AnchorPane d;
    @FXML
    private TextField id_date;

     
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            sujetList = FXCollections.observableArrayList(suj.Affiches());
        
        comboS.getItems().addAll(sujetList);
       
        comboS.setCellFactory(new Callback<ListView<Sujet>,ListCell<Sujet>>() {

            @Override
            public ListCell<Sujet> call(ListView<Sujet> p) {

                final ListCell<Sujet> cell = new ListCell<Sujet>() {

                    @Override
                    protected void updateItem(Sujet t, boolean bln) {
                        super.updateItem(t, bln);

                        if (t != null) {

                            setText(t.getTheme());
                        } else {

                            setText(null);
                        }
                    }

                };

                return cell;
            }
        });  
        
    ShowItem();
    }    

    @FXML
    private void valider(ActionEvent event) {
        
        
          try {
            boolean showAlerte = false;
            String description = null;
             if (comboS.getValue() == null) {
                description = "sujet obligatoire";
                showAlerte = true;
                
                 
            } else if (comts.getText().length() == 0) {
                description = "obligatoire";
               
               valide.getScene().getStylesheets().add(getClass().getResource("text-field-red-border.css").toExternalForm());
                showAlerte = true;
            } 
            
            else if (datec.getText().length() == 0) {
                description = "obligatoire";
               
               valide.getScene().getStylesheets().add(getClass().getResource("text-field-red-border.css").toExternalForm());
                showAlerte = true;
            } 
             
             
             
             else if (pseudo.getText().length() == 0) {
                description = "obligatoire";
               
               valide.getScene().getStylesheets().add(getClass().getResource("text-field-red-border.css").toExternalForm());
                showAlerte = true;
            } 
                
        CommentaireService svo=new CommentaireService();
      
              Commentaire v = new Commentaire(user.getId_user(),comts.getText(),comboS.getValue().toString(),pseudo.getText(),datec.getText(),"0");

svo.insererCommentaire(v);
System.out.println("done!!!!!! ");
                      
                
            
        } catch (Exception e) {
            e.printStackTrace();
            showMessageDialoge("Erreur", "Erreur d'insertion");
        }
ShowItem();
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
               CommentaireService com1 = new  CommentaireService();
        Commentaire p = tableview.getSelectionModel().getSelectedItem();
        com1.update(p.getId_comment(),comts.getText());
        ShowItem();
        
      ShowItem();  
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        
               try {

            if (!tableview.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                
                alert.setTitle("suppression");
                alert.setHeaderText("etes-vous sur que vous voulez supprimer :  "
                        + tableview.getSelectionModel().getSelectedItem().getId_comment());
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    CommentaireService abc = new CommentaireService ();
                    abc.supprimercommentaire(tableview.getSelectionModel().getSelectedItem().getId_comment());
                    ShowItem();
                }

            }
        } catch (Exception ex) {
            System.out.println("erreur lors du chargement des forums " + ex.getMessage());

        }
ShowItem();
    }
        
        
    

    @FXML
    private void afficher(ActionEvent event) {
             CommentaireService s1 = new CommentaireService();
      Commentaire p = tableview.getSelectionModel().getSelectedItem();
        int idtemp=p.getId_comment();
        
        comts.setText(p.getCommentaire());
       
        
        
    }
    
    

       public void ShowItem() {
		Task<List<Commentaire>> task = new Task() {
			CommentaireService sc = new CommentaireService();

			@Override
			protected Object call() throws SQLException {
				// Platform.runLater(() -> prog.setVisible(true));

				List<Commentaire> compa = sc.AffichesUser(user.getId_user());
				return compa;
			}
		};
		task.setOnSucceeded(e -> {
			
			comc.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
			sujc.setCellValueFactory(new PropertyValueFactory<>("titre"));
                        datec.setCellValueFactory(new PropertyValueFactory<>("date_env"));
			
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
            Logger.getLogger(VotreCommentaireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
}
