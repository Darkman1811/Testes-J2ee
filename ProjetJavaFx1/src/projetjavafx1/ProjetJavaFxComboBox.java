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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
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

public class ProjetJavaFxComboBox extends Application {
    Stage window;
    Button button;
    ComboBox<String> comboBox;
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
    
    comboBox = new ComboBox<>();
    comboBox.getItems().addAll("Seigneur des anneaux","Troie","Warcraft","BlackHat");
    comboBox.setPromptText("What is your favorite movie?");
    comboBox.setEditable(true);
    
    comboBox.setOnAction(e->System.out.println("User selected:"+comboBox.getValue()));
        
    Button button = new Button("Submit");
    button.setOnAction(e->printMovie());
    
    //Layout
    VBox layout=new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));      
    layout.getChildren().addAll(comboBox,button);
    
    
    Scene scene= new Scene(layout,300,250);
    window.setScene(scene); 
    window.show();
    }

    private void printMovie(){
        System.out.println(comboBox.getValue());
    }
    
}
