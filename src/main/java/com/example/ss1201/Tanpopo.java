package com.example.ss1201;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.nio.file.Paths;

public class Tanpopo  extends ImageView{
    static Image tanpopoImage =
            new Image(Paths.get("C:\\Users\\batap\\IdeaProjects\\sisutemusekei2\\src\\main\\resources\\images\\tanpopo.png").toUri().toString());
    static Image tulipImage =
            new Image(Paths.get("C:\\Users\\batap\\IdeaProjects\\sisutemusekei2\\src\\main\\resources\\images\\tulip.png").toUri().toString());

    Tanpopo(){
        super(tanpopoImage);

        this.setX(0);
        this.setY(300);
    }
    public void move(KeyCode key){
        if(key == KeyCode.RIGHT && getX()<800){
            setX(getX()+5);
        }else if (key == KeyCode.LEFT && getX()>60){
            setX(getX()-5);
        }
    }
    public void changeImage(){
        if (getImage()==tanpopoImage)
            setImage(tulipImage);
        else
            setImage(tanpopoImage);
    }
}
