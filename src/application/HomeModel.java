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
    
    
 //-------------------------------------------Textfield  challengeDay-----------------------------------------
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
    
    
 //-------------------------------------------Label nbr coins-----------------------------------------
    
    public static String getConsulteRubrique (int idfRub, int idfDate) {
		String sql= "select * from ConsulteRubrique where idfRub ="+idfRub+" and idfDate="+idfDate;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			if (rs.next())
					return rs.getString("idfRub");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getConsulteRubrique");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getConsulteRubrique");
			e.printStackTrace();
		}
		
		return null;
	}
    
    public static void setConsulteRubrique (int idfRub, int idfDate) {

    	String sql ="insert into ConsulteRubrique(idfRub,idfDate) values('"+idfRub+"' ,'"+idfDate+"')" ;
       
        try {
			DbConnection.dbExcecuteQuery(sql);
        } catch (ClassNotFoundException e) {
    		System.out.println("Vous avez un probleme avec la classe HomeModel methode setConsulteRubrique");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		System.out.println("Vous avez un probleme avec la classe HomeModel methode setConsulteRubrique");
    		e.printStackTrace();
    	}

        
	}
    
    
    public static int getNbrCoinsActuel (int idfDate) {
		
    	int nbrCoinsActuel=100; //initialises a 100 psk le simple fait de se connecter a l'application lui offre 10 coins
    	int nbrCoinsPourChaqueConsultationDeRub=200;
    	int nbrRubConsultes=0;
    	
    	String sql= "select * from ConsulteRubrique where idfDate ="+idfDate;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			while (rs.next())
				nbrRubConsultes++;
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getConsulteRubrique");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getConsulteRubrique");
			e.printStackTrace();
		}
		
		nbrCoinsActuel=nbrCoinsActuel+nbrCoinsPourChaqueConsultationDeRub*nbrRubConsultes;
		
		return nbrCoinsActuel;
	}
    
//-------------------------------------------Tasks----------------------------------------- 
    
    //ajouter un task a la bdd
    public static void setOneTask (int idfDate,int numSeq, String task) {

    	String sql ="insert into Tasks(idfDate,numSeq,task) values('"+idfDate+"' ,'"+numSeq+"','"+task+"')" ;
       
        try {
			DbConnection.dbExcecuteQuery(sql);
        } catch (ClassNotFoundException e) {
    		System.out.println("Vous avez un probleme avec la classe HomeModel methode setOneTask");
    		e.printStackTrace();
    	} catch (SQLException e) {
    		System.out.println("Vous avez un probleme avec la classe HomeModel methode setOneTask");
    		e.printStackTrace();
    	}

        
	}
    
    
    //compter le nbr de tasks ajouter
    public static int getNbrTasksAjouter (int idfDate) {
		
    	int numSeq=0;
    	
    	String sql= "select numSeq from Tasks where idfDate ="+idfDate;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			while (rs.next())
				numSeq= Integer.valueOf(rs.getString("numSeq"));
			
			return numSeq;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getNbrTasksAjouter");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe HomeModel methode getNbrTasksAjouter");
			e.printStackTrace();
		}
		
		return -1;//erreur
    }
    
   
}

