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

public class ProjetJavaFxCss extends Application {
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
    GridPane grid = new GridPane();
    grid.setPadding( new Insets(10,10,10,10));
    grid.setVgap(8);
    grid.setHgap(10);
    
    
    //Name Label
    Label nameLabel= new Label("User name:");
   // nameLabel.setStyle("-fx-text-fill: #e8e8e8");
    nameLabel.setId("bold-label");
    GridPane.setConstraints(nameLabel, 0, 0);
    
    // Name Input
    TextField nameInput= new TextField("Abdoulaye");
    GridPane.setConstraints(nameInput, 1, 0);
    
    //Password Label
    Label passLabel= new Label("Password:");
    GridPane.setConstraints(passLabel, 0, 1);
    
    //Password Input
    TextField passInput= new TextField();
    passInput.setPromptText("Enter your password");
    GridPane.setConstraints(passInput, 1, 1);
     
    //Login
    Button loginButton = new Button("Log in");
    GridPane.setConstraints(loginButton, 1, 2);
    
    //Sign Up
    Button signUpButton= new Button("Sign Up");
    signUpButton.getStyleClass().add("button-blue");
    GridPane.setConstraints(signUpButton,1,3);
    
    /*
    loginButton.setOnAction(e->{
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
    });
    */
    
    grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton,signUpButton);
    
    Scene scene= new Scene(grid,300,200);
    scene.getStylesheets().add("Viper.css");
    window.setScene(scene); 
    window.show();
    }

  
    
}
