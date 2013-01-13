package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "JobRequest")
public class JobRequest implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private int idPerformer;
	private int idRequestor;
	private int idAbility;
	private String place;
	private String date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPerformer() {
		return idPerformer;
	}
	public void setIdPerformer(int idPerformer) {
		this.idPerformer = idPerformer;
	}
	public int getIdRequestor() {
		return idRequestor;
	}
	public void setIdRequestor(int idRequestor) {
		this.idRequestor = idRequestor;
	}
	public int getIdAbility() {
		return idAbility;
	}
	public void setIdAbility(int idAbility) {
		this.idAbility = idAbility;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
