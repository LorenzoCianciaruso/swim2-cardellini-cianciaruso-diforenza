package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.Ability;
import it.polimi.swimv2.entities.User;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IAbility {

	void deleteAbilityById(int id);
	
	List<Ability> findAllAbilities();

	Ability searchById(int id);

	List<Ability> searchByName(String name);
	
	void saveAbility(Ability ab);

}
