package com.example.ss1201;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ImageMove extends Application {
    Image tanpopoImage =
            new Image("images/tanpopo.png");
    ImageView tanpopo = new ImageView(tanpopoImage);
    Image tulipImage =
            new Image("images/tulip.png");
    ImageView tulip = new ImageView(tulipImage);
    Image taiyouImage =
            new Image("images/taiyou.png");
    ImageView taiyou = new ImageView(taiyouImage);

    @Override
    public void start(Stage stage) {

        stage.setTitle("矢印キーを押してごらん");
        stage.setWidth(1000);
        stage.setHeight(500);


        BorderPane root = new BorderPane();
        root.setBottom(tanpopo);
        root.setTop(taiyou);

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(450),
                        event -> move())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        //(4)
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(this::onKeyPressed);

        //(5)
        stage.setScene(scene);
        //(6)
        stage.show();
    }

    private void move() {
        double x = taiyou.getTranslateX();
        taiyou.setTranslateX(x + 30);
    }

    void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            tanpopo.setImage(tulipImage);
            new Image("images/tulip.png");
        }
        if (event.getCode() == KeyCode.RIGHT) {
            double x = tanpopo.getTranslateX();
            if (x < 900)
                tanpopo.setTranslateX(x + 10);
        } else if (event.getCode() == KeyCode.LEFT) {
            double x = tanpopo.getTranslateX();
            if (x > 0)
                tanpopo.setTranslateX(x - 10);
        }
    }

    public static void main(String[] args) {
        System.out.println("画像を表示して、矢印キーで動かしてみよう");
        launch();
    }
}
