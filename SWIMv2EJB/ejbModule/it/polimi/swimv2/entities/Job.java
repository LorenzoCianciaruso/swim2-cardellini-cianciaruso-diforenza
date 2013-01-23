package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name = "Job")
public class Job implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	private int feedback;
	private String comment;
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
	public int getFeedback() {
		return feedback;
	}
	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
