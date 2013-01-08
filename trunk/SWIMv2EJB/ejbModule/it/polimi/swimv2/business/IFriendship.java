package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.Friendship;

import javax.ejb.Remote;

@Remote
public interface IFriendship {

	void saveFriendship(Friendship f);

}
