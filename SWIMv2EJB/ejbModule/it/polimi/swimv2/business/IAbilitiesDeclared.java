package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.AbilitiesDeclared;

import javax.ejb.Remote;

@Remote
public interface IAbilitiesDeclared {

	void saveAbilityDeclared(AbilitiesDeclared abDec);

	List<AbilitiesDeclared> searchByUserId(int id);
	
	List<AbilitiesDeclared> searchByAbilityId(int id);

	void remove(int id);
	
	

}
