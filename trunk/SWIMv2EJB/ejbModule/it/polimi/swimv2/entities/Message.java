package it.polimi.swimv2.entities;


import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity(name = "Message") 
public class Message implements Serializable{

private static final long serialVersionUID = 1L;
	
	public Message(){};
	
	@Id
	private int id;
	private int idJob;
	private int idUser;
	private String message;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdJob() {
		return idJob;
	}
	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
