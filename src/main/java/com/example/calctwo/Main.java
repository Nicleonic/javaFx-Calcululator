package com.example.calctwo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static com.sun.glass.ui.Window.TRANSPARENT;

public class Main extends Application {
//    @FXML
//    private ImageView close;
//
//    @FXML
//    private ImageView minimize;
    private double x,y;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);

        // Management of displacement of the window
        scene.setOnMousePressed(mouseEvent ->{
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
        });
        scene.setOnMouseDragged(mouseEvent->{
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
        //===========================================

        ((MainController)fxmlLoader.getController()).init(stage);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/0.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}