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

public class ProjetJavaFxChoiceBox1 extends Application {
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
        
  //ChoiceBox
    ChoiceBox <String> choiceBox= new ChoiceBox<>();
    //getItmes returns the ObservableList which you can add itmes to
    
    choiceBox.getItems().add("Apples");
    choiceBox.getItems().add("Bananas");
    choiceBox.getItems().addAll("Annanas","Coconuts","Orange");
    
    choiceBox.setValue("Apples");
    
    Button button = new Button("Order Now");
    button.setOnAction(e->getChoice(choiceBox));
    
    //Layout
    VBox layout=new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));      
    layout.getChildren().addAll(choiceBox,button);
    
    
    Scene scene= new Scene(layout,300,250);
    window.setScene(scene); 
    window.show();
    }

 //To get the value of the selected item
    private void getChoice(ChoiceBox<String> choiceBox){
       String food= choiceBox.getValue();
       System.out.println(food);
    }
    
    
}
