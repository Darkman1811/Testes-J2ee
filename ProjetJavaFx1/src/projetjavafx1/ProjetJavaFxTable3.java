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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
/**
 *
 * @author Super
 */

public class ProjetJavaFxTable3 extends Application {
    Stage window;
    TableView<Product> table;
    TextField nameInput,priceInput,quantityInput;
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
  
    //Name input
    nameInput = new TextField();
    nameInput.setPromptText("Name");
    
    //Price input
    priceInput = new TextField();
    priceInput.setPromptText("Price");
    
    //Quantity input
    quantityInput = new TextField();
    quantityInput.setPromptText("Quantity");
    
    //Button
    Button addButton=new Button("Add");
    addButton.setOnAction(e->addButtonClicked());
    
    Button deleteButton=new Button("Delete");
    deleteButton.setOnAction(e->deleteButtonClicked());
    
    HBox hBox=new HBox();
    hBox.setPadding(new Insets(10, 10, 10, 10));
    hBox.setSpacing(10);
    
    hBox.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);
    
    table=new TableView<>();
    table.setItems(getProduct());
    table.getColumns().addAll(nameColumn,priceColumn,quantityColumn);
    
    //Layout
    VBox vBox=new VBox();
    vBox.getChildren().addAll(table,hBox); 
    Scene scene= new Scene(vBox);
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

    //Add Button Clicked
    public void addButtonClicked() {
       Product product=new Product();
       product.setName(nameInput.getText());
       product.setPrice(Double.parseDouble(priceInput.getText()));
       product.setQuantity(Integer.parseInt(quantityInput.getText()));
       
       table.getItems().add(product);
       nameInput.clear();
       priceInput.clear();
       quantityInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked() {
       ObservableList<Product> productSelected, allProducts;
       allProducts = table.getItems();
       productSelected=table.getSelectionModel().getSelectedItems();
       allProducts.removeAll(productSelected);
     //  productSelected.forEach(allProducts::remove);
    }
    
}
