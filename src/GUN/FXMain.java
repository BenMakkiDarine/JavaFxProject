/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUN;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

/**

/**
 *
 * @author hp
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
      
//    Parent admincom = FXMLLoader.load(getClass().getResource("AdminCommentaire.fxml"));
//      
//        Scene scene = new Scene(admincom);
//
//        stage.setScene(scene);
//        stage.show();
//        
        
        Parent forum = FXMLLoader.load(getClass().getResource("Formsirine.fxml"));
      
        Scene scene = new Scene(forum);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
