package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtil.DbConnection;
import classes.User;


public class LoginModel {

	Connection connection;
	
	//constrcuteur
	public LoginModel() {
		
		try {
			
			this.connection=DbConnection.getConnection();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(this.connection==null)
		{
			System.out.println("Vous avez un probleme avec la classe loginModel");
			System.exit(1);
		}
		
		
	}
	
	
	
	
	
	
	
	public boolean isDataBaseConnected() {
		return this.connection != null;
	}
	
	//Methode qui nous permet d'avoir le nom de l'utilistauer courrant
	public String GetName(String user, String pass) throws SQLException {
		
	PreparedStatement preparedStatement=null;
	
	ResultSet resultSet=null;
	String nom;
	String query="select fullName from User where email = ? and mdp = ?";
	
		try {
		
			preparedStatement = connection.prepareStatement(query);
			//1 ca veux dire user name 
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			//pour executer la requette 
			resultSet = preparedStatement.executeQuery();
		//if it is returning any result or not 
			if(resultSet.next())
			{		
				return resultSet.getString("fullName");
			} 
		
				
				else	{
					return " ";
				}
		
			
		} 
		catch (Exception e)
		{
			System.out.println("Mot de passe ou  nom utilisateur incorrect");
			return "";}
			
		
		
		
		finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	
		}
		
	}
	static String nom;
	//Methode qui nous permet de savoir si la connexionest russie ou pas
	public boolean isLogin(String user, String pass) throws SQLException {
		
	PreparedStatement preparedStatement=null;
	
	ResultSet resultSet=null;
	String password= pass;
	String email = user;
	String query="select * from User where email = ? and mdp = ?";
	
		try {
		
			preparedStatement = connection.prepareStatement(query);
			//1 ca veux dire user name 
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			//pour executer la requette 
			resultSet = preparedStatement.executeQuery();
		
			if(resultSet.next())
			{			
				return true;
			} 		
				else	{
					return false;
				}		
		} 
		catch (Exception e)
		{
			System.out.println("Mot de passe ou  nom utilisateur incorrect");
			return false;}
		
		finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	
		}
		
	}
	
	
//==============Methode qui nous permet d'avoir les informations de l'utilisateur courrant depuis la base de données============================

	public User getInfoUser(String email, String pass,User user) throws SQLException {
	
		
			String sql_M="select * from User  where email = ? and mdp = ?";
		
			PreparedStatement pr_M=null;
			ResultSet rs_M=null;
			String fullName;
			String password;		
			String sessionSkill;
			try {
		          	pr_M=this.connection.prepareStatement(sql_M);
					
					pr_M.setString(1, email);
				
					pr_M.setString(2, pass);
					
					rs_M= pr_M.executeQuery();
			
			if(rs_M!= null) {
			user.setIdUser(rs_M.getInt("idfU"));
			user.setEmail(email);
			user.setFullName(rs_M.getString("fullName"));
			user.setSessionSkill(rs_M.getString("skill"));
			return user;
			} else {
				System.out.println("Vous avez un probleme avec le resultSet   dans la classe LoginModel / getInfoUSer");
			}	
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme dans la classe LoginModel / getInfoUSer");
			
		}
		finally {
			pr_M.close();
			rs_M.close();
		}
		
		
		

		return null;
	}
	
}
