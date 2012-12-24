package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.Entity;

@Entity ( name = "NewAbility")
public class NewAbility implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idNewAbilty;
	@Id
	private RegisteredUser user;
	private String name;
	
	
	public int getIdNewAbilty() {
		return idNewAbilty;
	}
	public void setIdNewAbilty(int idNewAbilty) {
		this.idNewAbilty = idNewAbilty;
	}
	public RegisteredUser getUser() {
		return user;
	}
	public void setUser(RegisteredUser user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
