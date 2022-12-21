package com.example.ss1201;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class Subject extends ImageView {
    //オブザーバー(観測者)リスト
    private ArrayList<Observer> observers = new ArrayList<>();

    Subject(Image i) {
        super(i);
    }

    //オブザーバー追加
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    //オブザーバー削除
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    //オブザーバーに通知
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this); //観測対象(例えばミサイル)の情報をオブザーバーに渡す
        }
    }
}