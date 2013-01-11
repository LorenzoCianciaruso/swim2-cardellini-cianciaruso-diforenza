package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.Entity;

@Entity ( name = "AbilityRequest")
public class AbilityRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private int idUser;
	private String name;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
