/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjavafx1;

import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.scene.Scene;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
/**
 *
 * @author Super
 */

public class ProjetJavaFxTreeView extends Application {
    Stage window;
    TreeView<String> tree;
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
    
    TreeItem<String> root,bucky,megan;
    
    
    //Root
    root=new TreeItem<>();
    root.setExpanded(true);
    
    //Bucky
    bucky=makeBranch("Bucky",root);
    makeBranch("thenewboston", bucky);
    makeBranch("Youtube", bucky);
    makeBranch("Chicken", bucky);
    
    //Megan
    megan=makeBranch("Megan", root);
    makeBranch("Glitter", megan);
    makeBranch("MakeUp", megan);
    
    //Create Tree
    tree=new TreeView<>(root);
    tree.setShowRoot(false);
    tree.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
        if(newValue!=null){
            System.out.println(newValue.getValue());
        }
    });
    
    
    //Layout
    StackPane layout=new StackPane();
    layout.getChildren().add(tree);
    Scene scene= new Scene(layout,300,250);
    window.setScene(scene); 
    window.show();
    }

    //Create Branches
    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
      TreeItem<String> item= new TreeItem<>(title);
      item.setExpanded(true);
      parent.getChildren().add(item);
      return item;
    }

    
}
