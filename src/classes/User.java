package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	public User() {
		// TODO Auto-generated constructor stub
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
	
	 //****=============FONCTION QUI PERMET DE NOUS CONNECTER A LA BDD===========
    Connection connection;



    public boolean isDataBaseConnected() {
        try {

            this.connection= DbConnection.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.connection != null;
    }
    
    //****=============FONCTION QUI PERMET DE MODIFIER UN USER DANS LA BDD===========
    public void ModifierUSR(String fullName, String Oldmail,String Email, String mdp, String skill) {

        String query ="UPDATE USER SET fullName = ?, email = ? , mdp = ?,skill  =? WHERE email = ? ";

        
        try (PreparedStatement pr = this.connection.prepareStatement(query)) {
            pr.setString(1,  fullName);
            //Nouveau email
            pr.setString(2, Email);
            pr.setString(3, mdp);
            pr.setString(4, skill);
            pr.setString(5, Oldmail);
            
       
            
            pr.executeUpdate();
            //les seuls valeurs a modifier dans un RDV sont la date et l'heure
        } catch (SQLException e) {
            System.out.println("Vous avez un probleme dans la classe User Modifier User");
        }

    }



 

}
