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
//public class ProjetJavaFx1 extends Application implements EventHandler<ActionEvent>{
public class ProjetJavaFxInnerClass extends Application {
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
      
        button.setOnAction(new EventHandler(){
          @Override
          public void handle(Event t) {
           System.out.println("hello Inner Class");
          }                                              
                                              });
      
       
      StackPane layout= new StackPane();
      layout.getChildren().add(button);
      
      Scene scene= new Scene(layout,300,250);
      primarystage.setScene(scene);
      primarystage.show();
    }

  
    
}
