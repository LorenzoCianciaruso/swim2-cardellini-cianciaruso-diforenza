package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "Ability")
public class Ability implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idAbility;
	private String name;
	
	public int getIdAbility() {
		return idAbility;
	}
	public void setIdAbility(int idAbility) {
		this.idAbility = idAbility;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
