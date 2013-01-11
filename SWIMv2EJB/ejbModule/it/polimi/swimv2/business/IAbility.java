package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.Ability;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IAbility {

	void save(Ability ab);
	
	List<Ability> allAbilities();

	Ability findById(int id);

	List<Ability> findByName(String name);
	
	void remove(int id);

}
