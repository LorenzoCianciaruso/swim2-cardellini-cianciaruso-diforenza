package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.FriendshipRequest;

import javax.ejb.Remote;

@Remote
public interface IFriendshipRequest {

	void save(FriendshipRequest friendshipRequest);

}
