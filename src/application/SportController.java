package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SportController {
	@FXML
	private AnchorPane container;
	@FXML
	private Button backBtn;
	@FXML
	private Button validerBtn;
	@FXML
    private TextArea sportTextA;

	// Event Listener on Button[#backBtn].onAction
	@FXML
	public void Back(ActionEvent event) throws IOException {
		
		Parent root =FXMLLoader.load(getClass().getResource("Home.fxml"));

        
	  	   Scene scene = backBtn.getScene();
	         root.translateYProperty().set(-scene.getHeight());

	         AnchorPane parentcontainer = (AnchorPane) scene.getRoot();

	         parentcontainer.getChildren().add(root);

	         Timeline timeline = new Timeline();
	         KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
	         KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
	         timeline.getKeyFrames().add(kf);
	         timeline.setOnFinished(t -> {
	             parentcontainer.getChildren().remove(parentcontainer);
	         });
	         timeline.play();
	}
}
