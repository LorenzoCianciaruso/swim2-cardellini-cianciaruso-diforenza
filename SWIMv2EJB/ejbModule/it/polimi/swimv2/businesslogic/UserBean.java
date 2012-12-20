package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class UserBean implements IUser {
	@PersistenceContext(unitName = "SWIMv2DB")
    private EntityManager entityManager;

    public UserBean() {}

	@Override
	public void saveUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User findUser(User user) {

		User u = entityManager.find(User.class, user.getId());
		return u;
	}

	@Override
	public List<User> retrieveAllUsers() {
		
		String q = "SELECT u from " + User.class.getName() + " u";
        Query query = entityManager.createQuery(q);
        List<User> usersList = query.getResultList();
        return usersList;
	}

	@Override
	public User findUserByLogin(User user) {
		
		User u1 = entityManager.find(User.class, user.getEmail());
		User u2 = entityManager.find(User.class, user.getPassword());
		if(u1.equals(u2)){
			return u1;
		}
		return null;
	}

}
