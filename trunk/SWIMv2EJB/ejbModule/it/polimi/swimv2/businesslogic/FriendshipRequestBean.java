package it.polimi.swimv2.businesslogic;

import java.util.List;

import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.entities.FriendshipRequest;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName="FriendshipRequestBean")
@Remote(IFriendshipRequest.class)
public class FriendshipRequestBean implements IFriendshipRequest {

	@PersistenceContext(unitName = "sql21573")
    private EntityManager entityManager;

    public FriendshipRequestBean() {}

	@Override
	public void save(FriendshipRequest friendshipRequest) {
		entityManager.persist(friendshipRequest);
	}

	@Override
	public List<FriendshipRequest> findByPerformerId(int currentUserId) {
		String q = "SELECT f FROM FriendshipRequest f WHERE idReceiver = '"+currentUserId+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<FriendshipRequest> list = (List<FriendshipRequest>) query.getResultList();
			return list;
		}catch (NoResultException e){
			return null;
		}
	}

	@Override
	public List<FriendshipRequest> findByRequestorId(int currentUserId) {
		String q = "SELECT f FROM FriendshipRequest f WHERE idSender = '"+currentUserId+"'";
		Query query = entityManager.createQuery(q);
		try{
			List<FriendshipRequest> list = (List<FriendshipRequest>) query.getResultList();
			return list;
		}catch (NoResultException e){
			return null;
		}
	}
	
	
	@Override
	public void remove(int id){		
		String q = "SELECT f FROM FriendshipRequest f WHERE id = '"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			FriendshipRequest jobR = (FriendshipRequest) query.getSingleResult();
			entityManager.remove(jobR);
		}catch(NoResultException e){
				;
		}
		
	}
	
	
	@Override
	public FriendshipRequest findById(int id) {
    	String q = "SELECT f FROM FriendshipRequest f WHERE id = '"+id+"'";
		Query query = entityManager.createQuery(q);
		try{
			FriendshipRequest f = (FriendshipRequest) query.getSingleResult();
			return f;
		}catch (NoResultException e) {
			return null;
		}
	}

}
