package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.Entity;


@Entity(name = "RegisteredUser") 
public class RegisteredUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public RegisteredUser(){};
	
	@Id
	private int idRegisteredUser;
	private String name;
	private String surname;
	private String city;
	private String birthday;
	private String phone;

	public int getIdRegisteredUser() {
		return idRegisteredUser;
	}
	public void setIdRegisteredUser(int idRegisteredUser) {
		this.idRegisteredUser = idRegisteredUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
