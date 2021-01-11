package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import DbUtil.DbConnection;

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
	
	
	public User() {
		// TODO Auto-generated constructor stub
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
	

}
