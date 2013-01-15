package it.polimi.swimv2.business;


import it.polimi.swimv2.entities.User;

import java.util.List;

import javax.ejb.Remote;

//Interface for UserBean Session Bean
@Remote
public interface IUser {

	void save(User user);
    
    User findUserByLogin(String email);

	List<User> findUserByName(String name);
	
	List<User> findUserByPlace(String place);

	User findUserById(int id);
	
	void remove(int id);

	
}
