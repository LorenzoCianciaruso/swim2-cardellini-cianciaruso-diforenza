package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.FriendshipRequest;

import javax.ejb.Remote;

@Remote
public interface IFriendshipRequest {

	void save(FriendshipRequest friendshipRequest);

	List<FriendshipRequest> findFriendshipRequestByPerformer(int currentUserId);

	List<FriendshipRequest> findFriendshipRequestByRequestor(int currentUserId);

	void remove(int id);

	FriendshipRequest findFriendshipRequestById(int id);

}
