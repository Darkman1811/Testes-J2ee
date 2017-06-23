/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavafx1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Super
 */

public class ProjetJavaFxProperties extends Application {
    Stage window;
    Button button;
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
    window=primarystage;
    window.setTitle("JavaFX - thenewboston");
   
   Personne bucky=new Personne();
   //Set up a listener to firstname
   bucky.firstNameProperty().addListener((v,oldValue,newValue)->{
       System.out.println("Name changed to: "+newValue);
       System.out.println("firstNameProperty(): "+bucky.firstNameProperty());
       System.out.println("getFirstname(): "+bucky.getFirstName());
   });
    
    
    button = new Button("Submit");
    button.setOnAction(e->bucky.setFirstName("Porky"));
    StackPane layout=new StackPane();
    layout.getChildren().addAll(button);
    
    Scene scene= new Scene(layout,300,200);    
    window.setScene(scene); 
    window.show();
    }

  
    
}
