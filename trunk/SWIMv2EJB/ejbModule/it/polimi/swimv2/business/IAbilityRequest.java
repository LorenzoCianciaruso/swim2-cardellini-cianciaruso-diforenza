package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.AbilityRequest;

public interface IAbilityRequest {
	
	List<AbilityRequest> findAllNewAbilities();

	void save(AbilityRequest newAbility);

	void remove(AbilityRequest newAbility);
}