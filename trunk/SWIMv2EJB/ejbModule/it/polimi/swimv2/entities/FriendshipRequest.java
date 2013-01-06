package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity (name = "FriendshipRequest")
public class FriendshipRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private int sender;
	private int receiver;
	
	
	public int getSender() {
		return sender;
	}
	public void setSender(int user1) {
		this.sender = user1;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int user2) {
		this.receiver = user2;
	}
	
	

}
