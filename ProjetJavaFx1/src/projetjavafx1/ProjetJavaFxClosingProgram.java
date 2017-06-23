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

public class ProjetJavaFxClosingProgram extends Application {
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
    
    window.setOnCloseRequest(e->{
        e.consume();
        closeProgram();
            });
    
    button=new Button("Close Program");
    button.setOnAction(e->closeProgram());
         
      StackPane layout= new StackPane();
      layout.getChildren().add(button);
      
      Scene scene= new Scene(layout,300,250);
      primarystage.setScene(scene);
      primarystage.show();
    }

   private void closeProgram(){
       /*System.out.println("File Saved");
       window.close();*/
       Boolean answer=ConfirmBox.display("Title", "Sure you want to exit?");
       if(answer)
       {
           window.close();
       } 
    
                             }
    
}
