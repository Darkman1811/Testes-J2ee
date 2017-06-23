/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavafx1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class ProjetJavaFxPropertiesBinding extends Application {
    Stage window;
  
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
  
    //Input and Lables
    TextField userInput= new TextField();
    userInput.setMaxWidth(200);
    Label firstLabel=new Label("Welcome to the site ");
    Label secondLabel=new Label();
    
    HBox bottomText=new HBox(firstLabel,secondLabel);
    bottomText.setAlignment(Pos.CENTER);

    secondLabel.textProperty().bind(userInput.textProperty());
   
    
    VBox vBox=new VBox(10,userInput,bottomText);
    vBox.setAlignment(Pos.CENTER);
    
    
    Scene scene= new Scene(vBox,300,200);    
    window.setScene(scene); 
    window.show();
    }

  
    
}
