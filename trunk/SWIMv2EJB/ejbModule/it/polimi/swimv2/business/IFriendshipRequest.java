package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.FriendshipRequest;

import javax.ejb.Remote;

@Remote
public interface IFriendshipRequest {

	void save(FriendshipRequest friendshipRequest);
	
	FriendshipRequest findById(int id);

	List<FriendshipRequest> findByPerformerId(int id);

	List<FriendshipRequest> findByRequestorId(int id);

	void remove(int id);

}
