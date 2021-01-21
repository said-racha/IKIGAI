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
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getCitationDuJour");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getCitationDuJour");
			e.printStackTrace();
		}
		
		return "";
	}
    
    
    
    public static String getChallengeDay (int idfU, int nbrJour) {
		String sql= "select * from Session where nbrJour ="+nbrJour+" and idfU="+idfU;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			if (rs.next())
					return rs.getString("challengeJ");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getChallengeDay");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getChallengeDay");
			e.printStackTrace();
		}
		
		return "";
	}
    
    
    public static void setChallengeDay (int idfU, int nbrJour, String challengeJ) {

    	String sql ="insert into Session(idfU,nbrJour,challengeJ) values('"+idfU+"' ,'"+nbrJour+"','"+challengeJ+"')" ;
       
        try {
			DbConnection.dbExcecuteQuery(sql);
        } catch (ClassNotFoundException e) {
    		System.out.println("Vous avez un probleme avec la classe HomeModel methode setChallengeDay");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		System.out.println("Vous avez un probleme avec la classe HomeModel methode setChallengeDay");
    		e.printStackTrace();
    	}

        
	}
    
    public static boolean challengeJIsEditable (int idfU, int nbrJour, String challengeJ) {

    	
    	if (HomeModel.getChallengeDay(idfU, nbrJour).equals(""))//pour eviter qu'il n'ait a reecrire son challenge a chaque fois
	        return true;
	    else
	        return false;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
   
}

