/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package ch;

//import java.awt.event.KeyEvent;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;



/**
 *
 * @author almso
 */
public class Ch extends Application {

    @Override
    public void start(Stage primaryStage) {

        HBox root = new HBox();
        
        
        Label colorLabel = new Label("Fill Color: ");
        
        
        Label rotateLbl = new Label("Rotate: ");
        Button rotateRightButton = new Button(">>");
        Button rotateLeftButton = new Button("<<");
        
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(200);
        rectangle.setHeight(400);
        rectangle.setStroke(Color.RED);
        rectangle.setFill(Color.GREEN);
        
        
        ChoiceBox col = new ChoiceBox();
        col.getItems().addAll("blue", "red", "green");
         
        
        
        rotateRightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e){
            rectangle.setRotate(rectangle.getRotate() - 90);    
            }
           
        }); 
        
        
        
        rotateLeftButton.setOnAction(new EventHandler<ActionEvent>(){  
        @Override
        public void handle (ActionEvent e){   
        rectangle.setRotate(rectangle.getRotate() + 90);    
        }
        });
        
        
        
        CheckBox addStrokeCheck = new CheckBox("Add Stroke?");
        HBox clrBox = new HBox();
        HBox rotateBox = new HBox();
        Pane pane = new Pane();
        
        
        
        addStrokeCheck.setOnAction(e -> {
            if (addStrokeCheck.isSelected()) {
                rectangle.setStrokeWidth(5);
            } else {
                rectangle.setStrokeWidth(0);
            }
        });
        
        col.setOnAction(e -> {
        if (col.getValue()=="Red"){
             rectangle.setFill(Color.RED);      
            }
            
        else if (col.getValue()=="GREEN"){
              rectangle.setFill(Color.GREEN);
            } 
            
        else if (col.getValue()=="BLUE"){
             rectangle.setFill(Color.BLUE);
            }
              
            
            
        });
        
        /*****************************************/
        
        
        rectangle.setStrokeWidth(0);
       
        pane.getChildren().add(rectangle);
        pane.setStyle("-fx-background-color: white; -fx-border-color: blue; -fx-border-width: 3px");
        
        
        clrBox.getChildren().addAll(colorLabel, col);
        rotateBox.getChildren().addAll(rotateLbl, rotateLeftButton, rotateRightButton);
        clrBox.setAlignment(Pos.CENTER);
        rotateBox.setAlignment(Pos.CENTER);
        VBox controlor = new VBox();
        controlor.getChildren().addAll(clrBox, rotateBox, addStrokeCheck);
        
        
        root.getChildren().addAll(controlor, pane);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        
        
        
        controlor.setSpacing(10);
        controlor.setAlignment(Pos.CENTER);
        
        
        
        
    HBox.setHgrow(controlor, Priority.ALWAYS);
    HBox.setHgrow(pane, Priority.ALWAYS);
        
        
       
    
    root.setOnKeyPressed(e -> {
      
    if (e.getCode() == KeyCode.RIGHT) {
        rectangle.setLayoutX(rectangle.getLayoutX() + 10);
    } 
    else if (e.getCode() == KeyCode.LEFT) {
        rectangle.setLayoutX(rectangle.getLayoutX() - 10);
    }
    
    else if (e.getCode() == KeyCode.UP) {
        rectangle.setLayoutX(rectangle.getLayoutY() + 10);
    }
    
    else if (e.getCode() == KeyCode.DOWN) {
        rectangle.setLayoutX(rectangle.getLayoutY() - 10);
    }
   
    });
    
    
        primaryStage.setTitle("Lab 4");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();

    }
                

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
        launch(args);
    }
    


}

