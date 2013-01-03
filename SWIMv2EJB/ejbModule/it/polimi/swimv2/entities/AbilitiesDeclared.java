package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "AbilitiesDeclared")
public class AbilitiesDeclared implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idUser;
	private int idAbility;
	private int feedback;
	
	
	public int getUser() {
		return idUser;
	}
	public void setUser(int user) {
		this.idUser = user;
	}
	public int getAbility() {
		return idAbility;
	}
	public void setAbility(int idAbility) {
		this.idAbility = idAbility;
	}
	public int getFeedback() {
		return feedback;
	}
	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}
	
	
}
