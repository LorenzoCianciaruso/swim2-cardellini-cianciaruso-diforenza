package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IUser;
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

	//find user that correspond to the id of given user
    @Override
	public User findUser(User user) {

		User u = entityManager.find(User.class, user.getId());
		return u;
	}

	//get all users
    @Override
	public List<User> retrieveAllUsers() {
		
		String q = "SELECT u from " + User.class.getName() + " u";
        Query query = entityManager.createQuery(q);
        List<User> usersList = query.getResultList();
        return usersList;
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


}
