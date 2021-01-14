package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtil.DbConnection;

public class Educative extends RubriqueAfficher  {
	
	
	public Educative() {
		super();
	}
	
	public static String getContenuEducatif(int nbrJour) {
		String sql= "select * from RubriqueEducative where nbrJour ="+nbrJour;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			if (rs.next())
					return rs.getString("contenuRub");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec la classe Educative methode getContenuEducatif");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe Educative methode getContenuEducatif");
			e.printStackTrace();
		}
		
		return "";
	}

}
