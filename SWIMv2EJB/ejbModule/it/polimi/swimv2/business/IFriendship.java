package it.polimi.swimv2.business;

import java.util.List;
import it.polimi.swimv2.entities.Friendship;

import javax.ejb.Remote;

@Remote
public interface IFriendship {

	void saveFriendship(Friendship f);

	List<Friendship> findAllFriendshipsByUserId(int currentUserId);

	void remove(int id);

	boolean isFriend(int currentUserId, int id);

}
