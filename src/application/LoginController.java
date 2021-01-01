package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.PasswordField;

public class LoginController {
	
	@FXML
	private TextField emailTextF;
	@FXML
	private Button loginBtn;
	@FXML
	private Button signUpBtn;
	@FXML
	private PasswordField passwordTextF;
	
	@FXML
	public void SignUp(ActionEvent event) throws IOException{
		
		Parent root2 =FXMLLoader.load(getClass().getResource("Inscription.fxml"));
		Scene scene= signUpBtn.getScene();
		root2.translateYProperty().set(scene.getHeight());
	}

}
