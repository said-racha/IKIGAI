package application;

import java.io.IOException;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class HomeController {
	@FXML
    private Button pp;

    @FXML
    private Button dev;

    @FXML
    private Button sh;

    @FXML
    private Button aj;

    @FXML
    private Button progres;

    @FXML
    private Button sport;

    @FXML
    private Button ed;

    @FXML
    private Button appris;
    
    
    
    @FXML
    void sport(ActionEvent event) throws IOException  {
    	
    	Parent root =FXMLLoader.load(getClass().getResource("PointPos.fxml"));
           
    	   Scene scene = sport.getScene();
           root.translateXProperty().set(scene.getWidth());

           AnchorPane parentcontainer = (AnchorPane) scene.getRoot();

           parentcontainer.getChildren().add(root);

           Timeline timeline = new Timeline();
           KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
           KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
           timeline.getKeyFrames().add(kf);
           timeline.setOnFinished(t -> {
               parentcontainer.getChildren().remove(parentcontainer);
           });
           timeline.play();
    }

    @FXML
    void sh(ActionEvent event) {

    }

    @FXML
    void aj(ActionEvent event) {

    }

    @FXML
    void dev(ActionEvent event) {

    }

    @FXML
    void progres(ActionEvent event) {

    }

    @FXML
    void ed(ActionEvent event) {

    }

    @FXML
    void pp(ActionEvent event) {

    }

    @FXML
    void appris(ActionEvent event) {

    }
}
