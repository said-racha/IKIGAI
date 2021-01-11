package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import DbUtil.DbConnection;

public class Inscription {
	int idfU;
	String fullName;
	String email;
	String mdp;
	Date dateDeb;
	String skill;
	
	//=======================================AJOUTER USER============================*/
		public void AjouterInformations(int idfU,String fullName,String email,String mdp,String mdpConf,String dateDeb,String skill) {
			DbConnection db = new DbConnection();
			String query="INSERT INTO User (idfU,fullName, email , mdp , dateDeb, skill) VALUES (?, ?   ,?   ,?  ,?   , ?)";
			   try (PreparedStatement pr = this.connection.prepareStatement(query)) {
		            pr.setLong(1, idfU);
		            pr.setString(2, fullName);
		            pr.setString(3, email);
		            pr.setString(4, mdp);
		            pr.setString(5, dateDeb);
		    
		            pr.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println("Vous avez un probleme dans la classe user ajouter user");
		        }
		}
		//Methode Permettant de modifier les informations
		public void ModiferInformations(String sessionSkill) {
			
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
