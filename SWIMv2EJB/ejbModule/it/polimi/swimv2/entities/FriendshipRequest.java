package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity (name = "FriendshipRequest")
public class FriendshipRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int sender;
	@Id
	private int receiver;
	
	
	public int getidUser1() {
		return sender;
	}
	public void setidUser1(int user1) {
		this.sender = user1;
	}
	public int getidUser2() {
		return receiver;
	}
	public void setidUser2(int user2) {
		this.receiver = user2;
	}
	
	

}
