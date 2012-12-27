package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity (name = "FriendshipRequest")
public class FriendshipRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idUser1;
	@Id
	private int idUser2;
	
	
	public int getidUser1() {
		return idUser1;
	}
	public void setidUser1(int user1) {
		this.idUser1 = user1;
	}
	public int getidUser2() {
		return idUser2;
	}
	public void setidUser2(int user2) {
		this.idUser2 = user2;
	}
	
	

}
