package application;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import classes.Inscription;
import classes.User;
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
import javafx.scene.control.Label;
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
    private Label Confirmation;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Parent root2 =FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene= signUpBtn.getScene();
		
		
		root2.translateYProperty().set(-scene.getHeight());
		StackPane parentContainer=(StackPane) scene.getRoot();
		parentContainer.getChildren().add(root2);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Timeline timeline=new Timeline();
		KeyValue kv=new KeyValue(root2.translateYProperty(), 0, Interpolator.EASE_IN);
		KeyFrame kf =new KeyFrame(Duration.seconds(1), kv);
		timeline.getKeyFrames().add(kf);
		timeline.setOnFinished(event2 ->{
			parentContainer.getChildren().remove(container);
		});
		timeline.play();
    }
    
    
	
	public void AjouterUserBtn() throws Exception {
		Inscription i = new Inscription();

		if(i.isDataBaseConnected())/*verifie que le logiciel est bien cooennecter a la BDD*/ {
	
			
			try {
		
					
					 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");  
					   LocalDateTime now = LocalDateTime.now();  
					   String dateDeb= dtf.format(now); 	
					System.out.println(dateDeb);
					//si le user n'existe pas on l'ajoute
					if(i.chercherUser(emailTextF.getText())==0){
					
						i.AjouterInformations(1, nameTextF.getText(), emailTextF.getText(), mdpTextF.getText(),  confirmMdpTextF.getText(),dateDeb, skillTextF.getText());
					
					}else {
						//sinon on affiche une erreur
						Confirmation.setText("Cet utilisateur existe deja");
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else
		{

			Confirmation.setText("Echec de l'ajout");
		}
		
		
		
	}

}
