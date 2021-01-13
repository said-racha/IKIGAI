package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginController implements Initializable{

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
    private Label isConnected;

    LoginModel loginModel=new LoginModel();// creer un obj loginModel revient a connect�e notre controller a la bdd puisque la connexion se fait dans le constructeur de loginModel 
											//(ainsi nous obtenons une connexion a la bdd a chaque fois qu'on ouvre l'application (etant donn�e que Login est la premiere interface qu'on rencontre))

    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	if(this.loginModel.isDataBaseConnected())
			System.out.println("connexion reussi a la bdd");
		else
			System.out.println("echec de la connexion a la bdd");

	}

    
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
		
    	
    	
    }
    static String nom=" ";

	//qui verifie le mdp et le user name 
	public void Login(ActionEvent event) {
		try {
			
			
			//si le username ET le password sont correct on ouvre la session hadi 
			if(loginModel.isLogin(emailTextF.getText(),passwordTextF.getText()))
			
			
			{
				System.out.println("user et mdp correct");
				isConnected.setText("Nom d'utilisateur et Mot de passe correct");
	//avoir le nom de l'utilistauer
				nom = loginModel.GetName(emailTextF.getText(), passwordTextF.getText());
				Parent root =FXMLLoader.load(getClass().getResource("Home.fxml"));
		        
			   	   Scene scene = new Scene(root);
			   	   Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			   	  window.setScene(scene);
			   	   window.show();
			
				
				
			
			}//fin if de si connecté 
			
			
			
			
			
			else {
				isConnected.setText("Username and pass word not correct");
				
				
				
				
		}
		} catch (SQLException e) 
		{
			System.out.println("erreur dans login methode");
			isConnected.setText("Username and pass word not correct");
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		//ta3 la fenetre 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
