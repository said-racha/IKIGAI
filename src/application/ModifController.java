package application;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import classes.Inscription;
import classes.User;
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
import javafx.scene.control.Label;
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
	    private TextField nouveauemail;
	    @FXML
	    private TextField email;

	    @FXML
	    private TextField password;


	    @FXML
	    private TextField sexeTextF;
	    @FXML
	    private TextField confpass;

	    @FXML
	    private Button signUpBtn;

	    @FXML
	    private Button helpBtn;

	    @FXML
	    private Button backBtn;
	    @FXML
	    private Label Confirmation;
	    @FXML
	    void Back(ActionEvent event) throws IOException {

	    	Parent root =FXMLLoader.load(getClass().getResource("Home.fxml"));
	        
	   	   Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	   	   Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	   	  window.setScene(scene);
	   	   window.show();
	    }
	    
	    
	    
	    public void ModifUserBtn() throws Exception {
			User u = new User();

			if(u.isDataBaseConnected())/*verifie que le logiciel est bien cooennecter a la BDD*/ {
		
				
				try {
					u.ModifierUSR(nameTextF.getText(), email.getText(), nouveauemail.getText(), password.getText(), skillTextF.getText());
	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
			{

				Confirmation.setText("Echec de l'ajout");
			}

}
}
