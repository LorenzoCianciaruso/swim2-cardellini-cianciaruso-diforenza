package it.polimi.swimv2.business;

import javax.ejb.Remote;

@Remote
public interface IAbilitiesDeclared {

	void saveAbilityDeclared(int idAbility, int userId);

}
