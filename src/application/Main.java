package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		//Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
		//Parent root2 =FXMLLoader.load(getClass().getResource("Inscription.fxml"));
		//Parent root3 =FXMLLoader.load(getClass().getResource("ActiviteesDuJour.fxml"));
		//Parent root4 =FXMLLoader.load(getClass().getResource("ConsulterDevPerso.fxml"));
		Parent root5 =FXMLLoader.load(getClass().getResource("InfoApprises.fxml"));
		
		//Scene scene = new Scene(root);
		//Scene scene = new Scene(root2);
		//Scene scene = new Scene(root3);
		//Scene scene = new Scene(root4);
		Scene scene = new Scene(root5);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
