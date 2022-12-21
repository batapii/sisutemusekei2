package com.example.ss1201;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class ImageMove extends Application {
    Image tanpopoImage =
            new Image(Paths.get("images/tanpopo.png").toUri().toString());
    ImageView tanpopo = new ImageView(tanpopoImage);

    @Override
    public void start(Stage stage) {

        stage.setTitle("矢印キーを押してごらん");
        stage.setWidth(1000);
        stage.setHeight(500);


        BorderPane root = new BorderPane();
        root.setBottom(tanpopo);

        //(4)
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(this::onKeyPressed);

        //(5)
        stage.setScene(scene);
        //(6)
        stage.show();
    }

    void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT) {
            double x = tanpopo.getTranslateX();
            tanpopo.setTranslateX(x + 10);
        }
    }

    public static void main(String[] args) {
        System.out.println("画像を表示して、矢印キーで動かしてみよう");
        launch();
    }
}
