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

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
/**
 *
 * @author Super
 */

public class ProjetJavaFxTable1 extends Application {
    Stage window;
    TableView<Product> table;
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
    
    //Name Column
    TableColumn<Product,String> nameColumn= new TableColumn<>("Name");
    nameColumn.setMinWidth(200);
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            
    //Price Column
    TableColumn<Product,Double> priceColumn= new TableColumn<>("Price");
    priceColumn.setMinWidth(100);
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
  
      //Quantity Column
    TableColumn<Product,String> quantityColumn= new TableColumn<>("Quantity");
    quantityColumn.setMinWidth(100);
    quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
  
    table=new TableView<>();
    table.setItems(getProduct());
    table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);
    
    //Layout
    VBox layout=new VBox();
    layout.getChildren().addAll(table); 
    Scene scene= new Scene(layout,300,250);
    window.setScene(scene); 
    window.show();
    }
//Get all of the products
 public ObservableList<Product> getProduct(){
     ObservableList<Product> products= FXCollections.observableArrayList();
     products.add(new Product("Laptop",400000,20));
     products.add(new Product("Bouncy Ball",60000,75));
     products.add(new Product("HTC One",150000,15));
     products.add(new Product("Iphone",450000,45));
     products.add(new Product("Rasbery P",80000,12));
     return products;
 }
    
}
