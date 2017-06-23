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

public class ProjetJavaFxBinding extends Application {
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
  
        IntegerProperty x=new SimpleIntegerProperty(3);
        IntegerProperty y=new SimpleIntegerProperty();
        
        y.bind(x.multiply(10));
        
        System.out.println("x: "+x.getValue());
        System.out.println("y: "+y.getValue()+"\n");
        
        x.setValue(9);
        System.out.println("x: "+x.getValue());
        System.out.println("y: "+y.getValue()+"\n");
        
        
    
    button = new Button("Submit");
   
    
    StackPane layout=new StackPane();
    layout.getChildren().addAll(button);
    
    Scene scene= new Scene(layout,300,200);    
    window.setScene(scene); 
    window.show();
    }

  
    
}
