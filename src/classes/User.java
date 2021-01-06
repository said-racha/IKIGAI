package classes;

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
	//Methode Permettant de modifier les informations
	public void ModiferInformations(String sessionSkill) {
		
	}


}
