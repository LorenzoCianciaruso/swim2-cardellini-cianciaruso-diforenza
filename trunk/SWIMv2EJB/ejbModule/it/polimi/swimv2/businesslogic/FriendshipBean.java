package it.polimi.swimv2.businesslogic;

import it.polimi.swimv2.business.IFriendship;
import it.polimi.swimv2.entities.Friendship;

import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
