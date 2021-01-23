package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import classes.Inscription;
import classes.User;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ModifController implements Initializable{
	
		 
	    @FXML
	    private TextField nameTextF;

	    @FXML
	    private TextField skillTextF;

	    @FXML
	    private TextField nouveauemail;
	    @FXML
	    private TextField email;

	    @FXML
	    private PasswordField password;


	    @FXML
	    private PasswordField confpass;

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
					
					//================================si les cases obligatoires sont vides, afficher une erreur===========
					if(email.getText().isEmpty() || password.getText().isEmpty()  || confpass.getText().isEmpty() ) {
						Confirmation.setText("Veuillez remplire les champs obligatoires");
					}
					else
					//================================si le mdp et sa confirmation ne sont pas egaux===========
						if(!password.getText().contentEquals(confpass.getText())) {
						Confirmation.setText("Le mot de passe et sa confirmation ne sont pas egaux");
					}
					

						
					else {
						//================================si le user decide e ne pas changer son email, on le met a l'ancien, pour pouvoir garder l'ancien dans la base de données==========
if(nouveauemail.getText().isEmpty()) {	nouveauemail.setText(email.getText());	}
					u.ModifierUSR(nameTextF.getText(), email.getText(), nouveauemail.getText(), password.getText(), skillTextF.getText());
					Confirmation.setText("Modification reusi");}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
			{

				Confirmation.setText("Echec de l'ajout");
			}

}

LoginController lc= new LoginController();

		@Override
		public void initialize(URL location, ResourceBundle resources) {
		if(lc.Currentuser.isDataBaseConnected()) {
			nameTextF.setText(lc.Currentuser.getFullName());
			email.setText(lc.Currentuser.getEmail());
			skillTextF.setText(lc.Currentuser.getSessionSkill());
			
		
		
		}
			
		}
}
