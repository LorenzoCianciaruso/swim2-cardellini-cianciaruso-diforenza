package it.polimi.swimv2.businesslogic;

import it.polimi.swimv2.business.IFriendshipRequest;
import it.polimi.swimv2.entities.FriendshipRequest;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
