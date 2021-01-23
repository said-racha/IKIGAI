package application;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import classes.PointsPositifs;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PointPosController implements Initializable {
	  @FXML  private Button home;
	  @FXML  private AnchorPane container;
	  @FXML  private TableColumn<PointsPositifs, String> PointPositif;
      @FXML  private TableView<PointsPositifs> PosTable;
      @FXML private TextField  PointPositifTextField;
 	 public ObservableList<PointsPositifs>  points = FXCollections.observableArrayList();

      /**
       * Initializes the controller class.
       */
      
      @Override
		public void initialize(URL location, ResourceBundle resources) {
    	//set up the columns in the table
    	  PointPositif.setCellValueFactory(new PropertyValueFactory<PointsPositifs, String>("pointPos"));
      /*==========================================================================================*/
          try {
        	  //Charger les points positifs de ce jour si ils existent
			this.AfficherPointPosCeJour();
			PosTable.setItems(points);
		}
          catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
          
        /*==========================================================================================*/

         //RendreLatableEditable
          PosTable.setEditable(true);
       PointPositif.setCellFactory(TextFieldTableCell.forTableColumn());
       
          
          //This will allow the table to select multiple rows at once
       //   PosTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      }
        
	
      public void  AddPoints(PointsPositifs p)
      { 	
        points.add(p);    
      }
      
      
      
      
      
      //======================================================================================

  
      //Recuperer le user en cours
      LoginController LC = new LoginController();
      int numSeq=0; 
      int idfDate;
  	int  idPoinsPos;
      /*================================Nouveau Points Positif=======================*/
      public void AfficherPointPosCeJour() throws Exception {
    	try {
    		
    	if(LC.Currentuser.isDataBaseConnected()) {
    	int Iduser =LC.Currentuser.getIdUser().get();
    	int NbrJourU =LC.Currentuser.getNbJour(Iduser);
    	
    	 
    	 //Numero sequentiel pour remplir le idfdate de la base de données
    	 numSeq =  PosTable.getItems().size()+1;
    	 //Nombre de ligne de la table +1 
    	idfDate = Integer.parseInt(String.valueOf(Iduser)+ String.valueOf(NbrJourU));  
    	//Affecter l'id sa valeure conforme a la codification
    	idPoinsPos = Integer.parseInt(String.valueOf(idfDate)+String.valueOf(numSeq));
        PointsPositifs PointPos= new PointsPositifs();//Creer l'objet   
    //Si il est connecté a la base de données
        if(PointPos.isDataBaseConnected()) { 	
        	while(PointPos.ChercherPointPositif(idPoinsPos)!=null) {	
          	this.AddPoints(PointPos.ChercherPointPositif(idPoinsPos));
        	numSeq++;
        	idPoinsPos = Integer.parseInt(String.valueOf(idfDate)+String.valueOf(numSeq));
        	System.out.println("Depuis AFFICHER POINTS"+idPoinsPos);	}
        	}}//CUrrent user is deb connected
    	}//try
    	catch (SQLException e)
        {
            System.out.println("Vous avez un probleme dans la classe PointPositifController/NouveauPointPositifBtn");
           
        }  }
 
      
    
      /*================================Nouveau Points Positif=======================*/
      public void NouveauPointPositifBtn(ActionEvent event) throws Exception {
    	try {
    		
    	if(LC.Currentuser.isDataBaseConnected()) {
    	int Iduser =LC.Currentuser.getIdUser().get();
    	int NbrJourU =LC.Currentuser.getNbJour(Iduser);
        PointsPositifs PointPos= new PointsPositifs();//Creer l'objet
        if(PointPos.isDataBaseConnected()) {
        	//Si l'insertion est vraie
    	
        	if( PointPos.Insertion(idPoinsPos, PointPositifTextField.getText())) {	
    		System.out.println("if d'insertion marche");
    		PointPos.setIdfPointsPos(idPoinsPos);
    	    PointPos.setPointPos(PointPositifTextField.getText());
    	//Ajouter a la table
    	   points.add(PointPos);
    	   this.AfficherPointPosCeJour();
    	   PosTable.setItems(points);
    	   
    	    }   
        }//db connected
    	
    	//end else
        	
    	}
    	
    	
    	//CUrrent user is deb connected
    	}//try
    	catch (SQLException e)
        {
            System.out.println("Vous avez un probleme dans la classe PointPositifController/NouveauPointPositifBtn");
           
        }
    	

      
      }
 
      //====================================Rendre la table editable==========================
      /**
       * This method will allow the user to double click on a cell and update
       * the first name of the person
       */
      public void changePointPos(CellEditEvent edittedCell)
      {
          PointsPositifs pointSelected =  PosTable.getSelectionModel().getSelectedItem();
          pointSelected.setPointPos(edittedCell.getNewValue().toString());
      }
      
      
      
      
      
      
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

		

}
