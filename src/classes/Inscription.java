package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import DbUtil.DbConnection;

public class Inscription {
	int idfU;
	String fullName;
	String email;
	String mdp;
	Date dateDeb;
	String skill;
	
	
	
	
	
/*	int Iduser =LC.Currentuser.getIdUser().get();
	int NbrJourU =LC.Currentuser.getNbJour(Iduser);
	
	 
	 //Numero sequentiel pour remplir le idfdate de la base de données
	 numSeq =  PosTable.getItems().size()+1;
	 //Nombre de ligne de la table +1 
	idfU = Integer.parseInt(String.valueOf(Iduser)+ String.valueOf(NbrJourU));  
	//Affecter l'id sa valeure conforme a la codification
	idPoinsPos = Integer.parseInt(String.valueOf(idfDate)+String.valueOf(numSeq));*/
	//=======================================AJOUTER USER============================*/
		public void AjouterInformations(String fullName,String email,String mdp,String mdpConf,String dateDeb,String skill) {
			DbConnection db = new DbConnection();
			String query="INSERT INTO User (idfU,fullName, email , mdp , dateDeb, skill) VALUES (?, ?   ,?   ,?  ,?   , ?)";
			   try (PreparedStatement pr = this.connection.prepareStatement(query)) {
				   int numseq=this.NbUser();
				   numseq++;
				   
				
				
				   
				   idfU =numseq  ;
			
				   pr.setInt(1, idfU);
		            pr.setString(2, fullName);
		            pr.setString(3, email);
		            pr.setString(4, mdp);
		            pr.setString(5, dateDeb);
		    pr.setString(6, skill);
		            pr.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println("Vous avez un probleme dans la classe Inscription/ ajouter user");
		        }
		}
		
		
		public int NbUser() throws SQLException {
			DbConnection db = new DbConnection();
			PreparedStatement pst2=null;
			
			ResultSet rst2=null;
			
			
  			String query="SELECT COUNT(*)  AS total FROM User";
  			pst2 = connection.prepareStatement(query);
		
			//le id sauto incremente
			rst2 = pst2.executeQuery();
			
			if(rst2!=null) {
				int nbUser= rst2.getInt("total");
				return nbUser;
			}else {
				return 0;
			}
		}
		  //=======================================AJOUTER CONNEXION USER============================*/
  		public void AjouterCoinsInit() {
  			DbConnection db = new DbConnection();
  			String query="INSERT INTO DateCoins (idfDate ,nbrCoinsJour,idfU,nbrJour ) VALUES (?, ?   ,?,? )";
  			   try (PreparedStatement pr = this.connection.prepareStatement(query)) {
  		        
  			    int	idfDate = Integer.parseInt(String.valueOf(idfU)+ String.valueOf(0));  

  			  pr.setInt(1, idfDate );
  				   //valeure intial des coins
  			 pr.setInt(2, 30);  
  		    pr.setInt(3,idfU);
  		    //car c'est le premir jour
  		        pr.setInt(4, 0);
  		
  		            pr.executeUpdate();
  		        } catch (SQLException e) {
  		            System.out.println("Vous avez un probleme dans la classe User/  AjouterConnexion");
  		        }
  		}

		
	//pour voir si il est connecter a la dbb
	    Connection connection;
		

	    public boolean isDataBaseConnected() {
	        try {

	            this.connection= DbConnection.getConnection();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return this.connection != null;
	    }

	    
	  //=======================================CHERCHER LE USER DANS LA TABLE USER ============================*/
	    public int chercherUser(String email) throws  Exception{
	        PreparedStatement pr=null;
	        ResultSet rs=null;

	        String sql="select * from User where email = ?";//On utilise le numero de telephone du patient car c'est la seul donnée de la table qui est obligatoirement unique

	        try{
	            pr=this.connection.prepareStatement(sql);
	            pr.setString(1,email);

	            rs = pr.executeQuery();


	            if (rs.next()){
//si il existe on retourne 1
	            return 1;
	            }
	            else{

	                return 0;// sinon on retourne 0
	            }
	        }catch (SQLException e)
	        {

	            System.out.println("Vous avez un probleme dans la classe Inscription methode chercher user");
	            return 0;
	        }
	        finally {
	            assert pr != null;
	            pr.close();
	            assert rs!= null;
	            rs.close();
	        }

	    }


}
