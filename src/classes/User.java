package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import DbUtil.DbConnection;

public class User {
	
	private String FullName;
	private String Password;
	private String  Email;
	private String   SessionSkill;
	
	public User(String fullName, String password, String email, String sessionSkill) {
		FullName = fullName;
		Password = password;
		Email = email;
		SessionSkill = sessionSkill;
	}
	
	
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSessionSkill() {
		return SessionSkill;
	}
	public void setSessionSkill(String sessionSkill) {
		SessionSkill = sessionSkill;
	}
	
	public void AjouterInformations(int idfU,String fullName,String email,String mdp,Date dateDeb,String skill) {
		DbConnection db = new DbConnection();
		String query="INSERT INTO User (idfU,fullName, email , mdp , dateDeb, skill) VALUES (?, ?   ,?   ,?  ,?   , ?)";
		   try (PreparedStatement pr = this.connection.prepareStatement(query)) {
	            pr.setLong(1, idfU);
	            pr.setString(2, fullName);
	            pr.setString(3, email);
	            pr.setString(4, mdp);
	            pr.setDate(5, (java.sql.Date) dateDeb);
	    
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


}
