package com.example.ss1201;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Hachi extends ImageView {
    static Image hachiImage =
            new Image(Paths.get("C:\\Users\\batap\\IdeaProjects\\sisutemusekei2\\src\\main\\resources\\images\\Hachi.png").toUri().toString());
    Timeline timeline;

    Hachi(){
        super((hachiImage));

        this.setX(300);
        this.setY(150);

        timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {move();}));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    private void move(){
        setX(getX()+5);
    }
}
