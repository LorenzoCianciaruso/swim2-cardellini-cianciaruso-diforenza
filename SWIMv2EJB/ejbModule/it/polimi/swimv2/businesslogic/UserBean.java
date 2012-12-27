package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.entities.Admin;
import it.polimi.swimv2.entities.User;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless(mappedName="UserBean")
@Remote(IUser.class)
public class UserBean implements IUser {
	@PersistenceContext(unitName = "SWIMv2DB")
    private EntityManager entityManager;

    public UserBean() {}

	//save user in the database
    @Override
	public void saveUser(User user) {
		entityManager.persist(user);
	}

	//select user by email and password (login info)
    @Override
	public User findUserByLogin(User user) {

		//SELECT * FROM User WHERE email = 'email' and password = 'password'
		String q = "SELECT u FROM User u WHERE email = '"+user.getEmail()+"' and password = '"+user.getPassword()+"'";
		Query query = entityManager.createQuery(q);
		try{
			User u = (User) query.getSingleResult();
			return u;
		}catch (NoResultException e) {
			return null;
		}
	}

    //select user passing an user with the name to search
	@Override
	public List<User> findUserByName(User userToSearch) {
		String q = "SELECT u FROM User u WHERE name = '"+userToSearch.getName()+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<User> listOfUsersFound = (List<User>) query.getResultList();
			return listOfUsersFound;
		}catch (NoResultException e){
			return null;
		}
	}

	//select user by passing an user with id to search
	@Override
	public User findUserById(User user) {

		String q = "SELECT u FROM User u WHERE id = '"+user.getIdUser()+"'";
		Query query = entityManager.createQuery(q);
		try{
			User u = (User) query.getSingleResult();
			return u;
		}catch (NoResultException e){
			return null;
		}
	}


}
