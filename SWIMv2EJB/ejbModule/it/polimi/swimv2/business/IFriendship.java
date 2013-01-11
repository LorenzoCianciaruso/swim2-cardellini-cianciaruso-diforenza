package it.polimi.swimv2.business;

import java.util.List;
import it.polimi.swimv2.entities.Friendship;

import javax.ejb.Remote;

@Remote
public interface IFriendship {

	void save(Friendship f);

	List<Friendship> findByUserId(int id);

	boolean isFriend(int currentUserId, int id);
	
	void remove(int id);

}
