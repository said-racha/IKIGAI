package application;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

public class StressHelpTemoignageController implements Initializable{
	
	@FXML
	private AnchorPane container;
	@FXML
	private Button backBtn;
	@FXML
    private Button relaxion;
	
	
	@FXML private WebView webView;
	@FXML private WebEngine engine;// c'est ce qui va me permettre de charger notre webView (charge la val entrée a engine pr l'affiché dans le webview
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		engine= webView.getEngine();
	}
	
	
	public void btn1(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=nuxxZVWTFk0&ab_channel=ChristyRisinger%2CMD");
		
	}
	
	public void btn2(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=eLUMkeyE7mU&ab_channel=MaudsleyNHS");
	}
	
	public void btn3(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=1DyjGJBOQYA&ab_channel=IndianaUniversitySchoolofMedicine");
	}
	
	public void btn4(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=4alCEoeESsU&ab_channel=Access");
	}
	
	public void btn5(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=ogn3XReEbQw&ab_channel=CBSEveningNews");
	}
	
	public void btn6(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=Xyf1ruAeF6c&ab_channel=GoodMorningAmerica");
	}
	
	public void btn7(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=qsHJt6y5mic&ab_channel=MedStarHealth");
	}
	
	public void btn8(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=PCQd3Jv0pQU&ab_channel=PBSNewsHour");
	}
	
	
	
	// Event Listener on Button[#backBtn].onAction
	@FXML
	public void Back(ActionEvent event)throws IOException {
		
		engine.load(null);//fermer le webview
		
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
	
	
	
	
    @FXML
    void relaxion(ActionEvent event) throws IOException {
    	
    	engine.load(null);//fermer le webview
    	
    	Parent root =FXMLLoader.load(getClass().getResource("StressHelpRelaxation.fxml"));

    	
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
