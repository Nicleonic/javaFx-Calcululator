package com.example.calctwo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {
   @FXML
    private Pane titlePane;
   @FXML
   private ImageView close;
   @FXML
   private ImageView minimize;
   @FXML
   private Label viewer;

    private double num1 = 0;
    private String operator = "+";


    @FXML
   void onMouseClicked(MouseEvent event){

   }
    private  double x,y;

    public void init(Stage stage){
        titlePane = new Pane();
        titlePane.setOnMousePressed(mouseEvent ->{
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent->{
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
        close.setOnMouseClicked(mouseEvent -> stage.close());
        minimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    @FXML
    void onNumberClicked(MouseEvent event){
        //int value = 14;
        int value = Integer.parseInt(((Label)event.getSource()).getId().replace("ch",""));
        viewer.setText(Double.parseDouble(viewer.getText())==0?String.valueOf((double)value):String.valueOf(Double.parseDouble(viewer.getText())*10+value));
    }

    @FXML
    void onSymbolClicked(MouseEvent event){
        String symbol = ((Label)event.getSource()).getId().replace("btn","");

        if(symbol.equals("Equals")){
            double num2 = Double.parseDouble(viewer.getText());
            switch (operator){
                case "+" -> viewer.setText((num1+num2) + "") ;
                case "*" -> viewer.setText((num1*num2) + "") ;
                case "/" -> viewer.setText((num1/num2) + "") ;
                case "-" -> viewer.setText((num1-num2) + "") ;
            }
            operator = ".";
        }
        else if(symbol.equals("Clear")){
            viewer.setText((String.valueOf(0.0)));
            operator = ".";
        }
        else{
            switch (symbol){
                case "Add" -> operator = "+";
                case "Moins" -> operator = "-";
                case "Mult" -> operator = "*";
                case "Div" -> operator = "/";
            }
            num1 = Double.parseDouble(viewer.getText());
            viewer.setText(String.valueOf(0.0));
        }
    }
}