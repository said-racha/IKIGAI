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
		Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
			
		System.out.println("Balkis");
	System.out.println("2 nouveau sys out balkis");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
