package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DbUtil.DbConnection;

public class RubriqueEcrite extends Rubrique{
	protected String contenuRub;

	public RubriqueEcrite(String contenuRub) {
		this.contenuRub = contenuRub;
	}

	public RubriqueEcrite() {
	}

	public String getContenuRub() {
		return contenuRub;
	}

	public void setContenuRub(String contenuRub) {
		this.contenuRub = contenuRub;
	}
	

public boolean Inseretion() {
	return true;
}
		    
}
