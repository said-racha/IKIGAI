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

public class LoginController {

    @FXML
    private StackPane parentContainer; //StackPane

    @FXML
    private AnchorPane container; //AnchorPane

    @FXML
    private TextField emailTextF;

    @FXML
    private Button loginBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private PasswordField passwordTextF;

    @FXML
    void SignUp(ActionEvent event) throws IOException {

    	Parent root2 =FXMLLoader.load(getClass().getResource("Inscription.fxml"));
		Scene scene= signUpBtn.getScene();
		
		root2.translateYProperty().set(scene.getHeight());
		parentContainer.getChildren().add(root2);
		
		Timeline timeline=new Timeline();
		KeyValue kv=new KeyValue(root2.translateYProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf =new KeyFrame(Duration.seconds(1), kv);
		timeline.getKeyFrames().add(kf);
		timeline.setOnFinished(event2 ->{
			parentContainer.getChildren().remove(container);
		});
		timeline.play();
		
    	/*ta7bet
    	Parent root2 =FXMLLoader.load(getClass().getResource("Inscription.fxml"));
		Scene scene= signUpBtn.getScene();
		
		
		root2.translateYProperty().set(-scene.getHeight());
		parentContainer.getChildren().add(root2);
		
		Timeline timeline=new Timeline();
		KeyValue kv=new KeyValue(root2.translateYProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf =new KeyFrame(Duration.seconds(5), kv);
		timeline.getKeyFrames().add(kf);
		timeline.setOnFinished(event2 ->{
			parentContainer.getChildren().remove(container);
		});
		timeline.play();*/
    	
    	/* sans effets
		Parent root2 =FXMLLoader.load(getClass().getResource("Inscription.fxml"));
		Scene scene= signUpBtn.getScene();
		
		root2.translateYProperty().set(0);
		parentContainer.getChildren().add(root2);
		
		KeyValue kv=new KeyValue(root2.translateYProperty(), 0, Interpolator.EASE_IN);*/
		
		
    }

}
