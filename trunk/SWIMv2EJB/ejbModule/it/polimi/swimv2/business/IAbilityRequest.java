package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.AbilityRequest;

public interface IAbilityRequest {
	
	void save(AbilityRequest newAbility);
	
	List<AbilityRequest> allAbilityRequests();

	List<AbilityRequest> findByUserId(int id);
	
	void remove(int id);
}
