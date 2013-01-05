package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.AbilitiesDeclared;

import javax.ejb.Remote;

@Remote
public interface IAbilitiesDeclared {

	void saveAbilityDeclared(AbilitiesDeclared abDec);

	List<AbilitiesDeclared> findAbilitiesOwnedByUserId(int id);

	void remove(AbilitiesDeclared abilitiesDeclared);
	
	List<AbilitiesDeclared> searchAbilitiesDeclaredById(int id);
	

}
