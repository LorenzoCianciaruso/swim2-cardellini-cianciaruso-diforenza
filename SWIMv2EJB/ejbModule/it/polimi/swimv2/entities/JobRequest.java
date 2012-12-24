package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "JobRequest")
public class JobRequest implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	private int idJobRequest;
	private User performer;
	private User requestor;
	private Ability ability;
	private String place;
	private String date;
	
	
	public int getIdJob() {
		return idJobRequest;
	}
	public void setIdJob(int idJob) {
		this.idJobRequest = idJob;
	}
	public User getPerformer() {
		return performer;
	}
	public void setPerformer(User performer) {
		this.performer = performer;
	}
	public User getRequestor() {
		return requestor;
	}
	public void setRequestor(User requestor) {
		this.requestor = requestor;
	}
	public Ability getAbility() {
		return ability;
	}
	public void setAbility(Ability ability) {
		this.ability = ability;
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
