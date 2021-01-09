package application;

import java.sql.Connection;
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
	
	
	
}
