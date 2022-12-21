package com.example.ss1201;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.nio.file.Paths;

//種クラス
public class Tane extends Subject {
    static Image taneImage =
            new Image(Paths.get("C:\\Users\\batap\\IdeaProjects\\sisutemusekei2\\src\\main\\resources\\images\\Tane.png").toUri().toString());
    Timeline timeline;

    Tane(){
        super(taneImage);
        this.setX(300);
        this.setY(300);
        timeline = new Timeline( new KeyFrame(Duration.millis(1000), event -> {move();}));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    public void move(){
        setY(getY()-80);
        notifyObservers();
    }
    //種のX座標を変更する
    public void setPos(double tanpopo_x) {
        setY(300);
        setX(tanpopo_x); //種のｘ座標を変更する
    }
}
