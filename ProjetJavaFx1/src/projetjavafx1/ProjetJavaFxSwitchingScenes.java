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

public class ProjetJavaFxSwitchingScenes extends Application {
    Stage window;
    Scene scene1,scene2;
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
     window=primarystage;
     
     Label label1=new Label("Welcome to the first scene");
     Button button1=new Button("Go to scene 2");
     button1.setOnAction(e-> window.setScene(scene2));
     
     //Layout 1 - children are laid out in a vertical column
     VBox layout1=new VBox(20);
     layout1.getChildren().addAll(label1,button1);
     scene1= new Scene(layout1,200,200);
     
     
     //Button 2
     Button button2=new Button("This scene sucks go back to scene 1");
     button2.setOnAction(e-> window.setScene(scene1));
     
     
     //Layout 2
     StackPane layout2=new StackPane();
     layout2.getChildren().addAll(button2);
     scene2= new Scene(layout2,600,300);
     
     
     window.setScene(scene1);
     window.setTitle("Title here");
     window.show();
    }

   
    
}
