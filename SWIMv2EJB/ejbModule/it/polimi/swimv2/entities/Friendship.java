package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity (name = "Friendship")
public class Friendship implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	//non so come si metta una chiave primaria multipla, questa chiave dovrebbe comprendere entrambi gli utenti registrati
	
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
