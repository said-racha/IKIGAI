package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtil.DbConnection;

public class DevPerso extends RubriqueAfficher{
	
	public DevPerso() {
		super();
	}

	public static String getContenuChallenge (int nbrJour) {
		String sql= "select * from RubriqueChallenge where nbrJour ="+nbrJour;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			if (rs.next())
					return rs.getString("contenuRub");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec la classe DevPerso methode getContenuChallenge");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe DevPerso methode getContenuChallenge");
			e.printStackTrace();
		}
		
		return "";
	}
	
}
