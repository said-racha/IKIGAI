package application;

import java.io.IOException;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ModifController {
	
		 
	    @FXML
	    private TextField nameTextF;

	    @FXML
	    private TextField skillTextF;

	    @FXML
	    private TextField emailTextF;

	    @FXML
	    private TextField phoneTextF;

	    @FXML
	    private TextField sexeTextF;

	    @FXML
	    private Button signUpBtn;

	    @FXML
	    private Button helpBtn;

	    @FXML
	    private Button backBtn;

	    @FXML
	    void Back(ActionEvent event) throws IOException {

	    	Parent root =FXMLLoader.load(getClass().getResource("Home.fxml"));
	        
	   	   Scene scene = new Scene(root);
	   	   Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	   	  window.setScene(scene);
	   	   window.show();
	    }

}
