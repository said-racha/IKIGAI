package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.control.textfield.AutoCompletionBinding;

import DbUtil.DbConnection;
import classes.Educative;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomeController implements Initializable{

    @FXML
    private Label nom;
    
    @FXML
    private Label nbrJourLabel;
    
    @FXML
    private Label challengeSLabel;
    
    @FXML
    private Label citationLabel;
    
    @FXML
    private Button addtask;
    
	@FXML
    private Button pp;

    @FXML
    private Button dev;

    @FXML
    private MenuButton sh;

    @FXML
    private Button aj;

    @FXML
    private Button progres;

    @FXML
    private Button sport;

    @FXML
    private Button ed;

    @FXML
    private Button appris;

    @FXML
    private Button signout;
    
    @FXML
    private TextField day;

    @FXML
    private TextField week;
    
    private int idfU=0;
    private int nbrJour=0;
    private String Fullname="";
    private String challengeS="";
    private String citation="";
    
    //private AutoCompletionBinding<String> autoCompletionBinding;///////////////////////////A SUPPRIMER/////////////////////////
    
    public void initialize(URL location, ResourceBundle resources) {
		//si la base de données est connectéé
    	User CurrentUser= new User();	
   	 	LoginModel Model  = new LoginModel();
   	 	
		
    	try {
    		
    		if(CurrentUser.isDataBaseConnected()) {
    					
    		 CurrentUser = Model.getInfoUser(LoginController.email, LoginController.password,  CurrentUser);
 			//Ceci nous permet d'avoir les informations de l'utilisateur courrant
    		
    		idfU=CurrentUser.getIdUser().getValue().intValue();
    		Fullname =CurrentUser.getFullName();
    		nbrJour=CurrentUser.getNbJour(CurrentUser.getIdUser().getValue().intValue());
    		challengeS=CurrentUser.getSessionSkill();
    		citation= HomeModel.getCitationDuJour(nbrJour);
    		
    		}
    		
		} catch (Exception e) {
		
			e.printStackTrace();
		} 
		//affichages des labels
    	nom.setText(String.valueOf(Fullname));
    	nbrJourLabel.setText(String.valueOf(nbrJour));
    	challengeSLabel.setText(challengeS);
    	citationLabel.setText(citation);
    	
    	
    	//remplissage des textfields
    	
    		//Pour que le textField enregistre la val d�s qu'on clique sur entrer
    		//autoCompletionBinding= TextFields.bindAutoCompletion(day, new ArrayList());/////////A SUPPRIMER M3a SON JAR FILE///////////////////////
    		
    		if(HomeModel.challengeJIsEditable(idfU, nbrJour,  day.getText()))
    		{
    			day.setOnKeyPressed(new EventHandler<KeyEvent>() {
    		

				@Override
				public void handle(KeyEvent ke) {
					
					switch(ke.getCode()) {
					case ENTER:
						
						HomeModel.setChallengeDay(idfU, nbrJour, day.getText());
						day.setEditable(false);
						
						break;
					default:
						break;
					}
				}
				
    		});
    		}
    		else 
    		{
    			day.setText(HomeModel.getChallengeDay(idfU, nbrJour));
    			day.setEditable(false);
    		}
    	
	}

    
   //TO CHANGE 
    @FXML
    void sport(ActionEvent event) throws IOException  {
    	
    	Parent root =FXMLLoader.load(getClass().getResource("Sport.fxml"));
           
    	   Scene scene = sport.getScene();
           root.translateYProperty().set(scene.getHeight());

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

    //stressHelp
    @FXML
    void relaxion(ActionEvent event) throws IOException {
    	Parent root =FXMLLoader.load(getClass().getResource("StressHelpRelaxation.fxml"));

        
	  	   Scene scene = sport.getScene();
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
    	Parent root =FXMLLoader.load(getClass().getResource("StressHelpTemoignage.fxml"));

        
	  	   Scene scene = sport.getScene();
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
    //SETTINGS
    @FXML
    void aj(ActionEvent event) throws IOException {
    	Parent root =FXMLLoader.load(getClass().getResource("Modif.fxml"));

        
    	   Scene scene = new Scene(root);
    	   Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	  window.setScene(scene);
    	   window.show();
 		
    }

    //devPerso
    @FXML
    void dev(ActionEvent event) throws IOException {
    	Parent root =FXMLLoader.load(getClass().getResource("ConsulterDevPerso.fxml"));
        
  	   Scene scene = sport.getScene();
         root.translateYProperty().set(scene.getHeight());

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
    void progres(ActionEvent event) throws IOException {
    	Parent root =FXMLLoader.load(getClass().getResource("Progres.fxml"));
        
  	   Scene scene = sport.getScene();
         root.translateYProperty().set(scene.getHeight());

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

    //educatiton
    @FXML
    void ed(ActionEvent event) throws IOException {
    	Parent root =FXMLLoader.load(getClass().getResource("Educative.fxml"));
        
  	   Scene scene = sport.getScene();
         root.translateYProperty().set(scene.getHeight());

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

    //PointsPositifs
    @FXML
    void pp(ActionEvent event) throws IOException {
    	Parent root =FXMLLoader.load(getClass().getResource("PointPos.fxml"));
        
 	   Scene scene = sport.getScene();
        root.translateYProperty().set(scene.getHeight());

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
    void appris(ActionEvent event) throws IOException {
    	Parent root =FXMLLoader.load(getClass().getResource("InfoApprises.fxml"));
        
  	   Scene scene = sport.getScene();
         root.translateYProperty().set(scene.getHeight());

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
    void signout(ActionEvent event) throws IOException {
    
    	Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
        
   	   Scene scene = new Scene(root);
   	   Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
   	  window.setScene(scene);
   	   window.show();
		
    }
    
    
    
    @FXML
    void addtask(ActionEvent event) throws IOException 	{
		try {
			
		
			
			
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			//pour ouvrir la fenetre 
			Pane root =  loader.load(getClass().getResource("AddTAsk.fxml").openStream());
			
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//css file
			
		
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
				
			}
	
    
    
}

