package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.AbilityRequest;

public interface IAbilityRequest {
	
	List<AbilityRequest> findAllAbilityRequests();

	void save(AbilityRequest newAbility);

	void remove(int id);
	
	List<AbilityRequest> findAllAbilityReqByUserId(int id);
}
