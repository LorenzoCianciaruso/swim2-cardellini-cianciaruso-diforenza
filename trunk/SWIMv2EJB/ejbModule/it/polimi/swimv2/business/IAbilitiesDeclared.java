package it.polimi.swimv2.business;

import it.polimi.swimv2.entities.AbilitiesDeclared;

import javax.ejb.Remote;

@Remote
public interface IAbilitiesDeclared {

	void saveAbilityDeclared(AbilitiesDeclared abDec);

}
