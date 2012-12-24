package it.polimi.swimv2.entities;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.Entity;


@Entity(name = "RegisteredUser") 
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public User(){};
	
	@Id
	private int id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String city;
	private String birthday;
	private String phone;

	public int getId() {
		return id;
	}
	public void setId(int idRegisteredUser) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
