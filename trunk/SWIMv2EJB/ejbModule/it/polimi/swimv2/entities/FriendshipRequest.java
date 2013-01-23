package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity (name = "FriendshipRequest")
public class FriendshipRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	private int idSender;
	private int idReceiver;
	private int direction;
	
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSender() {
		return idSender;
	}
	public void setSender(int user1) {
		this.idSender = user1;
	}
	public int getReceiver() {
		return idReceiver;
	}
	public void setReceiver(int user2) {
		this.idReceiver = user2;
	}
	
	

}
