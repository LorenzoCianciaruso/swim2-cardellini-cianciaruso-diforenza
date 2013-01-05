package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.Ability;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IAbility {

	List<Ability> findAllAbilities();
	
	void deleteAbility(Ability ab);

	Ability findById(Ability a);

	Ability findByName(String name);

}
