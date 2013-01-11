package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "AbilityDeclared")
public class AbilityDeclared implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private int idUser;
	private int idAbility;
	private int positiveFeedback;
	private int negativeFeedback;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getPositiveFeedback() {
		return positiveFeedback;
	}
	public void setPositiveFeedback(int feedback) {
		this.positiveFeedback = feedback;
	}
	public int getNegativeFeedback() {
		return negativeFeedback;
	}
	public void setNegativeFeedback(int feedback) {
		this.negativeFeedback = feedback;
	}
	
	
}
