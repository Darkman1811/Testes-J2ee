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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
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

public class ProjetJavaFxCheckBox extends Application {
    
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
    window.setTitle("Poissons et viande ");
        
    //CheckBox 
    CheckBox box1= new CheckBox("Viande");
    CheckBox box2= new CheckBox("Poisson");
    box2.setSelected(true);
    Button button = new Button("Order Now");
    button.setOnAction(e->{
        handleOptions(box1,box2);
    });
    //Layout
    VBox layout=new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));      
    layout.getChildren().addAll(box1,box2,button);
    
    
    Scene scene= new Scene(layout,300,250);
    window.setScene(scene); 
    window.show();
    }

 //Handle CheckBox Options
    private void handleOptions(CheckBox box1,CheckBox box2){
        String message="Users Order: ";
        if (box1.isSelected()){
            message+="\n Viande";
        }
        if(box2.isSelected()){
            message+="\n Poisson";
        }
        System.out.println(message);
    }
}
