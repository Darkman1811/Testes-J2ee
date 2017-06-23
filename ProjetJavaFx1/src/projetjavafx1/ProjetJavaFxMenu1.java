/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavafx1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
/**
 *
 * @author Super
 */

public class ProjetJavaFxMenu1 extends Application {
    Stage window;
    BorderPane layout;
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
    window=primarystage;
    window.setTitle("thenewboston ");
    
    //FileMenu
    Menu fileMenu= new Menu("_File");
    
    
    //Menu Items
    MenuItem newFile=new MenuItem("New...");
    newFile.setOnAction(e->System.out.println("Create a new File"));
    fileMenu.getItems().add(newFile);
    
    //fileMenu.getItems().add(new MenuItem("New ..."));
    fileMenu.getItems().add(new MenuItem("Open..."));
    fileMenu.getItems().add(new MenuItem("Save..."));
    fileMenu.getItems().add(new SeparatorMenuItem());
    fileMenu.getItems().add(new MenuItem("Settings..."));
    fileMenu.getItems().add(new SeparatorMenuItem());
    fileMenu.getItems().add(new MenuItem("Exit..."));
    
    //Edit menu
    Menu editMenu= new Menu("_Edit");
    editMenu.getItems().add(new MenuItem("Cut"));
    editMenu.getItems().add(new MenuItem("Copy"));
          
    MenuItem paste=new MenuItem("Paste");
    paste.setOnAction(e->System.out.println("Pasting some crap"));
    paste.setDisable(true);
    editMenu.getItems().add(paste);
    
    
    
    
    //Main menu bar
    MenuBar menuBar= new MenuBar();
    menuBar.getMenus().addAll(fileMenu,editMenu);
    
    
    //Layout
    layout=new BorderPane();    
    layout.setTop(menuBar);
    
    Scene scene= new Scene(layout,400,300);
    window.setScene(scene); 
    window.show();
    }


    
}
