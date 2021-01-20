package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import classes.Educative;
import classes.Sport;
import classes.User;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

public class SportController implements Initializable{
	
	@FXML
	private AnchorPane container;
	@FXML
	private Button backBtn;
	@FXML
    private Label ThemeDuJour;
	
	private int nbrJour=0;
	private String programmeDuJour;
	private String themeDuJour;
	
	
	@FXML private WebView webView;
	@FXML private WebEngine engine;// c'est ce qui va me permettre de charger notre webView (charge la val entrée a engine pr l'affiché dans le webview
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		User CurrentUser= new User();	
   	 	LoginModel Model  = new LoginModel();
		
   	 try {
 		
 		if(CurrentUser.isDataBaseConnected()) {
 					
 		 CurrentUser = Model.getInfoUser(LoginController.email, LoginController.password,  CurrentUser);
			//Ceci nous permet d'avoir les informations de l'utilisateur courrant
 		
 		 nbrJour=CurrentUser.getNbJour(CurrentUser.getIdUser().getValue().intValue());
 		
 		}
 		
	 } catch (Exception e) {
		
			e.printStackTrace();
		} 
		
		ThemeDuJour.setText(Sport.getThemeDuJour(nbrJour));
		
		engine= webView.getEngine();
		engine.load(Sport.getProgrammeDuJour(nbrJour));
		
	}
	
	
	@FXML
	public void Back(ActionEvent event) throws IOException {
		
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




	
}
