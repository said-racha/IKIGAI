package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

import DbUtil.DbConnection;

public class Sport extends RubriqueAfficher{
	
	private int nbJours;
	private String theme;
	private String programme;
	
	public Sport() {
		nbJours=0;
		theme="";
		programme="";
	}

	public int getNbJours() {
		return nbJours;
	}

	public void setNbJours(int nbJours) {
		this.nbJours = nbJours;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}
	
	
	//retourne le programme du jour dans la bdd selon le nbrJour de l'utilisateur
	public static String getProgrammeDuJour(int nbrJour) {
		String sql= "select * from RubriqueSport where nbrJour ="+nbrJour;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			if (rs.next())
					return rs.getString("programmeDuJour");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec la classe Sport methode getProgrammeDuJour");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe Sport methode getProgrammeDuJour");
			e.printStackTrace();
		}
		
		return "";
	}
	
	//retourne le theme du jour dans la bdd selon le nbrJour de l'utilisateur
	public static String getThemeDuJour(int nbrJour) {
		String sql= "select * from RubriqueSport where nbrJour ="+nbrJour;
		
		try {
			
			ResultSet rs= DbConnection.dbExecute(sql);
			
			if (rs.next())
					return rs.getString("theme");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Vous avez un probleme avec la classe Sport methode getThemeDuJour");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Vous avez un probleme avec la classe Sport methode getThemeDuJour");
			e.printStackTrace();
		}
		
		return "";
	}
	

}
