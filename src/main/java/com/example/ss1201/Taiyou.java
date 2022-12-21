package com.example.ss1201;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.BitSet;


public class Taiyou extends ImageView implements Observer {
    static Image taiyouImage =
            new Image(Paths.get("C:\\Users\\batap\\IdeaProjects\\sisutemusekei2\\src\\main\\resources\\images\\taiyou.png").toUri().toString());
    static Image taiyouImage2 =
            new Image(Paths.get("C:\\Users\\batap\\IdeaProjects\\sisutemusekei2\\src\\main\\resources\\images\\tanpopo.png").toUri().toString());
    Timeline timeline;
    Taiyou() {
        super(taiyouImage);
        this.setX(0);
        this.setY(20);
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            move();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void move() {
        setX(getX() + 10);
    }

    @Override
    public void update(Subject s) {
        Tane h = (Tane) s;
        double hx = h.getX();
        double hy = h.getY();
        //自分（太陽）の座標
        double x = getX();
        double y = getX();

        System.out.printf("update(%f,%f) (%f,%f)\n", hx, hy, x, y);
        if (this.intersects(h.getBoundsInLocal())) {
            System.out.println("あたった");
            changeImage();
        }
    }

    private void changeImage() {
            if (getImage() ==taiyouImage)
                setImage(taiyouImage2);
            else
                setImage(taiyouImage);//就職しろ.就職就職
        }
    }
