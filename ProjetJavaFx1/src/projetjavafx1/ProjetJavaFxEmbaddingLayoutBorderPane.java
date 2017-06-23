/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavafx1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Super
 */

public class ProjetJavaFxEmbaddingLayoutBorderPane extends Application {
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
    
   
    
    button=new Button("Close Program");
       
      StackPane layout= new StackPane();
      layout.getChildren().add(button);
      
      HBox topMenu= new HBox();
      Button buttonA= new Button("File");
      Button buttonB= new Button("Edit");
      Button buttonC= new Button("View");
      topMenu.getChildren().addAll(buttonA,buttonB,buttonC);
      
      
      VBox leftMenu= new VBox();
      Button buttonD= new Button("D");
      Button buttonE= new Button("E");
      Button buttonF= new Button("F");
      leftMenu.getChildren().addAll(buttonD,buttonE,buttonF);
      
      BorderPane borderPane=new BorderPane();
      borderPane.setTop(topMenu);
      borderPane.setLeft(leftMenu);
      
      Scene scene= new Scene(borderPane,300,250);
      primarystage.setScene(scene);
      primarystage.show();
    }

  
    
}
