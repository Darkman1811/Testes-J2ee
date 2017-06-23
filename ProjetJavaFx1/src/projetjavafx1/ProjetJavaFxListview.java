/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavafx1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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

public class ProjetJavaFxListview extends Application {
    Stage window;
    Button button;
    ListView<String> listView;
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
    window=primarystage;
    window.setTitle("ListeView ");
    
        
    Button button = new Button("Submit");

    listView =new ListView<>();
    listView.getItems().addAll("IronMan","Titanic","Contact","Surrogates");
    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
    button.setOnAction(e->buttonClicked());
    //Layout
    VBox layout=new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));      
    layout.getChildren().addAll(listView,button);
    
    
    Scene scene= new Scene(layout,300,250);
    window.setScene(scene); 
    window.show();
    }

    private void buttonClicked(){
        String message="";
        ObservableList<String> movies;
        movies=listView.getSelectionModel().getSelectedItems();
        for(String m: movies){
            message+=m+"\n";
        }
        System.out.println(message);
    }
    
}
