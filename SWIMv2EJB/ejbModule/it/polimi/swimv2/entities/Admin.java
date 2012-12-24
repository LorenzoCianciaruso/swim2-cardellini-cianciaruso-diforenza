package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "User")
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Admin(){}
	
	//attributes
	@Id
	private String email;
	private String password;
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
