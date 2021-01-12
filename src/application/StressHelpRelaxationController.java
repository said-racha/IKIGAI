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

public class StressHelpRelaxationController implements Initializable{
	@FXML
	private AnchorPane container;
	@FXML
	private Button backBtn;
	@FXML
    private Button temoignage;
	

	@FXML private WebView webView;
	@FXML private WebEngine engine;// c'est ce qui va me permettre de charger notre webView (charge la val entrée a engine pr l'affiché dans le webview
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		engine= webView.getEngine();
	}
	
	
	public void btn1(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=4YPww2uaWYQ&ab_channel=ilovepanicattacks");
		
	}
	
	public void btn2(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=bphhWzXeQKU&ab_channel=KatiMorton");
	}
	
	public void btn3(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=tU90Ae4Jqj8&ab_channel=RebekahBorucki");
	}
	
	public void btn4(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=tybOi4hjZFQ&ab_channel=WimHof");
	}
	
	public void btn5(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=vXZ5l7G6T2I&ab_channel=AnxietyinOrder");
	}
	
	public void btn6(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=Evgx9yX2Vw8&ab_channel=GreatMeditation");
	}
	
	public void btn7(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=SWESKYhETmQ&ab_channel=TheAnxietyGuy");
	}
	
	public void btn8(ActionEvent event) {
		engine.load("https://www.youtube.com/watch?v=maNr_0zK5VQ&ab_channel=BeInspired");
		
	}
	
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
    void temoignage(ActionEvent event) throws IOException {
    	
    	engine.load(null);//fermer le webview
    	
    	Parent root =FXMLLoader.load(getClass().getResource("StressHelpTemoignage.fxml"));
        
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
