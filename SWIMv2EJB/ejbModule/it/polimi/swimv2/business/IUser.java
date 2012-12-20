package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.User;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface IUser {

	void saveUser(User user);
    
    User findUser(User user);
    
    List<User> retrieveAllUsers();
    
    User findUserByLogin(User user);
}
