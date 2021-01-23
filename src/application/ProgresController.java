package application;



import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ProgresController implements Initializable {
	
		
	

		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
		
			
	
	
		
		
		
		
		}
		
	
	
	
	
	
	
 		@FXML private CategoryAxis xAxis    = new CategoryAxis();
  	    @FXML private  NumberAxis yAxis = new NumberAxis();
  	    @FXML private  BarChart<String, Number>  barChart = new BarChart<String, Number> (xAxis, yAxis);
  	  @FXML private Button ChargerStat;
  	    
	
	@FXML
	    private Button home;

	    @FXML
	    void home(ActionEvent event) throws IOException {
	 
	    
	    	
	    		Parent root =FXMLLoader.load(getClass().getResource("Home.fxml"));

      
	  	   Scene scene = home.getScene();
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
	    

		
	 LoginModel Model  = new LoginModel();
	LoginController lc = new LoginController();
	  		public void   ChargerProgres(ActionEvent event) throws Exception{
	  			XYChart.Series series = new XYChart.Series<Number,Number>();
	  		
	  				series.setName("This is your progress !");
	  				try {
	  					
	  				
	  					if(lc.Currentuser.isDataBaseConnected()) {
	  						lc.Currentuser = Model.getInfoUser(LoginController.email, LoginController.password,  lc.Currentuser);
	  			  			//Ceci nous permet d'avoir les informations de l'utilisateur courrant
	  			  			
	  					if(lc.Currentuser. ProgresUser(series, barChart,lc.Currentuser.getIdUser().getValue().intValue())) {
	  						
	  						
	  						//Pour povoir le cliquer qu'une seule fois
	  						ChargerStat.setDisable(true);
	  					} }else {
	  						System.out.println("Il ya un probeleme dans ProgresController/ChargerProgres/Apel Progres User");
	  					}
	  				
	  					
	  				} 
	  				catch (SQLException e) {
	  					System.out.println("Il y'a une erreur dans ProgresController/ChargerStat");
	  					System.err.println(e.getClass()+e.getMessage());
	  				}
	  						
	  						
	  					}
	  			
	  			
	  		
	  		


}
