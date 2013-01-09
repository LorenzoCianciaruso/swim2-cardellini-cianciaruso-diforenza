package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IUser;
import it.polimi.swimv2.entities.AbilitiesDeclared;
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
	
	@PersistenceContext(unitName = "sql21573")
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
	public List<User> findUserByName(String name) {
		String q = "SELECT u FROM User u WHERE name LIKE '"+name+"%' or surname LIKE '"+name+"%'";
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
	public User findUserById(int id) {

		String q = "SELECT u FROM User u WHERE id = '"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			User u = (User) query.getSingleResult();
			return u;
		}catch (NoResultException e){
			return null;
		}
	}
	
	@Override
	public void remove(int id){
		String q = "SELECT u FROM User u WHERE id ='"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			User user = (User) query.getSingleResult();
			entityManager.remove(user);
		}catch(NoResultException e){
			
		}
		
	}


}
