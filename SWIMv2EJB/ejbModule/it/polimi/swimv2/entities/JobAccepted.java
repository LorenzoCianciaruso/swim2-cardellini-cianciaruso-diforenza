package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "JobAccepted")
public class JobAccepted implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private JobRequest job;
	private int feedback;
	private String comment;
	
	
	public JobRequest getJob() {
		return job;
	}
	public void setJob(JobRequest job) {
		this.job = job;
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
	


	
}
