package com.example.ss1201;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Paths;

//Main クラス、画面表示
public class Main extends Application {
    Tanpopo tanpopo;
    Taiyou taiyou;
    Hachi hachi;
    Tane tane;
    static Image haikei =
            new Image(Paths.get("C:\\Users\\batap\\IdeaProjects\\sisutemusekei2\\src\\main\\resources\\images\\Haikei.png").toUri().toString());

    @Override
    public void start(Stage stage) {
        stage.setTitle("矢印キーを押してごらん");//Stage 設定、タイトル、大きさ
        stage.setWidth(1000);
        stage.setHeight(500);
        tanpopo = new Tanpopo();//Tanpopo インスタンス生成
        taiyou = new Taiyou();
        hachi = new Hachi();
        tane = new Tane();
        tane.addObserver(taiyou);
        Pane root = new Pane(); //自由に配置できる Pane レイアウトを使ってみる
//root に部品を載せる(ここ大事!)
        root.getChildren().addAll(tanpopo, taiyou, hachi, tane);
        //背景 ※imgはImageクラスであること
        BackgroundImage bimg = new BackgroundImage(haikei, null, null, null, null);
        Background bg1 = new Background(bimg);
        root.setBackground(bg1);

        Scene scene = new Scene(root);//Scene 生成

        scene.setOnKeyPressed(event -> keyPress(event));//キー入力を登録

        stage.setScene(scene);
        stage.show(); //表示
    }

    // キーが押された時の処理
    public void keyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT) {
            tanpopo.move(event.getCode());
        }
        if (event.getCode() == KeyCode.SPACE) {//スペースキー
            //tanpopo.changeImage();//絵が変わる
            tane.setPos(tanpopo.getX());
        }
    }

    //main メソッド
    public static void main(String[] args) {

        System.out.println("画像を表示して、矢印キーで動かしてみよう");
        launch();

    }
}
