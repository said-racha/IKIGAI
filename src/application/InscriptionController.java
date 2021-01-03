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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class InscriptionController {

	 @FXML
	private AnchorPane container;
	 
    @FXML
    private TextField nameTextF;

    @FXML
    private TextField skillTextF;

    @FXML
    private TextField emailTextF;


    @FXML
    private TextField sexeTextF;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button helpBtn;

    @FXML
    private Button backBtn;
    
    @FXML
    private PasswordField mdpTextF;
    
    @FXML
    private PasswordField confirmMdpTextF;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Parent root2 =FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene= signUpBtn.getScene();
		
		
		root2.translateYProperty().set(-scene.getHeight());
		StackPane parentContainer=(StackPane) scene.getRoot();
		parentContainer.getChildren().add(root2);
		
		Timeline timeline=new Timeline();
		KeyValue kv=new KeyValue(root2.translateYProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf =new KeyFrame(Duration.seconds(1), kv);
		timeline.getKeyFrames().add(kf);
		timeline.setOnFinished(event2 ->{
			parentContainer.getChildren().remove(container);
		});
		timeline.play();
    }

}
