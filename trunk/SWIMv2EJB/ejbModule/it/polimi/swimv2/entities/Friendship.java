package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity (name = "Friendship")
public class Friendship implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private int id;
	private int idUser1;
	private int idUser2;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser1() {
		return idUser1;
	}
	public void setUser1(int user1) {
		this.idUser1 = user1;
	}
	public int getUser2() {
		return idUser2;
	}
	public void setUser2(int user2) {
		this.idUser2 = user2;
	}
	
	

}
