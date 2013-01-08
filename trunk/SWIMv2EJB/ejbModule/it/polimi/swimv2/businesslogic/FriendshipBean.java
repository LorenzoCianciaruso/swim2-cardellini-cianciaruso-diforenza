package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.entities.Friendship;
import it.polimi.swimv2.entities.Job;

import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName="FriendshipBean")
@Remote(IFriendship.class)
public class FriendshipBean implements IFriendship {

	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;

    public FriendshipBean() {}
    
    @Override
	public void saveFriendship(Friendship f) {
		entityManager.persist(f);
	}

	@Override
	public List<Friendship> findAllFriendshipsByUserId(int currentUserId) {

		String q = "SELECT f FROM Friendship f WHERE idUser1 = '"+currentUserId+"' or idUser2 = '"+currentUserId+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<Friendship> fList = (List<Friendship>) query.getResultList();
			return fList;
		}catch (NoResultException e) {
			return null;
		}
	}

}
