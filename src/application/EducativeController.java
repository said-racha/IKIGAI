package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import classes.Educative;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class EducativeController implements Initializable{
    @FXML
    private Button home;
    @FXML
    private TextArea consulterEducative;

    
    private int nbrJour;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
    	nbrJour=3; //a remplacer par user.getNbrJour();
    	consulterEducative.setText("\n\n"+Educative.getContenuEducatif(nbrJour));
		
	}
    
    

    @FXML
    void home(ActionEvent event) throws IOException {
 // transition a l'envers
    
    		Parent root =FXMLLoader.load(getClass().getResource("Home.fxml"));

    Scene scene = home.getScene();
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
