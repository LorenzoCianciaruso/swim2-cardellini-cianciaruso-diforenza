package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.User;

import java.util.List;

import javax.ejb.Remote;

//Interface for UserBean Session Bean
@Remote
public interface IUser {

	void saveUser(User user);
    
    User findUserByLogin(User user);

	List<User> findUserByName(User userToSearch);

	User findUserById(User user);
}
