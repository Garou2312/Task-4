package com.example.task5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public ImageView imageView;
    public ImageCollection imgs = new ImageCollection("Слайд");
    public Iterator iter_main = imgs.getIterator();
    public Timeline timeline = new Timeline();


    @FXML
    /*protected void onHelloButtonClick() {
        imageView.setImage(new Image ("/picture1.jpg"));
    }*/
    public void onHelloButtonClick(ActionEvent t) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            imageView.setImage(name);
        }
    }
    public void onButtonClick(ActionEvent t) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.preview();
            imageView.setImage(name);
        }
    }
    public void onPlay (ActionEvent actionEvent) {
        timeline.play();
    }

    public void onNext(ActionEvent actionEvent) {

    };

    public void onPause(ActionEvent actionEvent) {
        timeline.stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (iter_main.hasNext()) {
                    Image name = (Image)iter_main.next();
                    imageView.setImage(name);
                }
            }
        }));
    }

}