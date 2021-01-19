package classes;

public class Rubrique {
 
	protected int IdRubrique;
	protected int nbrJour;
	
	public Rubrique() {
		IdRubrique=0;
		nbrJour=0;
	}

	public int getIdRubrique() {
		return IdRubrique;
	}

	public void setIdRubrique(int idRubrique) {
		IdRubrique = idRubrique;
	}

	public int getNbrJour() {
		return nbrJour;
	}

	public void setNbrJour(int nbrJour) {
		this.nbrJour = nbrJour;
	}
	
	
	
}
