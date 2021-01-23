package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import classes.User;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class AddTAskController implements Initializable{

    @FXML
    private TextField addtask;
    
    private int idfU=0;
    private int nbrJour=0;
    private int idfDate=0;
    private int numSeq=0;
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		//si la base de données est connectéé
    	User CurrentUser= new User();	
   	 	LoginModel Model  = new LoginModel();
   	 	
		
    	try {
    		
    		if(CurrentUser.isDataBaseConnected()) {
    					
    		 CurrentUser = Model.getInfoUser(LoginController.email, LoginController.password,  CurrentUser);
 			//Ceci nous permet d'avoir les informations de l'utilisateur courrant
    		
    		idfU=CurrentUser.getIdUser().getValue().intValue();
    		nbrJour=8;//CurrentUser.getNbJour(CurrentUser.getIdUser().getValue().intValue());
    		idfDate=Integer.valueOf(String.valueOf(idfU)+String.valueOf(nbrJour));
    		//recupere le nombre de tasks q'uil a deja entre pour pouvoir par la suite en ajouter un a la fin de la liste
    		if (HomeModel.getNbrTasksAjouter(idfDate) != -1)
    			numSeq= HomeModel.getNbrTasksAjouter(idfDate);
    		
    		
    		}
    		
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		
		
		
		addtask.setOnKeyPressed(new EventHandler<KeyEvent>() {
    	
			@Override
			public void handle(KeyEvent ke) {
				
				switch(ke.getCode()) {
				case ENTER:
					
					numSeq++;//ecrire a la ligne suivante 
					HomeModel.setOneTask(idfDate, numSeq, addtask.getText());
				    addtask.setText("");
					
					break;
				default:
					break;
				}
			}
			
		});
		
	}

  

}
