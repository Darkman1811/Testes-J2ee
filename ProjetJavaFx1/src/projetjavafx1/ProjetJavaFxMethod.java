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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Super
 */
public class ProjetJavaFxMethod extends Application implements EventHandler<ActionEvent>{
    Button button;
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
      primarystage.setTitle("Title of the window");      
      button=new Button();
      button.setText("Click me");
      button.setOnAction(this);
   
       
      StackPane layout= new StackPane();
      layout.getChildren().add(button);
      
      Scene scene= new Scene(layout,300,250);
      primarystage.setScene(scene);
      primarystage.show();
    }

    @Override
    public void handle(ActionEvent event) {
      if(event.getSource()==button)  {
          System.out.println("OOooooo i love it whene you touch me there");
      }
    }
   
    
}
