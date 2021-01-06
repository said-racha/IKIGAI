package classes;

public class Goal {
private String IdGoal;
private char TypeGoal; // S pour semaine J pour Jour
public void DefinirGoal() {
	
}
public Goal(String idGoal, char typeGoal) {
	IdGoal = idGoal;
	TypeGoal = typeGoal;
}
public String getIdGoal() {
	return IdGoal;
}
public void setIdGoal(String idGoal) {
	IdGoal = idGoal;
}
public char getTypeGoal() {
	return TypeGoal;
}
public void setTypeGoal(char typeGoal) {
	TypeGoal = typeGoal;
}

}
