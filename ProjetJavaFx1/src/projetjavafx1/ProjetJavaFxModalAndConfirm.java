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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Super
 */

public class ProjetJavaFxModalAndConfirm extends Application {
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
    window.setTitle("thenewboston");
    
    button=new Button("Click Me");
    button.setOnAction(e->{
        boolean result=ConfirmBox.display("Title of the window", "Are you sure you want to display naked pics?");
        System.out.println(result);
            });
         
      StackPane layout= new StackPane();
      layout.getChildren().add(button);
      
      Scene scene= new Scene(layout,300,250);
      primarystage.setScene(scene);
      primarystage.show();
    }

   
    
}
