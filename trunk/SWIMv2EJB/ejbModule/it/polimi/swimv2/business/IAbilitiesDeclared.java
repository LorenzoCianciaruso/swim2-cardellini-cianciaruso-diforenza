package it.polimi.swimv2.business;

import java.util.List;

import it.polimi.swimv2.entities.AbilitiesDeclared;
import it.polimi.swimv2.entities.Ability;
import it.polimi.swimv2.entities.User;

import javax.ejb.Remote;

@Remote
public interface IAbilitiesDeclared {

	void saveAbilityDeclared(AbilitiesDeclared abDec);

	List<AbilitiesDeclared> findAbilitiesOwnedByUser(AbilitiesDeclared abDec);

}
