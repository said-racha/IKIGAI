package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DbUtil.DbConnection;
import classes.Educative;
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
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HomeModel {

    
    public static String getCitationDuJour (int nbrJour) {
		String sql= "select * from CitationDuJour where nbrJour ="+nbrJour;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			if (rs.next())
					return rs.getString("citation");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec l'interface Home methode getCitationDuJour");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec l'interface Home methode getCitationDuJour");
			e.printStackTrace();
		}
		
		return "";
	}
    
   
}

