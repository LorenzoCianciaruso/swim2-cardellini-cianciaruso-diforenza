package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "AbilitiesDeclared")
public class AbilitiesDeclared implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private User user;
	@Id
	private Ability ability;
	private int feedback;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getIdAbility() {
		return idAbility;
	}
	public void setIdAbility(int idAbility) {
		this.idAbility = idAbility;
	}
	public int getFeedback() {
		return feedback;
	}
	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}
	
	
}
