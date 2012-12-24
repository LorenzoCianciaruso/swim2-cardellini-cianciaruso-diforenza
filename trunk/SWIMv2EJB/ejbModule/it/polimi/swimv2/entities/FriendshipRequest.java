package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity (name = "FriendshipRequest")
public class FriendshipRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private RegisteredUser user1;
	@Id
	private RegisteredUser user2;
	
	
	public RegisteredUser getUser1() {
		return user1;
	}
	public void setUser1(RegisteredUser user1) {
		this.user1 = user1;
	}
	public RegisteredUser getUser2() {
		return user2;
	}
	public void setUser2(RegisteredUser user2) {
		this.user2 = user2;
	}
	
	

}
