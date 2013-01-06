package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.Entity;

@Entity ( name = "NewAbility")
public class AbilityRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idNewAbility;
	private int idUser;
	private String name;
	
	
	public int getIdNewAbility() {
		return idNewAbility;
	}
	public void setIdNewAbility(int idNewAbility) {
		this.idNewAbility = idNewAbility;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int user) {
		this.idUser = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
