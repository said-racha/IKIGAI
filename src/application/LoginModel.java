package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtil.DbConnection;

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
	
	//Methode qui nous permet de savoir si la connexionest russie ou pas
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
	
	String query="select * from User where email = ? and mdp = ?";
	
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
	
	
}
