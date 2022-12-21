package com.example.ss1201;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Taiyou  extends ImageView {
    static Image taiyouImage =
            new Image(Paths.get("C:\\Users\\batap\\IdeaProjects\\sisutemusekei2\\src\\main\\resources\\images\\taiyou.png").toUri().toString());
    Timeline timeline;

    Taiyou(){
        super(taiyouImage);
        this.setX(0);
        this.setY(20);
        timeline = new Timeline( new KeyFrame(Duration.millis(1000), event -> {move();}));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    public void move(){
        setX(getX()+10);
    }
}
